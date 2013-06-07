package com.example.va_application_android;

import modele.Poi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.view.View;
import android.widget.RelativeLayout;



public class MarqueurPOI extends View {
	



	public Poi var_poi ;
	
	Point coordonneeMarqeur = new Point();
	
	
	
	MarqueurPOI( Context _context , Poi _poi){
		
		super(_context);
		this.var_poi = _poi ;
		
		
		RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams( 10	, 10);
        param.topMargin = 10 ; param.leftMargin = 10 ;
        this.setLayoutParams(param);
       
        this.setBackgroundColor(Color.BLUE);
        
	}
	
	
	void moveTo(int _x , int _y){
		
		RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams( 10	, 10);
        param.topMargin = _y ; param.leftMargin = _x ;
        this.setLayoutParams(param);
       
		
		
	}
	
	
}







