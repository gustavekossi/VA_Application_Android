package com.example.va_application_android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import modele.Poi;
import modele.UserData;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class VueListePoi extends Activity  implements OnItemClickListener{
	
	static public ListView var_listeView ;
	static public LinearLayout var_menuLayout ;
	static public Button var_boutonMenu ;
	static public Button var_boutonValiderRecherche ;
	static public boolean var_menuIsShow = false ;
	static public EditText var_textEditRecherche ;
	public Vector<Poi> var_resultatRecherche = new Vector<Poi>();
	static public VueListePoi theInstance = null ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		theInstance = this ;
		setContentView(R.layout.liste_poi);
		var_listeView = (ListView) findViewById(R.id.id_poi_listeView);
		var_listeView.setOnItemClickListener(this);
		var_menuLayout = (LinearLayout) findViewById(R.id.id_listePOI_lineaireLayoutMenu);
		var_boutonMenu = (Button) findViewById(R.id.id_listePOI_boutonMenu);
		var_boutonValiderRecherche =  (Button) findViewById(R.id.id_listePOI_boutonValiderRecherche);
		var_textEditRecherche = (EditText) findViewById(R.id.id_listePOI_textEditRecherche);
		
		
		this.rechargerlist();
		
		
		var_boutonMenu.setOnClickListener(new OnClickListener() {
			@Override
			
			public void onClick(View v) {
				
				if(var_menuIsShow){
					var_menuIsShow = ! var_menuIsShow ;
					var_menuLayout.setVisibility(View.GONE);
				}
				else{
					var_menuIsShow = ! var_menuIsShow ;
					var_menuLayout.setVisibility(View.VISIBLE);
				}
				
			}
		});
		
		
		var_boutonValiderRecherche.setOnClickListener(new OnClickListener() {
			@Override
			
			public void onClick(View v) {
				
				VueListePoi.theInstance.rechargerlist();
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(var_textEditRecherche.getWindowToken(), 0);
				
				if(var_menuIsShow){
					var_menuIsShow = ! var_menuIsShow ;
					var_menuLayout.setVisibility(View.GONE);
				}
				
			}
		});
		
		
		var_listeView.requestFocus();
		
		// renter le clavier 
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(var_textEditRecherche.getWindowToken(), 0);
		
		
	}
	
	public void rechargerlist(){
    	
		var_resultatRecherche.removeAllElements();
		
		// je selectionne les bon élements dans le tableau de resultats
		
		int var_nbPoi = UserData.shared_instance().var_Array_Poi.size() ;
        
	    for( int i = 0 ; i < var_nbPoi ; i++ ){
	        
	    	Poi tempPoi = UserData.shared_instance().var_Array_Poi.elementAt(i) ;
	    	   
	    	if(tempPoi.getVar_name().toLowerCase().contains(var_textEditRecherche.getText().toString().toLowerCase()))
	    	   var_resultatRecherche.addElement( tempPoi );
	    	   
	    }
		
		
		
		// debut du remplissage des cellules
        
        //Création de la ArrayList qui nous permettra de remplire la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
 
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
        // création des celulles de la liste
        
       int var_nbPoiResultatRecherche = this.var_resultatRecherche.size() ;
        
       for( int i = 0 ; i < var_nbPoiResultatRecherche ; i++ ){
        	
        map = new HashMap<String, String>();
        map.put("titre", this.var_resultatRecherche.elementAt(i).getVar_name() );
        map.put("description", this.var_resultatRecherche.elementAt(i).getVar_resume() );
        
        switch (this.var_resultatRecherche.elementAt(i).getVar_type()) {
		case 0:
			 map.put("img", String.valueOf(R.drawable.img_poi_cat0));
			break;
		case 1:
			 map.put("img", String.valueOf(R.drawable.img_poi_cat1));
				break;
		case 2:
			 map.put("img", String.valueOf(R.drawable.img_poi_cat2));
				break;
		case 3:
			 map.put("img", String.valueOf(R.drawable.img_poi_cat3));
				break;
		case 4:
			 map.put("img", String.valueOf(R.drawable.img_poi_cat4));
				break;
		case 5:
			 map.put("img", String.valueOf(R.drawable.img_poi_cat5));
				break;
		case 6:
			 map.put("img", String.valueOf(R.drawable.img_poi_cat6));
				break;
		case 7:
			 map.put("img", String.valueOf(R.drawable.img_poi_cat7));
				break;
	
		default:
		case 8:
			 map.put("img", String.valueOf(R.drawable.img_poi_cat8));
			break;
		}
       
        listItem.add(map);
        
        }
        //Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter ( this , listItem, R.layout.layout_liste_cell,
               new String[] {"img", "titre", "description"}, new int[] {R.id.id_listeCell_image, R.id.id_listeCell_titre, R.id.id_listeCell_description});
        //On attribut à notre listView l'adapter que l'on vient de créer
        var_listeView.setAdapter(mSchedule);
        
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "element "+arg2+" cliqué", Toast.LENGTH_SHORT).show();
		
		
		Intent var_prochainePage = new Intent("com.example.va_application_android.VUEDETAILLEEPOI");
		var_prochainePage.putExtra("ID_POI", this.var_resultatRecherche.elementAt(arg2).getVar_ident());
		
		 
		startActivity(var_prochainePage);
		
	}
	
	

	

	
}
