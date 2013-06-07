package com.example.va_application_android;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import modele.Poi;
import modele.SqliteManager;
import modele.UpdateSqlite;
import modele.UserData;
import modele.WebServiceMeteo;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.va_application_android.R;
import com.google.zxing.client.android.CaptureActivity;

import android.app.Activity;
import android.os.Bundle;


public class VueMenuActivity extends Activity {
    
	int compteur;
	Button btnGche,btnMilieu,btnDrt,var_bt_Info,var_bt_qrcode;
	TextView var_textViewTitre ;
	TextView var_textViewTemperature ;
	static public VueMenuActivity theInstance = null ;
	
	//   menu ‡ l'Ècran
	String[] tab_menu ={"Explorer","Bon Plan","A proximité","Actualités"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);	
		
		theInstance = this ;
		
		UpdateSqlite.shared_instance().Update();	
	
		setContentView(R.layout.activity_menu);
		
		compteur = 0;
		btnGche =(Button)findViewById(R.id.buttonGche);
		btnMilieu =(Button)findViewById(R.id.buttonMilieu);
		btnDrt =(Button)findViewById(R.id.buttonDrt);
		var_bt_Info = (Button)findViewById(R.id.btnInfo);
		var_bt_qrcode = (Button)findViewById(R.id.btnQrCode);
		
		var_textViewTitre = (TextView)findViewById(R.id.id_titre);
		var_textViewTemperature = (TextView)findViewById(R.id.menu_texte_temperature);
		
		var_textViewTitre.setText(tab_menu[0]);
		
		//      gestion bouton gauche
		btnGche.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
			
