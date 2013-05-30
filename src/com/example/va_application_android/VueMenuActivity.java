package com.example.va_application_android;

import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.va_application_android.R;
import android.app.Activity;
import android.os.Bundle;


public class VueMenuActivity extends Activity {
     int compteur;
	Button btnGche,btnMilieu,btnDrt,var_bt_Info;
//   menu à l'écran
	String[] tab_menu ={"Explorer","Bon Plan","A proximité","Actualités"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		
		setContentView(R.layout.activity_menu);
		
		
		
		
		compteur = 0;
		btnGche =(Button)findViewById(R.id.buttonGche);
		btnMilieu =(Button)findViewById(R.id.buttonMilieu);
		btnDrt =(Button)findViewById(R.id.buttonDrt);
		var_bt_Info = (Button)findViewById(R.id.btnInfo);
				
		btnMilieu.setText(""+tab_menu[0]);

		//      gestion bouton gauche
		btnGche.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Log.d("bntTest", "msg :");
				compteur-- ;
				
				
				if(compteur < 0){
					compteur =tab_menu.length-1;
				}
				btnMilieu.setText(tab_menu[compteur]);
			}
		});
		//      gestion bouton milieu
		btnMilieu.setOnClickListener(new OnClickListener() {
			@Override
			
			public void onClick(View v) {
				Intent var_prochainePage;
				
				if(compteur == 0){
					var_prochainePage = new Intent("com.example.va_application_android.VUECARTEPOI");
						Toast.makeText(VueMenuActivity.this,
								"Button Explorer cliqué!", Toast.LENGTH_SHORT).show();
					startActivity(var_prochainePage);
				}
				else if (compteur == 1) {
					var_prochainePage = new Intent("com.example.va_application_android.LISTEBONPLAN");
					startActivity(var_prochainePage);
				}
				else if (compteur == 2) {
					var_prochainePage = new Intent("com.example.va_application_android.VUERECHERCHERPOI");
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
				btnMilieu.setText(""+tab_menu[compteur]);
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
		
	}
	

	@Override
	protected void onPause() {
		super.onPause();
	}
	
	
	
	
	
	
}

