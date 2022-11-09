package com.sitrak.sopa.service;

import com.sitrak.sopa.model.Coordenadas;
import com.sitrak.sopa.model.Sopa;
import com.sitrak.sopa.model.ValoresSopa;

public interface SopaService {

	Sopa cargarMatriz(Sopa sopa, ValoresSopa valoresSopa);
	
	void validarSopa(ValoresSopa valoresSopa) throws Exception;
	
	Boolean validarPalabra(Sopa sopa, Coordenadas coordenadas) throws Exception;
}
