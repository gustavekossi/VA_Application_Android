package modele;

import java.util.Vector;

public class UserData {

	public Vector<Poi> var_Array_Poi;
	public Vector<Actualite> var_Array_Actu;
	public Vector<BonPlan> var_Array_BonPlan;
	
	private static UserData var_instance = null;
	
	public UserData() {
		
		super();
		var_Array_Poi = new Vector<Poi>();
		var_Array_Actu = new Vector<Actualite>();
		var_Array_BonPlan = new Vector<BonPlan>();
		
		generateContentPoi();
		generateContentActu();
		generateContentBonPlan();
		
		
 	
	}	

	public static UserData shared_instance() {
		if(var_instance == null){
			var_instance = new UserData();  
		}
		return var_instance;
	}
	
	public void generateContentPoi(){
		
		
		
		var_Array_Poi.add(new Poi("musée de Valenciennes", "crée en 1933", "1er musée du nord", 88, 44, 2, 15, 0));
		var_Array_Poi.add(new Poi("bistro de VA", "rue du compte", "pourri", 78, 48,24, 65, 1));
		var_Array_Poi.add(new Poi("gare", "ancienne gare", "abime", 18, 34,3, 85, 1));
		var_Array_Poi.add(new Poi("saint james", "excentré", "boite", 47, 37,6, 55, 2));
		
		var_Array_Poi.add(new Poi("mairie valenciennes", "---", "----", 47, 37,7, 55, 2));
		var_Array_Poi.add(new Poi("MacDo Tertiale", "---", "----", 47, 37,8, 55, 2));
		var_Array_Poi.add(new Poi("Le phenix", "---", "----", 47, 37,9, 55, 2));
		var_Array_Poi.add(new Poi("theatre De Denain", "---", "----", 47, 37,10, 55, 2));
		
		
		
	}
	public void generateContentActu(){
		var_Array_Actu.add(new Actualite("concert trio", "place de la gare", 42, 4));
		var_Array_Actu.add(new Actualite("concert trio2", "place de la gare", 42, 4));
		var_Array_Actu.add(new Actualite("concert trio3", "place de la gare", 42, 4));
		var_Array_Actu.add(new Actualite("concert trio4", "place de la gare", 42, 4));
		var_Array_Actu.add(new Actualite("concert trio5", "place de la gare", 42, 4));
		var_Array_Actu.add(new Actualite("concert trio6", "place de la gare", 42, 4));
		var_Array_Actu.add(new Actualite("concert trio7", "place de la gare", 42, 4));
		
	}
	public void generateContentBonPlan(){
		var_Array_BonPlan.add(new BonPlan("reduction h&m", "le mercredi 20 mai", 7, 9));
		var_Array_BonPlan.add(new BonPlan("1reduction h&m", "le mercredi 20 mai", 7, 9));
		var_Array_BonPlan.add(new BonPlan("2reduction h&m", "le mercredi 20 mai", 7, 9));
		var_Array_BonPlan.add(new BonPlan("3reduction h&m", "le mercredi 20 mai", 7, 9));
		var_Array_BonPlan.add(new BonPlan("4reduction h&m", "le mercredi 20 mai", 7, 9));
		var_Array_BonPlan.add(new BonPlan("5reduction h&m", "le mercredi 20 mai", 7, 9));
		var_Array_BonPlan.add(new BonPlan("6reduction h&m", "le mercredi 20 mai", 7, 9));
	}
	
	public Poi getPoiFromIdent(int _ident){
		
		
		
		 int var_nbPoi = this.var_Array_Poi.size() ;
	        
	       for( int i = 0 ; i < var_nbPoi ; i++ ){
	    	   
	    	   if(this.var_Array_Poi.elementAt(i).getVar_ident() == _ident){
	    		   
	    		   return this.var_Array_Poi.elementAt(i) ;
	    		   
	    	   }
	    	   
	       }
	       
	     return null ;
	        
		
	}
}
