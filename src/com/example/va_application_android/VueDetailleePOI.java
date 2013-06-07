package com.example.va_application_android;

import modele.*;

import com.example.va_application_android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class VueDetailleePOI extends Activity {
	
	private String var_name;
	private String var_desc ;
	private String var_resume ;
	private String var_horraire ;
	private String var_adresse ;
	private String var_siteURL ;
	private String var_mail ;
	private String var_coordinate ;
	private int var_ident;
	private int var_idImage;
	private int var_type ;
	private int var_tel ;
	private int var_importance ;
	private Poi var_current_Poi;
	
	
	TextView var_nom,var_description,var_resum ;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.vue_detaillee_poiparticulier);
		
		
		
		var_nom = (TextView)findViewById(R.id.textName);
		var_description = (TextView)findViewById(R.id.textDescription);
		var_resum = (TextView)findViewById(R.id.textResume);

		Intent intent = getIntent();
		int id = intent.getIntExtra("ID_POI", 0);
		var_current_Poi = UserData.shared_instance().getPoiFromIdent(id);
		
		System.out.println("nom vueDetailleePoi : "+var_nom);
		
		
		var_nom.setText(var_current_Poi.getVar_name());
		var_description.setText(var_current_Poi.getVar_desc());
		var_resum.setText(var_current_Poi.getVar_resume());
		
		
		
	}
}

