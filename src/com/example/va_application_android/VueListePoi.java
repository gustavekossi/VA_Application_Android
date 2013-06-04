package com.example.va_application_android;

import java.util.ArrayList;
import java.util.HashMap;

import modele.UserData;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class VueListePoi extends Activity {
	static public ListView var_listeView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.liste_poi);
		var_listeView = (ListView) findViewById(R.id.id_poi_listeView);
		this.rechargerlist();
		
	}
	
	public void rechargerlist(){
    	// debut du remplissage des cellules
        
        //Cr�ation de la ArrayList qui nous permettra de remplire la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
 
        //On d�clare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
        // cr�ation des celulles de la liste
        
        int var_nbPoi = UserData.shared_instance().var_Array_Poi.size() ;
        
       for( int i = 0 ; i < var_nbPoi ; i++ ){
        	
        map = new HashMap<String, String>();
        map.put("titre", UserData.shared_instance().var_Array_Poi.elementAt(i).getVar_name() );
        map.put("description", UserData.shared_instance().var_Array_Poi.elementAt(i).getVar_resume() );
        
        switch (UserData.shared_instance().var_Array_Poi.elementAt(i).getVar_type()) {
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
        //Cr�ation d'un SimpleAdapter qui se chargera de mettre les items pr�sent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter ( this , listItem, R.layout.layout_liste_cell,
               new String[] {"img", "titre", "description"}, new int[] {R.id.id_listeCell_image, R.id.id_listeCell_titre, R.id.id_listeCell_description});
        //On attribut � notre listView l'adapter que l'on vient de cr�er
        var_listeView.setAdapter(mSchedule);
        
    }

	
}
