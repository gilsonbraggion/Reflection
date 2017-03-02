package br.com.reflection.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {
	
	/**
	 * Transformando uma data String para LocalDate
	 * @param dataStr
	 * @return
	 */
	public static LocalDate parseDate(String dataStr) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate dateTime = LocalDate.parse(dataStr, formatter);
		System.out.println(dateTime.format(formatter)); // not using toString
		
		return dateTime;
	}

}
