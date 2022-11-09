package com.sitrak.sopa.util;

public final class ConstantesUtil {

	public static final String MSG_ERROR_FILAS_SOPA = "ERROR: Las filas de la sopa de letras no pueden ser inferior a 15 o mayor a 80";
	public static final String MSG_ERROR_COLUMNAS_SOPA = "ERROR: Las columnas de la sopa de letras no pueden ser inferior a 15 o mayor a 80";
	public static final String MSG_ERROR_INTERNO = "Ha ocurrido un error interno: ";
	
	public static final String MSG_ERROR_BUSQUEDA_SOPA = "No se ha encontrado la Sopa de Letras con Id @id";
	
	public static final String MSG_ERROR_BUSQUEDA_PALABRA = "No se ha encontrado una palabra valida en las coordenadas indicadas";
	public static final String MSG_EXITO_BUSQUEDA_PALABRA = "Se ha encontrado una palabra correcta!. Favor actualizar la sopa de letras";
	
	public static final String MSG_ERROR_HORIZONTAL_COLUMNAS = "Cuando las coordenas de filas son iguales las de columnas deben ser distintas";
	public static final String MSG_ERROR_HORIZONTAL_FILAS = "Cuando las coordenas de columnas son iguales las de filas deben ser distintas";
	
	public static final int VALOR_MINIMO_FILAS = 15;
	public static final int VALOR_MAXIMO_FILAS = 80;
	public static final int VALOR_MINIMO_COLUMNAS = 15;
	public static final int VALOR_MAXIMO_COLUMNAS = 80;
}
