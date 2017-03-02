package br.com.reflection.main;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import br.com.reflection.populador.Populador;
import br.com.reflection.populador.TipoCampos;

public class Principal {

	public static void main(String[] args) {
		
	    try {

	    	Class<?> cls = Class.forName("br.com.reflection.modelo.Pessoa");
	    	
	    	Object obj = cls.newInstance();
	    	System.out.println("Objeto criado : " + obj.toString());
	    	
	    	List<Field> campos = Arrays.asList(cls.getDeclaredFields());
	    	
	    	for (Field campo  : campos) {
	    		
	    		if (!campo.getType().isPrimitive()) {
	    			Object valorCampo = TipoCampos.retornaValorCampo(campo.getType(), "10");
	    			Populador.popularCampo(obj, campo, valorCampo);
	    		} else {
	    			System.out.println("Nome Campo : " + campo.getName() + ( campo.getType().isPrimitive() ? " -> É um campo Primitivo" : "Não é um campo primitivo"));
	    		}
	    		
	    	}
	    	
	    	Field campo = cls.getDeclaredField("nome");
	    	Populador.popularCampo(obj, campo, "Nome passado através do populador");
			
	    	System.out.println("Objeto Modificado: " + obj.toString());
	    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

	}
	
	static void modificarPessoa(Object objetoTrabalhado, Class<?> cls, String novoNome) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	    Field campoDesejado;
	    
//	    Class<? extends Pessoa> clazzTrabalhada = objetoTrabalhado.getClass();
	    
	    try {
	      campoDesejado = cls.getDeclaredField("nome");
	      campoDesejado.setAccessible(true);
	      campoDesejado.set(objetoTrabalhado, novoNome);
	      
	      System.out.println("Nome campo : " + campoDesejado.getName());
	      System.out.println("Tipo campo : " + campoDesejado.getType().getName());
	      System.out.println("Valor do Campo : " + campoDesejado.get(objetoTrabalhado));
	      
	    } catch (NoSuchFieldException e) {
	      System.out.println(e);
	    } catch (IllegalAccessException e) {
	      System.out.println(e);
	    }
	  }
	
	public static void recuperarValores(Object objetoTrabalhado, Class<?> cls) throws IllegalArgumentException, IllegalAccessException {
		
		List<Field> listaCampos = Arrays.asList(cls.getDeclaredFields());
		
		for (Field campo : listaCampos) {
			campo.setAccessible(true);
			// Recupera o valor do objeto que já está criado
			System.out.println(campo.get(objetoTrabalhado));
		}
	}

}
