package br.com.reflection.populador;

import java.math.BigDecimal;
import java.util.Date;

import br.com.reflection.util.Util;

public class TipoCampos {
	
	public static Object retornaValorCampo(Class<?> clazz, String valorCampo) {
		
		String canonicalName = clazz.getCanonicalName();
		
		if (canonicalName.equalsIgnoreCase(String.class.getCanonicalName())) {
			return valorCampo;
		} else if (canonicalName.equalsIgnoreCase(Double.class.getCanonicalName()) ) {
			return Double.valueOf(valorCampo);
		} else if (canonicalName.equalsIgnoreCase(Integer.class.getCanonicalName())) {
			return Integer.valueOf(valorCampo);
		} else if (canonicalName.equalsIgnoreCase(BigDecimal.class.getCanonicalName())) {
			return new BigDecimal(valorCampo);
		} else if (canonicalName.equalsIgnoreCase(Date.class.getCanonicalName())) {
			return Util.parseDate(valorCampo);
		} else if (canonicalName.equalsIgnoreCase(Boolean.class.getCanonicalName())) {
			return Boolean.valueOf(valorCampo);
		}
		
		return null;
	}
	
}
