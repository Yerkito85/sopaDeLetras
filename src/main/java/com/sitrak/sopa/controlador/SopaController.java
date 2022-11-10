package com.sitrak.sopa.controlador;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sitrak.sopa.model.Coordenadas;
import com.sitrak.sopa.model.Respuesta;
import com.sitrak.sopa.model.RespuestaNok;
import com.sitrak.sopa.model.RespuestaOk;
import com.sitrak.sopa.model.Sopa;
import com.sitrak.sopa.model.ValoresSopa;
import com.sitrak.sopa.service.SopaService;
import com.sitrak.sopa.util.ConstantesUtil;
import com.sitrak.sopa.util.SopaUtil;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SopaController {
	
	final static Logger logger = LoggerFactory.getLogger(SopaController.class);
	
	ArrayList<Sopa> sopas;
	@Autowired (required = true)
	private SopaService sopaService;

	@PostMapping(path="/alphabetSoup", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> crearSopaDeLetras(@RequestBody ValoresSopa valoresSopa) {
		try {
			logger.info(valoresSopa.toString());
			
			sopaService.validarSopa(valoresSopa);
			
			Sopa sopa = new Sopa(UUID.randomUUID().toString());
			sopa = sopaService.cargarMatriz(sopa, valoresSopa);
							
			if(sopas == null) {
				sopas = new ArrayList<>();	
			}
			
			sopas.add(sopa);
			return ResponseEntity.ok(new RespuestaOk(sopa.getId()));
		} catch (Exception e) {
			if (!e.getMessage().contains("ERROR: ")) {
				return ResponseEntity.badRequest().body(new RespuestaNok(ConstantesUtil.MSG_ERROR_INTERNO.concat(e.getMessage())));
			} else {
				return ResponseEntity.badRequest().body(new RespuestaNok(e.getMessage()));
			}
		}
	}
	
	@GetMapping(path = "/alphabetSoup/list/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> visualizarListaPalabras(@PathVariable("id") String id) {
		try {
			for (Sopa sopa :  sopas) {
				if (sopa.getId().equals(id)) {
					logger.info(sopa.toString());
					String json = new Gson().toJson(sopa.getPalabras());
					return ResponseEntity.ok(json);				
				}
			}
			return ResponseEntity.badRequest().body(new RespuestaNok("Sopa de Letras no encontrada"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new RespuestaNok("Sopa de Letras no encontrada"));
		}				
	}
	 
	@GetMapping(path = "/alphabetSoup/view/{id}", produces = "text/plain")
	public ResponseEntity<Object> verSopa(@PathVariable("id") String id) {
		try {
			for (Sopa sopa :  sopas) {
				if (sopa.getId().equals(id)) {
					logger.info(sopa.toString());
					return ResponseEntity.ok(SopaUtil.generarTextoSopa(sopa.getSopaLetras()));				
				}
			}
			return ResponseEntity.badRequest().body(new RespuestaNok("Sopa de Letras no encontrada"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new RespuestaNok("Sopa de Letras no encontrada"));
		}
	}
	
	@PutMapping(path = "/alphabetSoup/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> buscarPalabra(@PathVariable(value = "id", required = true) String id, @RequestBody(required = true) Coordenadas coordenadas) {
		try {
			for (Sopa sopa :  sopas) {
				if (sopa.getId().equals(id)) {
					logger.info(sopa.toString());
					logger.info(coordenadas.toString());
					if (sopaService.validarPalabra(sopa, coordenadas)) {
						return ResponseEntity.ok(ConstantesUtil.MSG_EXITO_BUSQUEDA_PALABRA);
					} else {
						return ResponseEntity.badRequest().body(new RespuestaNok(ConstantesUtil.MSG_ERROR_BUSQUEDA_PALABRA));
					}						
				}
			}
			return ResponseEntity.badRequest().body(new RespuestaNok(ConstantesUtil.MSG_ERROR_BUSQUEDA_SOPA));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new RespuestaNok(ConstantesUtil.MSG_ERROR_BUSQUEDA_SOPA.replaceAll("@id", id)));
		}				
	}	
}
