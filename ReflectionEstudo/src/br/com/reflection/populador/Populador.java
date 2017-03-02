package br.com.reflection.populador;

import java.lang.reflect.Field;

/**
 * Classe utilizada para popular o objeto.
 * @author Gilson
 *
 */
public abstract class Populador {
	
	/**
	 * Recebe o objeto / campo / valor a ser populado.
	 * @param objeto
	 * @param campo
	 * @param valor
	 */
	public static void popularCampo(Object objeto, Field campo, Object valor) {
		
		try {
			campo.setAccessible(true);
			campo.set(objeto, valor);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		System.out.println(objeto + "");
	}
	
}
