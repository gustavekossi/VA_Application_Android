package modele;

import java.util.Vector;

public class UserData {

	public Vector<Poi> var_Array_Poi;
	public Vector<Actualite> var_Array_Actu;
	public Vector<BonPlan> var_Array_BonPlan;
	
	private static UserData var_instance = null;
	
	public UserData() {
		var_Array_Poi = new Vector<Poi>();
		var_Array_Actu = new Vector<Actualite>();
		var_Array_BonPlan = new Vector<BonPlan>();
		generateContentPoi();
	}	

	public static UserData shared_instance() {
		if(var_instance == null){
			var_instance = new UserData();  
		}
		return var_instance;
	}
	public void generateContentPoi(){
		var_Array_Poi.add(new Poi("mus�e de Valenciennes", "cr�e en 1933", "1er mus�e du nord", 88, 44, 2, 15, 6));
		var_Array_Poi.add(new Poi("piscine", "centre ville", "piscine VA", 75, 33,8, 95, 4));
		var_Array_Poi.add(new Poi("bistro de VA", "rue du compte", "pourri", 78, 48,24, 65, 9));
		var_Array_Poi.add(new Poi("gare", "ancienne gare", "abime", 18, 34,3, 85, 7));
		var_Array_Poi.add(new Poi("saint james", "excentr�", "boite", 47, 37,6, 55, 8));
	}
	public void generateContentActu(){
		var_Array_Actu.add(new Actualite("concert trio", "place de la gare", 42, 4));
		
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
}
