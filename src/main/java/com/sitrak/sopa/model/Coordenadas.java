package com.sitrak.sopa.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordenadas implements Serializable{

	private static final long serialVersionUID = 6839009697912237758L;
	
	private Integer sr = 15;		//Fila donde comienza la palabra encontrada
	private Integer sc = 15;		//Columna donde comienza la palabra encontrada
	private Integer er = 15;		//Fila donde termina la palabra encontrada
	private Integer ec = 15;		//Columna donde termina la palabra encontrada
		
	public Integer getSr() {
		return sr;
	}

	public void setSr(Integer sr) {
		this.sr = sr;
	}

	public Integer getSc() {
		return sc;
	}

	public void setSc(Integer sc) {
		this.sc = sc;
	}

	public Integer getEr() {
		return er;
	}

	public void setEr(Integer er) {
		this.er = er;
	}

	public Integer getEc() {
		return ec;
	}

	public void setEc(Integer ec) {
		this.ec = ec;
	}

	@Override
	public String toString() {
		return "CoordenadasPalabra [" + (sr != null ? "sr=" + sr + ", " : "") + (sc != null ? "sc=" + sc + ", " : "")
				+ (er != null ? "er=" + er + ", " : "") + (ec != null ? "ec=" + ec : "") + "]";
	}
}
