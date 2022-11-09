package com.sitrak.sopa.model;

import java.io.Serializable;

public class RespuestaOk extends Respuesta implements Serializable {

	private static final long serialVersionUID = -3353133688459427495L;
	
	private String id;

	public RespuestaOk(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
