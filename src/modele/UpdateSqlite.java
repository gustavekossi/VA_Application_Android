package modele;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.Vector;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

public class UpdateSqlite{


	
	
	private static UpdateSqlite var_instance = null;
	
	
	// execute this when the downloader must be fired
	
	
	public UpdateSqlite() {
		
		
	}	

	public static UpdateSqlite shared_instance() {
		if(var_instance == null){
			var_instance = new UpdateSqlite();  
		}
		return var_instance;
	}
	
	
	public void Update(){
		
		

		new UpdateSqliteManager().execute(null, null, null);
		
		
		
	}
	
}










	
		
       
        






class UpdateSqliteManager extends AsyncTask<Void, Integer, Void> {
  
	protected Void doInBackground(Void... arg0) {
		
		
        
		try {
			
			
			String theFisrtURL = "http://88.191.145.50/ProjetMaster/mobile/version.php";

			
			URL url = new URL(theFisrtURL);
	        InputStream input = url.openConnection().getInputStream();
	      
	        String resultat = this.convertStreamToString(input);
	        
	        //resultat.replaceAll("[\\t\\r\\n]", "");

	        Scanner sc = new Scanner(resultat);
	        int valeur = sc.nextInt();
	        
			//int valeur = Integer.parseInt(resultat);
	      	
			
			String stringSqliteURL = "http://88.191.145.50/ProjetMaster/mobile/bdd/"+valeur+".sqlite";

			
			URL sqliteURL = new URL(stringSqliteURL);
	        
			Log.d("DEBUT", "url = "+sqliteURL);
			
	      	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	
   }

	


   protected void onProgressUpdate(Integer... progress) {
    
   	

   }

   protected void onPostExecute(Void result) {
     
   	
   
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

    


