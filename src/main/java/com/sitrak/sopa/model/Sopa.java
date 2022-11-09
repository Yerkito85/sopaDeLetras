package com.sitrak.sopa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Sopa implements Serializable{

	private static final long serialVersionUID = 8722353771611430838L;
	
	private String id;
	private ArrayList<String> palabras;
	private String[][] sopaLetras;
		
	public Sopa(String id) {
		super();
		this.id = id;
	}
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<String> getPalabras() {
		return palabras;
	}
	
	public void setPalabras(ArrayList<String> palabras) {
		this.palabras = palabras;
	}
	
	public String[][] getSopaLetras() {
		return sopaLetras;
	}
	
	public void setSopaLetras(String[][] sopaLetras) {
		this.sopaLetras = sopaLetras;
	}

	@Override
	public String toString() {
		return "Sopa [" + (id != null ? "id=" + id + ", " : "")
				+ (palabras != null ? "palabras=" + palabras + ", " : "")
				+ (sopaLetras != null ? "sopaLetras=" + Arrays.toString(sopaLetras) : "") + "]";
	}


}
