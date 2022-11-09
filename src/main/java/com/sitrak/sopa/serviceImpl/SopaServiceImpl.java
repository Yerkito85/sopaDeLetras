package com.sitrak.sopa.serviceImpl;

import java.util.ArrayList;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sitrak.sopa.model.Coordenadas;
import com.sitrak.sopa.model.Sopa;
import com.sitrak.sopa.model.ValoresSopa;
import com.sitrak.sopa.service.SopaService;
import com.sitrak.sopa.util.ConstantesUtil;
import com.sitrak.sopa.util.SopaUtil;

@Service
public class SopaServiceImpl implements SopaService {
	
	final static Logger logger = LoggerFactory.getLogger(SopaServiceImpl.class);

	@Override
	public Sopa cargarMatriz(Sopa sopa, ValoresSopa valoresSopa) {
		// se crea la matriz para trabajar la sopa
		String [][] matrizSopa = new String[valoresSopa.getH()][valoresSopa.getW()];
		// se crean las palabras a incluir en la sopa
		int cantidadPalabras = (valoresSopa.getH() + valoresSopa.getW()) / 5;
		sopa.setPalabras(SopaUtil.generarPalabras(cantidadPalabras));
		
		ArrayList<String> opcionesDePosicion = SopaUtil.generarPosiciones(valoresSopa); 
		opcionesDePosicion.forEach((e) -> {
		      logger.info(e);
	    });
								
		for (String palabra : sopa.getPalabras()) {
			incluirPalabra(valoresSopa, matrizSopa, palabra, obtenerPosicion(opcionesDePosicion));			
		}
		
		rellenarEspaciosBlancos(matrizSopa);
		//imprimirMatriz(matrizSopa);
		sopa.setSopaLetras(matrizSopa);
		
		return sopa;
	}

	private Boolean buscarHorizontalNormal(Sopa sopa, int fila, int columnaIni, int columnaEnd) {
		
		String palabra = "";
		String[][] matrizSopa = sopa.getSopaLetras();
		
		for (int i = columnaIni; i <= columnaEnd; i++) {	
			palabra += matrizSopa[fila][i];			
		}
		logger.info("palabra: "+palabra);
		if (sopa.getPalabras().contains(palabra.toLowerCase())) {
			
			for (int i = columnaIni; i <= columnaEnd; i++) {	
				matrizSopa[fila][i] = matrizSopa[fila][i].toUpperCase();			
			}			
			return Boolean.TRUE;
		}		
		return Boolean.FALSE;
	}
	
	private Boolean buscarHorizontalInvertida(Sopa sopa, int fila, int columnaIni, int columnaEnd) {
		
		String palabra = "";
		String[][] matrizSopa = sopa.getSopaLetras();
		
		for (int i = columnaIni; i >= columnaEnd; i--) {	
			palabra += matrizSopa[fila][i];			
		}
		logger.info("palabra: "+palabra);
		if (sopa.getPalabras().contains(palabra.toLowerCase())) {
			
			for (int i = columnaIni; i >= columnaEnd; i--) {	
				matrizSopa[fila][i] = matrizSopa[fila][i].toUpperCase();			
			}			
			return Boolean.TRUE;
		}		
		return Boolean.FALSE;
	}
	
	private Boolean buscarVerticalNormal(Sopa sopa, int filaIni, int filaFin, int columnaIni) {
		
		String palabra = "";
		String[][] matrizSopa = sopa.getSopaLetras();
		
		for (int i = filaIni; i <= filaFin; i++) {
			palabra += matrizSopa[i][columnaIni];			
		}
		logger.info("palabra: "+palabra);
		if (sopa.getPalabras().contains(palabra.toLowerCase())) {
			
			for (int i = filaIni; i <= filaFin; i++) {	
				matrizSopa[i][columnaIni] = matrizSopa[i][columnaIni].toUpperCase();			
			}			
			return Boolean.TRUE;
		}		
		return Boolean.FALSE;
	}
	
