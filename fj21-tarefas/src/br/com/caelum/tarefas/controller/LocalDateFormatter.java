package br.com.caelum.tarefas.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class LocalDateFormatter implements Formatter<LocalDate> {
	private DateTimeFormatter formatter;
	private String datePattern;
	
	public LocalDateFormatter(String datePattern){
		this.datePattern = datePattern;
		formatter = DateTimeFormatter.ofPattern(datePattern);
	}

	@Override
	public String print(LocalDate date, Locale locale) {
		// TODO Auto-generated method stub
		return date.format(formatter);
	}

	@Override
	public LocalDate parse(String s, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		try {
			return LocalDate.parse(s, DateTimeFormatter.ofPattern(datePattern));
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Invalida date format. Please use this pattern: \"" + datePattern + "\"");
		}
	}

}
