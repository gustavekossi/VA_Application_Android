package com.example.va_application_android;

import android.R.anim;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VueListeBonPlan extends ListActivity{

	String[] lesBonPlans={"BonPlan1","bonplan2","bonplan3","bonplan4","bonplan5","bonplan6,bonplan7"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(VueListeBonPlan.this, android.R.layout.simple_list_item_1,lesBonPlans));
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
//		retrieve differents activites from the array
		String nomActivite = lesBonPlans[position];
		try {
			Class laClass = Class.forName("com.projetm1_test."+nomActivite);
			Intent leIntent = new Intent(VueListeBonPlan.this,laClass);
			startActivity(leIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
