package modele;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.example.va_application_android.VueMenuActivity;

import android.os.AsyncTask;
import android.util.Log;


public class WebServiceMeteo {
 
	 
	 static public int var_temprature = -100 ;
	 static public int var_humidity = - 100 ;
	    
	
	 static public int nbNews = 0 ; 
	
	 static public boolean dejaPasse = false ;
     
	 private static WebServiceMeteo var_instance ;

	 

	   public  WebServiceMeteo(){
    	
    	
        	super();
        
         
        }
    
     
	    public static WebServiceMeteo shared_instance() {
		if(var_instance == null){
			var_instance = new WebServiceMeteo();  
		}
		return var_instance;
		}
	  

    
    
	    public void lancerRequete() {
    
        
        
        
     
    		new RequeteManager().execute(null, null, null);
    		
      	
        
        
	    }
    
    
}







	
		
       
        






class RequeteManager extends AsyncTask<Void, Integer, Void> {
  
	protected Void doInBackground(Void... arg0) {
		
		
        
		try {
			
			
			String theURL = "http://weather.yahooapis.com/forecastrss?w=12726104&u=c";

			
			URL url = new URL(theURL);
	        InputStream input = url.openConnection().getInputStream();
	      
	        String resultat = this.convertStreamToString(input);
	        
			Log.d("debug", "resultat requete ="+resultat);
			
	      	int indexDebutAtmosphere = resultat.indexOf("<yweather:atmosphere"); 
	      	int indexFinAtmosphere = resultat.indexOf("/>", indexDebutAtmosphere);
	      	
	      	int indexDebutCondition = resultat.indexOf("<yweather:condition"); 
	      	int indexFinCondition = resultat.indexOf("/>", indexDebutCondition);
	      	
	      	Log.d("debug", "debut atmosphere : "+indexDebutAtmosphere +" fin : "+indexFinAtmosphere);
	      	Log.d("debug", "debut condition : "+indexDebutCondition +" fin : "+indexFinCondition);
	      	
	      	
	      	String condition = resultat.substring(indexDebutCondition + "<yweather:condition".length() , indexFinCondition);
	      	String atmosphere = resultat.substring(indexDebutAtmosphere + "<yweather:atmosphere".length(), indexFinAtmosphere);
	      	
	      	
	      	Log.d("debug", "resultat atmosphere ="+atmosphere);
	      	Log.d("debug", "resultat condition ="+condition);
	      	
	      	int indexDebut_humidity = atmosphere.indexOf("humidity=\""); 
	      	int indexFin_humidity = atmosphere.indexOf("\"", indexDebut_humidity + 10);
	      	
	      	Log.d("debug", "debut humidity : "+indexDebut_humidity +" fin : "+indexFin_humidity);
	      	
	      	String humidity = atmosphere.substring( indexDebut_humidity + 10 , indexFin_humidity);
	      	int inthumidity = Integer.parseInt(humidity);
	      	
	      	
	      	
	      	int indexDebut_temp = condition.indexOf("temp=\""); 
	      	int indexFin_temp = condition.indexOf("\"", indexDebut_temp + 6);
	      	
	      	Log.d("debug", "debut temp : "+indexDebut_temp +" fin : "+indexFin_temp);
	      	
	      	String temp = condition.substring( indexDebut_temp + 6 , indexFin_temp);
	      	int inttemp = Integer.parseInt(temp);
	      	
	      	
	      	
	      	
	      	Log.d("debug", "humidity = "+ inthumidity+" temperature = "+inttemp);
	      	
	      	WebServiceMeteo.var_humidity = inthumidity ;
	      	WebServiceMeteo.var_temprature = inttemp ;
	      	
	      	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	
   }

	


   protected void onProgressUpdate(Integer... progress) {
    
   	

   }

   protected void onPostExecute(Void result) {
     
   	Log.d("debug", "fin - onPostExecute");

   	VueMenuActivity.theInstance.ajoutTemperatureOnScrenn();
   
   }
   
   
   
   
   
   public String convertStreamToString(InputStream is) throws Exception {
	    
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		StringBuilder sb = new StringBuilder();
	    String line = null;
	    
	    while ((line = reader.readLine()) != null) {
	      sb.append(line + "\n");
	    }
	    is.close();
	    
	    
	    return sb.toString();
	}
   
 
   
}
