package com.sitrak.sopa.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValoresSopa implements Serializable{

	private static final long serialVersionUID = 8722353771611430838L;
	
	private Integer w = 15;		//Ancho de la sopa de letras, valor opcional por defecto debe ser 15 max 80
	private Integer h = 15;		//Largo de la sopa de letras, valor opcional pode defecto debe ser 15 max 80
	private Boolean ltr = Boolean.TRUE;	//Habilitar o des. palabras que van de izquierda a derecha, valor opcional por defecto true
	private Boolean rtl = Boolean.FALSE;	//Habilitar o des. palabras que van de derecha a izquierda, valor opcional por defecto false
	private Boolean ttb = Boolean.TRUE;	//Habilitar o deshabilitar palabras que van desde arriba hacia abajo, valor opcional por defecto true
	private Boolean btt = Boolean.FALSE;	//Habilitar o deshabilitar palabras que van desde abajo hacia arriba, valor opcional por defecto false	
	private Boolean d = Boolean.FALSE;		//Habilitar o deshabilitar palabras diagonales, valor opcional por defecto false
	
	public Integer getW() {
		return w;
	}
	public void setW(Integer w) {
		this.w = w;
	}
	public Integer getH() {
		return h;
	}
	public void setH(Integer h) {
		this.h = h;
	}
	public Boolean getLtr() {
		return ltr;
	}
	public void setLtr(Boolean ltr) {
		this.ltr = ltr;
	}
	public Boolean getRtl() {
		return rtl;
	}
	public void setRtl(Boolean rtl) {
		this.rtl = rtl;
	}
	public Boolean getTtb() {
		return ttb;
	}
	public void setTtb(Boolean ttb) {
		this.ttb = ttb;
	}
	public Boolean getBtt() {
		return btt;
	}
	public void setBtt(Boolean btt) {
		this.btt = btt;
	}
	public Boolean getD() {
		return d;
	}
	public void setD(Boolean d) {
		this.d = d;
	}
	
	@Override
	public String toString() {
		return "ValoresSopa [" + (w != null ? "w=" + w + ", " : "") + (h != null ? "h=" + h + ", " : "")
				+ (ltr != null ? "ltr=" + ltr + ", " : "") + (rtl != null ? "rtl=" + rtl + ", " : "")
				+ (ttb != null ? "ttb=" + ttb + ", " : "") + (btt != null ? "btt=" + btt + ", " : "")
				+ (d != null ? "d=" + d : "") + "]";
	}
}