				Log.d("bntTest", "msg :");
				compteur-- ;
				
				
				if(compteur < 0){
					compteur =tab_menu.length-1;
				}
				//btnMilieu.setText(tab_menu[compteur]);
				var_textViewTitre.setText(tab_menu[compteur]);
			}
		});
		
		//      gestion bouton milieu
		btnMilieu.setOnClickListener(new OnClickListener() {
			@Override
			
			public void onClick(View v) {
				Intent var_prochainePage;
				
				if(compteur == 0){
					var_prochainePage = new Intent("com.example.va_application_android.VUELISTEPOI");
						Toast.makeText(VueMenuActivity.this,
								"Button Explorer cliquÈ!", Toast.LENGTH_SHORT).show();
					startActivity(var_prochainePage);
				}
				else if (compteur == 1) {
					var_prochainePage = new Intent("com.example.va_application_android.LISTEBONPLAN");
					startActivity(var_prochainePage);
				}
				else if (compteur == 2) {
					var_prochainePage = new Intent("com.example.va_application_android.VUEREALITEAUGMENTEE");
					startActivity(var_prochainePage);
				}
				else if (compteur == 3) {
					var_prochainePage = new Intent("com.example.va_application_android.LISTEACTUALITES");
					startActivity(var_prochainePage);
				}
			}
		});
		
		
		//      gestion bouton droit
		btnDrt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				compteur++;
				
				if(compteur >= 4){
					compteur = 0;
				}
				//btnMilieu.setText(""+tab_menu[compteur]);
				var_textViewTitre.setText(tab_menu[compteur]);
			}
		});
		
		
		
		//      gestion bouton info
		var_bt_Info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 
				Intent	var_prochainePage = new Intent("com.example.va_application_android.VUEINFO");
				startActivity(var_prochainePage);
			}
		});
		//      gestion bouton qr code	
		
		var_bt_qrcode.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 
				Intent	var_prochainePage = new Intent(VueMenuActivity.this, CaptureActivity.class);
				var_prochainePage.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(var_prochainePage,0);

			}
		});

		
		
		
		
		/*
		/// BDD 
		
		// copier bdd
		
		
		
		try {

            String destPath = "/data/data/" + getPackageName()
                    + "/databases/archive_android.sqlite";

            Log.v("debug","package ="+getPackageName());
            
            File f = new File(destPath);
            if(!f.exists()){
            Log.v("debug","File Not Exist");
            InputStream in = getAssets().open("archive_android.sqlite");
            OutputStream out = new FileOutputStream(destPath);

            byte[] buffer = new byte[1024];
            int length;
            
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            
            in.close();
            out.close();
            
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Log.v("debug","ioexeption");
            e.printStackTrace();
        }

		SqliteManager dbManager =  new SqliteManager(this);
        Log.v("debug","Database is there with version: "+dbManager.getReadableDatabase().getVersion());
        String sql = "select * from t_poi";

        SQLiteDatabase db = dbManager.getReadableDatabase();
        
        Cursor cursor = db.rawQuery(sql, null);
        
        Log.v("debug","Query Result:"+cursor);

        while (cursor.moveToNext()) {
        	
        	//Log.v("debug","1-> "+cursor.getString(0));
        	//Log.v("debug","2-> "+cursor.getString(1));
        	//Log.v("debug","3-> "+cursor.getString(3));
        	//Log.v("debug","4-> "+cursor.getString(4));
        	
        	Poi temp_poi = new Poi(
        			
        			cursor.getString(1), 
        			cursor.getString(7), 
        			cursor.getString(8),
        			Float.parseFloat( cursor.getString(2) ),
        			Float.parseFloat( cursor.getString(3) ),
        			Integer.parseInt( cursor.getString(0) ), 
        			Integer.parseInt( cursor.getString(6) ), 
        			Integer.parseInt( cursor.getString(4)) 
        			
        				);
        	
        	
        	UserData.shared_instance().var_Array_Poi.add(temp_poi);

        	
        	
        }

        cursor.close();
        db.close();
        dbManager.close();
		
		// FIN CHARGEMENT DONNÉES BDD 
        
        */
        
        // Requetes webservice meteo 
        
        WebServiceMeteo.shared_instance().lancerRequete();
        
        
        /// fin webservice 
		
        // mise a jour sqlite :
        
        
        UpdateSqlite.shared_instance().Update();
        
        
	}
	
	
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == 0) {
			
			// rÈcupÈration du QR-Code
			
			
			if(data != null){
			
				
				String var_codeResultat = data.getExtras().getString("codeBarre");
			
			
			// le qrcode doit être du format :   clé + typeQRCode + identifiant 
			
			// clé = key_315325&id_
			// typeQRCode = le type d'opération à faire : p = lancer un detail sur un POI
			//											n = lancer une news 
			//											b = c'est un bon plan 
			// identifiant = un entier qui represente quel POI, News ou bon plan lancer 
			
			// !!!! POUR LE MOMENT JUSTE LES QRCODE DE TYPE POI SERONT UTILISÉS 
			
			
			// je regarde si la clé de confiance : "key_315325&id_" est bien présente dans le code :
			
			if(var_codeResultat.contains("key_315325&id_")){
				
				// dans ce cas c'est ok 
				
				// donc je regarde identifiant et la lettre :
				
				char var_typeQRCode = var_codeResultat.charAt(14);
		        String var_string_ident = var_codeResultat.substring(14+1);
		       
		        int var_int_ident = Integer.parseInt(var_string_ident);
				
		        Toast.makeText(getApplicationContext(), "QRCode reconnu type = "+var_typeQRCode+" et identifiant = "+var_int_ident, Toast.LENGTH_LONG).show();
				
		        // si l'identifiant est correct il doit être > 0 donc : 
		        
		        if(var_int_ident > 0){
		            
		        	// je fais un traitement en fonction du type de qrcode
		        	
		            switch (var_typeQRCode) {
		                case 'n':
		                    
		                    // c'est une news ON FAIT RIEN 
		                    
		                    break;
		                    
		                case 'b':
		                    
		                    // c'est un bon plan ON FAIT RIEN
		                    
		                    
		                    break;
		                    
		                    
		                case 'p':
		                
			                
		                	// c'est un POI
		                    
		                	Intent	var_prochainePage = new Intent("com.example.va_application_android.VUEDETAILLEEPOI");
		                	var_prochainePage.putExtra("ID_POI", var_int_ident);
		             
		                	startActivity(var_prochainePage);
		                  
		                    break;
		                    
		                
		            } // fin switch 
		        } // fin if(ident > 0)
		        
			}else{
				
				// sinon le QRCode n'est pas de nous :
				Toast.makeText(getApplicationContext(), "QRCode non reconnu", Toast.LENGTH_LONG).show();
				
			}
			
			
			}
			
		
		}
		
		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	
	public void ajoutTemperatureOnScrenn(){
		
		var_textViewTemperature.setText( "Temperature "+WebServiceMeteo.var_temprature+"°C  Humidité "+WebServiceMeteo.var_humidity+"%");
		
	}
	
}

