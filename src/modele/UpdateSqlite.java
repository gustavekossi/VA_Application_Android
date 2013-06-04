package modele;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import android.os.AsyncTask;
import android.os.Environment;

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
		
		
		
		DownloadFile downloadFile = new DownloadFile();
		downloadFile.execute("http://88.191.145.50/ProjetMaster/mobile/bdd/1370264885.sqlite");
		
		
	}
	
}





class DownloadFile extends AsyncTask<String, Integer, String> {
   
	
	@Override
    protected String doInBackground(String... sUrl) {
        try {
        	
        	URL url = new URL(sUrl[0]);
            URLConnection connection = url.openConnection();
            connection.connect();
            // this will be useful so that you can show a typical 0-100% progress bar
            int fileLength = connection.getContentLength();

            // download the file
            InputStream input = new BufferedInputStream(url.openStream());
             
                    
           OutputStream output = new FileOutputStream(Environment.getRootDirectory()+"/archive.sqlite");

           System.out.print("seve on  "+Environment.getRootDirectory()+"/archive.sqlite");
           
           
            byte data[] = new byte[1024];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                total += count;
                // publishing the progress....
                //publishProgress((int) (total * 100 / fileLength));
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {
        }
        return null;
    }
    
    
    @Override
    protected void onPreExecute() {
      
    	super.onPreExecute();
        
    	System.out.print("save terminé");
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        

    }
    
    
}
    
    


