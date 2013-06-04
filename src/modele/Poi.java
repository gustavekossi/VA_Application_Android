package modele;

import android.provider.MediaStore.Images;

public class Poi {

	private String var_name;
	private String var_description;
	private String var_resume;
	private float var_longitude;
	private float var_latitude;
	private int var_ident;
	private int var_image;
	private int var_type;

	public Poi(String var_n, String var_d, String var_r,float var_long,
			float var_lat,int var_id,int var_img,int var_typ) {
	    this.var_name = var_n;
	    this.var_description = var_d;
	    this.var_resume = var_r;
	    this.var_longitude = var_long;
	    this.var_latitude = var_lat;
	    this.var_ident = var_id;
	    this.var_image = var_img;
	    this.var_type = var_typ;
	}

	public String getVar_name() {
		return var_name;
	}

	public void setVar_name(String var_name) {
		this.var_name = var_name;
	}

	public String getVar_desc() {
		return var_description;
	}

	public void setVar_desc(String var_desc) {
		this.var_description = var_desc;
	}

	public String getVar_resume() {
		return var_resume;
	}

	public void setVar_resume(String var_resume) {
		this.var_resume = var_resume;
	}

	public float getVar_longitude() {
		return var_longitude;
	}

	public void setVar_longitude(float var_longitude) {
		this.var_longitude = var_longitude;
	}

	public float getVar_latitude() {
		return var_latitude;
	}

	public void setVar_latitude(float var_latitude) {
		this.var_latitude = var_latitude;
	}

	public int getVar_ident() {
		return var_ident;
	}

	public void setVar_ident(int var_ident) {
		this.var_ident = var_ident;
	}

	public int getVar_image() {
		return var_image;
	}

	public void setVar_image(int var_image) {
		this.var_image = var_image;
	}

	public int getVar_type() {
		return var_type;
	}

	public void setVar_type(int var_type) {
		this.var_type = var_type;
	}
	
	
	
	
}
