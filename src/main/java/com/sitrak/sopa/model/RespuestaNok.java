package com.sitrak.sopa.model;

import java.io.Serializable;

public class RespuestaNok extends Respuesta implements Serializable{

	private static final long serialVersionUID = 3948186668594016435L;
	
	public RespuestaNok(String message) {
		super();
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
