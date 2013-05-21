package com.example.va_application_android;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.va_application_android.R;
import android.app.Activity;
import android.os.Bundle;


public class MenuActivity extends Activity {
     int compteur;
	Button btnGche,btnMilieu,btnDrt;
	String[] tab_menu ={"Explorer","Bon Plan","A proximité","Actualités","Info"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_menu);
		compteur = -1;
		btnGche =(Button)findViewById(R.id.buttonGche);
		btnMilieu =(Button)findViewById(R.id.buttonMilieu);
		btnDrt =(Button)findViewById(R.id.buttonDrt);

		//      gestion bouton gauche
		btnGche.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("bntTest", "msg :");
				compteur-- ;
				int value=compteur;
				
				
				if(compteur < 0){
					compteur =tab_menu.length-1;
					//btnMilieu.setText(tab_menu[compteur]);
					//compteur--;
				}
				btnMilieu.setText(tab_menu[compteur]);
			}
		});
		//      gestion bouton milieu
		btnMilieu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent ouvrirBonPlan;

				if(compteur == 0){
					 ouvrirBonPlan = new Intent("com.example.va_application_android.VUECARTEPOI");
						Toast.makeText(MenuActivity.this,
								"Button Explorer cliqué!", Toast.LENGTH_SHORT).show();
						String check = btnMilieu.getText().toString();
					startActivity(ouvrirBonPlan);
				}
				else if (compteur == 1) {
					 ouvrirBonPlan = new Intent("com.example.va_application_android.LISTEBONPLAN");
					startActivity(ouvrirBonPlan);
				}
				else if (compteur == 2) {
					 ouvrirBonPlan = new Intent("com.example.va_application_android.VUERECHERCHERPOI");
					startActivity(ouvrirBonPlan);
				}
				else if (compteur == 3) {
					 ouvrirBonPlan = new Intent("com.example.va_application_android.LISTEACTUALITES");
					startActivity(ouvrirBonPlan);
				}
//				switch (compteur) {
//				case 0:ouvrirBonPlan = new Intent("com.projetm1_test.VUECARTEPOI");
//			           startActivity(ouvrirBonPlan);
//					break;
//	            case 1:ouvrirBonPlan = new Intent("com.projetm1_test.LISTEBONPLAN");
//	          	       startActivity(ouvrirBonPlan);
//					break;
//	            case 2:ouvrirBonPlan = new Intent("com.projetm1_test.VUERECHERCHERPOI");
//	            	   startActivity(ouvrirBonPlan);
//					break;
//	            case 3:ouvrirBonPlan = new Intent("com.projetm1_test.LISTEACTUALITES");
//       	       startActivity(ouvrirBonPlan);
//					break;
//				default:
//					break;
//				}
			}
		});
		
		//      gestion bouton droit
		btnDrt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				compteur++;
				
				if(compteur >= 5){
					compteur = 0;
				}
				btnMilieu.setText(""+tab_menu[compteur]);
			}
		});
	}
  

	@Override
	protected void onPause() {
		super.onPause();
	}


}

