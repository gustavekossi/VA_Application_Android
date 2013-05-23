package modele;

public class BonPlan {
	private String var_name;
	private String var_desc;
	private int var_id;
	private int var_id_poi;
	
	public BonPlan(String name,String description ,int identifiant,int id_poi) {
		var_name =  name;
		var_desc = description;
		var_id = identifiant;
		var_id_poi = id_poi;
	}

	public String getVar_name() {
		return var_name;
	}

	public void setVar_name(String var_name) {
		this.var_name = var_name;
	}

	public String getVar_desc() {
		return var_desc;
	}

	public void setVar_desc(String var_desc) {
		this.var_desc = var_desc;
	}

	public int getVar_id() {
		return var_id;
	}

	public void setVar_id(int var_id) {
		this.var_id = var_id;
	}

	public int getVar_id_poi() {
		return var_id_poi;
	}

	public void setVar_id_poi(int var_id_poi) {
		this.var_id_poi = var_id_poi;
	}
}