	private Boolean buscarVerticalInvertida(Sopa sopa, int filaIni, int filaFin, int columnaIni) {
		
		String palabra = "";
		String[][] matrizSopa = sopa.getSopaLetras();
		
		for (int i = filaIni; i >= filaFin; i--) {	
			palabra += matrizSopa[i][columnaIni];			
		}
		logger.info("palabra: "+palabra);
		if (sopa.getPalabras().contains(palabra.toLowerCase())) {			
			for (int i = filaIni; i >= filaFin; i--) {	
				matrizSopa[i][columnaIni] = matrizSopa[i][columnaIni].toUpperCase();			
			}			
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	private Boolean buscarDiagonalLtrNormal(Sopa sopa, int filaIni, int filaFin, int columnaIni, int columnaEnd) {
		
		String palabra = "";
		String[][] matrizSopa = sopa.getSopaLetras();
		
		int j = columnaIni;
		for (int i = filaIni; i <= filaFin; i++) {					
			palabra += matrizSopa[i][j];
			j++;
		}
		logger.info("palabra: "+palabra);
		if (sopa.getPalabras().contains(palabra.toLowerCase())) {
			int l = columnaIni;
			for (int k = filaIni; k <= filaFin; k++) {	
				matrizSopa[k][l] = matrizSopa[k][l].toUpperCase();			
				l++;
			}
			return Boolean.TRUE;
		}
			
		return Boolean.FALSE;
	}

	private Boolean buscarDiagonalLtrInvertida(Sopa sopa, int filaIni, int filaFin, int columnaIni, int columnaEnd) {
		
		String palabra = "";
		String[][] matrizSopa = sopa.getSopaLetras();
		
		int j = columnaIni;
		for (int i = filaIni; i >= filaFin; i--) {					
			palabra += matrizSopa[i][j];
			j++;
		}
		logger.info("palabra: "+palabra);
		if (sopa.getPalabras().contains(palabra.toLowerCase())) {
			int l = columnaIni;
			for (int k = filaIni; k >= filaFin; k--) {	
				matrizSopa[k][l] = matrizSopa[k][l].toUpperCase();			
				l++;
			}
			return Boolean.TRUE;
		}
			
		return Boolean.FALSE;
	}

	private Boolean buscarDiagonalRtlNormal(Sopa sopa, int filaIni, int filaFin, int columnaIni, int columnaFin) {
		
		String palabra = "";
		String[][] matrizSopa = sopa.getSopaLetras();
		
		int j = columnaIni;
		for (int i = filaIni; i <= filaFin ; i++) {					
			palabra += matrizSopa[i][j];
			j--;
		}
		logger.info("palabra: "+palabra);
		if (sopa.getPalabras().contains(palabra.toLowerCase())) {
			int l = columnaIni;
			for (int k = filaIni; k <= filaFin; k++) {	
				matrizSopa[k][l] = matrizSopa[k][l].toUpperCase();			
				l--;
			}
			return Boolean.TRUE;
		}		
		return Boolean.FALSE;
	}

	private Boolean buscarDiagonalRtlInvertida(Sopa sopa, int filaIni, int filaFin, int columnaIni, int columnaFin) {
		
		String palabra = "";
		String[][] matrizSopa = sopa.getSopaLetras();
		
		int j = columnaIni;
		for (int i = filaIni; i >= filaFin; i--) {					
			palabra += matrizSopa[i][j];
			j--;
		}
		logger.info("palabra: "+palabra);
		if (sopa.getPalabras().contains(palabra.toLowerCase())) {
			int l = columnaIni;
			for (int k = filaIni; k >= filaFin; k--) {	
				matrizSopa[k][l] = matrizSopa[k][l].toUpperCase();			
				l--;
			}
			return Boolean.TRUE;
		}		
		return Boolean.FALSE;
	}
	
	private void incluirPalabra(ValoresSopa valoresSopa, String[][] matrizSopa,	String palabra, String opcionFinal) {
		
		int fila = 0; 
		int columna = 0;  
		int largo = palabra.length();
		int alto = valoresSopa.getH();
		int ancho = valoresSopa.getW();
		Random numAleatorio = new Random();
		Boolean palabraAceptada = false;
		String[][] matrizSopaAux = new String[alto][ancho];	
		
		switch (opcionFinal) {
		case "horizontalNormal":
			while (!palabraAceptada) {
				matrizSopaAux = matrizSopa.clone();
				fila = (int) (Math.random()*((valoresSopa.getH()-palabra.length()))+1);
				columna = (int) (Math.random()*((valoresSopa.getW()-palabra.length()))+1);
				palabraAceptada = insertarHorizontalNormal(matrizSopa ,palabra, fila, columna);
			}
			matrizSopa = matrizSopaAux.clone();	
			break;
		case "horizontalInvertida":												
			while (!palabraAceptada) {					
				matrizSopaAux = matrizSopa.clone();
				fila = (int) (Math.random()*(valoresSopa.getH()-1)+1);
				columna = (int) Math.floor(Math.random()*(ancho-largo-1)+largo);
				palabraAceptada = insertarHorizontalInvertida(matrizSopaAux, palabra, fila, columna);					
			}		
			matrizSopa = matrizSopaAux.clone();				
			break;
		case "verticalNormal":
			while (!palabraAceptada) {
				matrizSopaAux = matrizSopa.clone();
				fila = (int) (Math.random()*((valoresSopa.getH()-palabra.length()))+1);
				columna = (int) (Math.random()*((valoresSopa.getW()-palabra.length()))+1);
				palabraAceptada = insertarVerticalNormal(matrizSopa, palabra, fila, columna);
			}
			matrizSopa = matrizSopaAux.clone();				 
			break;
		case "verticalInvertida":	
			while (!palabraAceptada) {
				matrizSopaAux = matrizSopa.clone();
				fila = (int) Math.floor(Math.random()*(alto-largo-1)+largo);
				columna = (int) (Math.random()*(valoresSopa.getW()-1)+1);						
				palabraAceptada = insertarVerticalInvertida(matrizSopa, palabra, fila, columna);
			}
			matrizSopa = matrizSopaAux.clone();	
			break;
		case "diagonalLtrNormal":	//OK
			while (!palabraAceptada) {
				matrizSopaAux = matrizSopa.clone();
				fila = (int) Math.floor(Math.random()*(alto-largo-1));
				columna = (int) Math.floor(Math.random()*(ancho-largo-1));
				palabraAceptada = insertarDiagonalLtrNormal(matrizSopa, palabra, fila, columna);
			}
			matrizSopa = matrizSopaAux.clone();	
			break;
		case "diagonalLtrInvertida":	//OK
			while (!palabraAceptada) {
				matrizSopaAux = matrizSopa.clone();
										
				int desdeFila = alto - largo; 
				fila = numAleatorio.nextInt((alto-1)-desdeFila+1) + desdeFila; //funciona perfecto
				columna = numAleatorio.nextInt((ancho-largo)+1); //funciona perfecto
						
				palabraAceptada = insertarDiagonalLtrInvertida(matrizSopa, palabra, fila, columna);
			}
			matrizSopa = matrizSopaAux.clone();	
			break;
		case "diagonalRtlNormal":	//OK
//			logger.info("Palabra: "+palabra +" largo: "+palabra.length());
			while (!palabraAceptada) {
				matrizSopaAux = matrizSopa.clone();		        
		        fila = (int) Math.floor(Math.random()*(alto-largo-1));
		        columna = (int) Math.floor(Math.random()*(ancho-largo-1)+largo);		       
				palabraAceptada = insertarDiagonalRtlNormal(matrizSopa, palabra, fila, columna);
			}
			matrizSopa = matrizSopaAux.clone();	
			break;
		case "diagonalRtlInvertida": //OK		
			while (!palabraAceptada) {
				matrizSopaAux = matrizSopa.clone();
				fila = (int) Math.floor(Math.random()*(largo-alto-1)+alto);
				columna = (int) Math.floor(Math.random()*(largo-ancho-1)+ancho);
//				logger.info("diagonalLtrInvertida ["+palabra+"] ["+fila+"]["+columna+"]");
				palabraAceptada = insertarDiagonalRtlInvertida(matrizSopa, palabra, fila, columna);
			}				
			matrizSopa = matrizSopaAux.clone();	
			break;
		default:
			logger.error("Posición para ingresar palabra en Sopa de Letras no encontrada: ".concat(opcionFinal));
			break;
		}
	}
	
	//OK 7/11
	private Boolean insertarHorizontalNormal(String[][] matrizSopa, String palabra, int fila, int columna) {
		for (int i = 0; i < palabra.length(); i++) {
			if (matrizSopa[fila][columna+i] == null || matrizSopa[fila][columna+i].isEmpty() || matrizSopa[fila][columna+i].contains(String.valueOf(palabra.charAt(i)))) {
				matrizSopa[fila][columna + i] = String.valueOf(palabra.charAt(i));
			} else {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	//OK 7/11
	private Boolean insertarHorizontalInvertida(String[][] matrizSopa, String palabra, int fila, int columna) {
		for (int i = (palabra.length()-1); i >= 0; i--) {
			if (matrizSopa[fila][columna-i] == null || matrizSopa[fila][columna-i].isEmpty() || matrizSopa[fila][columna-i].contains(String.valueOf(palabra.charAt(i)))) {
				matrizSopa[fila][columna-i] = String.valueOf(palabra.charAt(i));	
			}else {
				return Boolean.FALSE;
			}			
		}		
		return Boolean.TRUE;
	}

	//OK 7/11
	private Boolean insertarVerticalNormal(String[][] matrizSopa, String palabra, int fila, int columna) {
		for (int i = 0; i < palabra.length(); i++) {
			if (matrizSopa[fila+i][columna] == null || matrizSopa[fila+i][columna].isEmpty() || matrizSopa[fila+i][columna].contains(String.valueOf(palabra.charAt(i)))) {
				matrizSopa[fila+i][columna] = String.valueOf(palabra.charAt(i));	
			} else {
				return Boolean.FALSE;
			}
		}	
		return Boolean.TRUE;
	}

	//OK 7/11
	private Boolean insertarVerticalInvertida(String[][] matrizSopa, String palabra, int fila, int columna) {
		for (int i = palabra.length()-1; i >= 0; i--) {			
			if (matrizSopa[fila-i][columna] == null || matrizSopa[fila-i][columna].isEmpty() || matrizSopa[fila-i][columna].contains(String.valueOf(palabra.charAt(i)))) {
				matrizSopa[fila-i][columna] = String.valueOf(palabra.charAt(i));	
			} else {
				return Boolean.FALSE;
			}
		}	
		return Boolean.TRUE;
	}
	
	//de izquierda a derecha y de arriba a abajo: OK 17/11
	private Boolean insertarDiagonalLtrNormal(String[][] matrizSopa, String palabra, int fila, int columna) {
		for (int i = 0; i < palabra.length(); i++) {
			
			if (matrizSopa[fila+i][columna+i] == null || matrizSopa[fila+i][columna+i].isEmpty() || matrizSopa[fila+i][columna+i].contains(String.valueOf(palabra.charAt(i)))) {
				matrizSopa[fila + i][columna + i] = String.valueOf(palabra.charAt(i));		
			} else {
				return Boolean.FALSE;
			}
		}	
		return Boolean.TRUE;		
	}
	
	//de izquierda a derecha y de abajo a arriba: OK 17/11  
	private Boolean insertarDiagonalLtrInvertida(String[][] matrizSopa, String palabra, int fila, int columna) {
		for (int i = palabra.length()-1; i >= 0; i--) {
			if (matrizSopa[fila-i][columna+i] == null || matrizSopa[fila-i][columna+i].isEmpty() || matrizSopa[fila-i][columna+i].contains(String.valueOf(palabra.charAt(i)))) {
				matrizSopa[fila - i][columna + i] = String.valueOf(palabra.charAt(i));		
			} else {
				return Boolean.FALSE;
			}
		}	
		return Boolean.TRUE;		
	}
	
	//de derecha a izquierda y de arriba a abajo: OK 17/11
	private Boolean insertarDiagonalRtlNormal(String[][] matrizSopa, String palabra, int fila, int columna) {
		
		for (int i = 0; i < palabra.length(); i++) {			
			if (matrizSopa[fila+i][columna-i] == null || matrizSopa[fila+i][columna-i].isEmpty() || matrizSopa[fila+i][columna-i].contains(String.valueOf(palabra.charAt(i)))) {
				matrizSopa[fila+i][columna-i] = String.valueOf(palabra.charAt(i));		
			} else {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
	
	//de derecha a izquierda y de abajo a arriba: OK 17/11
	private Boolean insertarDiagonalRtlInvertida(String[][] matrizSopa, String palabra, int fila, int columna) {
		for (int i = palabra.length()-1; i >= 0; i--) {
//			logger.info("["+(fila-i)+"]["+(columna-i)+"] = "+matrizSopa[fila-i][columna-i]);
			if (matrizSopa[fila-i][columna-i] == null || matrizSopa[fila-i][columna-i].isEmpty() || matrizSopa[fila-i][columna-i].contains(String.valueOf(palabra.charAt(i)))) {
				matrizSopa[fila - i][columna - i] = String.valueOf(palabra.charAt(i));		
			} else {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
	
	private void imprimirMatriz(String[][] matriz) {
		for (int x=0; x < matriz.length; x++) {
			  for (int y=0; y < matriz[x].length; y++) { 
				 System.out.print(matriz[x][y]);
			  }
			  System.out.println("");
		}
	}

	private void rellenarEspaciosBlancos(String[][] matrizSopa) {
		String setOfCharacters = "abcdefghijklmnñopqrstuvwxyz";
		Random random = new Random();
		
		for (int i = 0; i < matrizSopa.length; i++) {
			for (int j = 0; j < matrizSopa[i].length; j++) {
				if (matrizSopa[i][j] == null || matrizSopa[i][j].isEmpty()) {
					int randomInt = random.nextInt(setOfCharacters.length());					
					matrizSopa[i][j] = String.valueOf(setOfCharacters.charAt(randomInt));
				}
			}
		}
	}
	
	@Override
	public void validarSopa(ValoresSopa valoresSopa) throws Exception{
		if (valoresSopa.getH() < ConstantesUtil.VALOR_MINIMO_FILAS || valoresSopa.getH() > ConstantesUtil.VALOR_MAXIMO_FILAS ) {
			throw new Exception(ConstantesUtil.MSG_ERROR_FILAS_SOPA);
		}
		if (valoresSopa.getW() < ConstantesUtil.VALOR_MINIMO_COLUMNAS || valoresSopa.getW() > ConstantesUtil.VALOR_MAXIMO_COLUMNAS) {
			throw new Exception(ConstantesUtil.MSG_ERROR_COLUMNAS_SOPA);
		}
	}

	@Override
	public Boolean validarPalabra(Sopa sopa, Coordenadas coordenadas) throws Exception{
		
		String posicion = obtenerPosicion(coordenadas);
		
		Integer filaIni = coordenadas.getSr()-1;
		Integer filaFin = coordenadas.getEr()-1;
		
		Integer colIni = coordenadas.getSc()-1;
		Integer colFin = coordenadas.getEc()-1;
		
		switch (posicion) {		
			case "horizontalNormal":
				logger.info("Buscando Horizontal Normal");
				return buscarHorizontalNormal(sopa, filaIni, colIni, colFin);					
			case "horizontalInvertida":
				logger.info("Buscando Horizontal Invertida");
				return buscarHorizontalInvertida(sopa, filaIni, colIni, colFin);
			case "verticalNormal":
				logger.info("Buscando Vertical Normal");
				return buscarVerticalNormal(sopa, filaIni, filaFin, colIni);
			case "verticalInvertida":
				logger.info("Buscando Vertical Invertida");
				return buscarVerticalInvertida(sopa, filaIni, filaFin, colIni);
			case "diagonalLtrNormal":
				logger.info("Buscando Diagonal Ltr Normal");
				return buscarDiagonalLtrNormal(sopa, filaIni, filaFin, colIni, colFin);	
			case "diagonalLtrInvertida":
				logger.info("Buscando Diagonal Ltr Invertida");
				return buscarDiagonalLtrInvertida(sopa, filaIni, filaFin, colIni, colFin);	
			case "diagonalRtlInvertida":
				logger.info("Buscando Diagonal Rtl Invertida");
				return buscarDiagonalRtlInvertida(sopa, filaIni, filaFin, colIni, colFin);
			case "diagonalRtlNormal":
				logger.info("Buscando Diagonal Rtl Normal");
				return buscarDiagonalRtlNormal(sopa, filaIni, filaFin, colIni, colFin);
		}
		
		return false;
	}

	private String obtenerPosicion(ArrayList<String> opcionesDePosicion) {
		
		int hasta = opcionesDePosicion.size()-1;
		Random numAleatorio = new Random();
		int posicion = (int) numAleatorio.nextInt(hasta+1);		
		logger.info("Posición: "+posicion);
		
		String opcionFinal = opcionesDePosicion.get(posicion);
		return opcionFinal;
	}

	private String obtenerPosicion(Coordenadas coordenadas) throws Exception {
		String posicion = null;
		if (coordenadas.getSr() == coordenadas.getEr()) {
//			logger.info("Horizontal");
			if (coordenadas.getSc() == coordenadas.getEc()) {
				throw new Exception(ConstantesUtil.MSG_ERROR_COLUMNAS_SOPA);
			}			
			if (coordenadas.getSc() < coordenadas.getEc()) {
//				logger.info("Posición Encontrada: horizontalNormal");
				posicion = "horizontalNormal";
				return posicion;
			}
			if (coordenadas.getSc() > coordenadas.getEc()) {
//				logger.info("horizontalInvertida");
				posicion = "horizontalInvertida";
				return posicion;
			}
		}
		
		if (coordenadas.getSc() == coordenadas.getEc()) {
//			logger.info("Vertical");
			if (coordenadas.getSr() == coordenadas.getEr()) {
				throw new Exception(ConstantesUtil.MSG_ERROR_FILAS_SOPA);
			}			
			if (coordenadas.getSr() < coordenadas.getEr()) {
//				logger.info("verticalNormal");
				posicion = "verticalNormal";
				return posicion;
			}
			if (coordenadas.getSr() > coordenadas.getEr()) {
//				logger.info("verticalInvertida");
				posicion = "verticalInvertida";
				return posicion;
			}
		}
		
		if (coordenadas.getEc() < coordenadas.getSc()) {
//			logger.info("diagonalRtl");
			if (coordenadas.getSr() == coordenadas.getEr()) {
				throw new Exception(ConstantesUtil.MSG_ERROR_FILAS_SOPA);
			}			
			if (coordenadas.getSr() < coordenadas.getEr()) {
//				logger.info("diagonalRtlNormal");
				posicion = "diagonalRtlNormal";
				return posicion;
			}
			if (coordenadas.getSr() > coordenadas.getEr()) {
//				logger.info("diagonalRtlInvertida");
				posicion = "diagonalRtlInvertida";
				return posicion;
			}
		}
		
		if (coordenadas.getSc() < coordenadas.getEc()) {
//			logger.info("diagonalLtr");
			if (coordenadas.getSr() == coordenadas.getEr()) {
				throw new Exception(ConstantesUtil.MSG_ERROR_FILAS_SOPA);
			}			
			if (coordenadas.getSr() < coordenadas.getEr()) {
//				logger.info("diagonalLtrNormal");
				posicion = "diagonalLtrNormal";
				return posicion;
			}
			if (coordenadas.getSr() > coordenadas.getEr()) {
//				logger.info("diagonalLtrInvertida");
				posicion = "diagonalLtrInvertida";
				return posicion;
			}
		}
		return posicion;
	}

}
