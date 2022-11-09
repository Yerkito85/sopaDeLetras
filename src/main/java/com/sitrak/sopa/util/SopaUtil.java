package com.sitrak.sopa.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sitrak.sopa.model.ValoresSopa;

public class SopaUtil {
	
	final static Logger logger = LoggerFactory.getLogger(SopaUtil.class);

	private static String[] palabrasArreglo = {"color","blanco","negro","gris","rojo","naranja","amarillo","verde",
												"celeste","azul","violeta","rosado","cultura","autor","espectador",
												"entretenimiento","arte","cine","dibujo","pintura","dios","escuela",
												"instituto","colegio","universidad","clase","curso","estudio","conocimiento",
												"idea","dato","forma","manera","modo","estilo","figura","elemento","ciencia",
												"historia","deporte","carrera","competencia","ayuda","favor","apoyo","duda",
												"pregunta","respuesta","solicitud","consejo","sugerencia","orden","control",
												"sistema","trabajo","empleo","esfuerzo","lugar","movimiento","velocidad",
												"largo","longitud","alto","altura","ancho","aumento","crecimiento","fondo",
												"frente","cosa","aspecto","contenido","objeto","parte","sector","palabra",
												"nombre","condimento","secreto","formalidad","presente","pasado","futuro","vez",
												"actividad","acto","programa","proyecto","obra","acuerdo","actitud","atento",
												"capacidad","concepto","tema","caso","conjunto","grupo","crear","origen",
												"destino","objetivo","meta","funcional","pareja","realidad","problema","intento",
												"efecto","resultado","logro","fracaso","causa","consecuencia","beneficio","perjuicio",
												"calidad","tipo","ataque","defensa","paz","conflicto","guerra","crisis","cambio",
												"desarrollo","progreso","avance","retroceso","mejora","deterioro","comienzo","inicio",
												"principio","transcurso","final","cabo","etapa","fase","paso","serie","secuencia",
												"grado","nivel","proceso","corte","espera","diferencia","similitud","sentido",
												"sensato","vista","oreja","tacto","olfato","dolor","conciencia","buzo","imagen","fuerza",
												"potencia","presencia","existencia","experiencia","posibilidad","probabilidad","verdad",
												"mentira","bus","acierto","necesidad","falta","significado","amor","personalidad",
												"pensamiento","memoria","recuerdo","deseo","tristeza","enojo","enfado","placer",
												"aburrimiento","cansancio","sorpresa","susto","seguridad","confianza","miedo","temor",
												"ejemplo","malo","superior","inferior","cierto","real","falso","mayor","odio","globo"};
	
	private final static List<String> palabrasList = Arrays.asList(palabrasArreglo);
	
	public static ArrayList<String> generarPalabras(int cantidadPalabras) {		
		ArrayList<String> palabras = new ArrayList<>();
		
		for (int i = 0; i < cantidadPalabras; i++) {
			int posicion = (int) (Math.random()*199+1);
			if (palabras.contains(palabrasList.get(posicion))) {
				continue;
			} else {
				palabras.add(palabrasList.get(posicion));
			}
		}
		return palabras;
	}
	
	public static String generarTextoSopa(String[][] sopa) {
		String sopaStr ="";
		
		for (int i = 0; i < sopa.length; i++) {
			for (int j = 0; j < sopa[i].length; j++) {
				
				sopaStr += sopa[i][j] + " "; 
			}
			sopaStr += "\n";
		}
		return sopaStr;
	}
	
	public static ArrayList<String> generarPosiciones(ValoresSopa valoresSopa) {
		
		ArrayList<String> opciones = new ArrayList<>();
		if (valoresSopa.getLtr()) {
			opciones.add("horizontalNormal");
		}
		if (valoresSopa.getRtl()) {
			opciones.add("horizontalInvertida");
		}
		if (valoresSopa.getTtb()) {
			opciones.add("verticalNormal");
		}
		if (valoresSopa.getBtt()) {
			opciones.add("verticalInvertida");
		}
		if (valoresSopa.getD()) {
			opciones.add("diagonalLtrNormal");
			opciones.add("diagonalLtrInvertida");
			opciones.add("diagonalRtlNormal");
			opciones.add("diagonalRtlInvertida");
		}
		return opciones;
		
	}
}
