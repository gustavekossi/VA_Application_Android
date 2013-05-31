package com.example.va_application_android;

import java.util.ArrayList;
import java.util.HashMap;

import modele.UserData;

import com.example.va_application_android.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class VueListeActualites extends Activity{
	
	static public ListView var_listeView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.liste_actualites);
		
		var_listeView = (ListView) findViewById(R.id.id_actuView_listeView);

		
		this.rechargerlist();
		
		
	}
	
	
	
	
public void rechargerlist(){
    	
    	
    	
    	// debut du remplissage des cellules
        
        
        
        //Cr�ation de la ArrayList qui nous permettra de remplire la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
 
        //On d�clare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
 
        
        // cr�ation des celulles de la liste
        
        int var_nbActu = UserData.shared_instance().var_Array_Actu.size() ;
        
       for( int i = 0 ; i < var_nbActu ; i++ ){
        	
        	
        map = new HashMap<String, String>();
        map.put("titre", UserData.shared_instance().var_Array_Actu.elementAt(i).getVar_name() );
        map.put("description", UserData.shared_instance().var_Array_Actu.elementAt(i).getVar_desc() );
        map.put("img", String.valueOf(R.drawable.icone_news));
        listItem.add(map);
        
        }
 
        //Cr�ation d'un SimpleAdapter qui se chargera de mettre les items pr�sent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter ( this , listItem, R.layout.layout_liste_cell,
               new String[] {"img", "titre", "description"}, new int[] {R.id.id_listeCell_image, R.id.id_listeCell_titre, R.id.id_listeCell_description});
 
        //On attribut � notre listView l'adapter que l'on vient de cr�er
        var_listeView.setAdapter(mSchedule);
         	
        
        
        
        
    	
    }

}
