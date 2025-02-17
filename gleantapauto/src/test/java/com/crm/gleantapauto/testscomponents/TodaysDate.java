package com.crm.gleantapauto.testscomponents;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodaysDate {
	private static String  Todaysdate ;
	public static  String text;
	String dateinit;
	
	

	 public  TodaysDate()
    {
		LocalDate date1 = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		text = date1.format(formatter);
		System.out.println(text);
		
	  
    }
	 //public String getTodaysLocalDate()
		/*
		 * public static void main(String args[]) { TodaysDate obj =new
		 * TodaysDate(Todaysdate); String date1=obj.TodaysLocalDate();
		 * System.out.println("date"+ date1);
		 * 
		 * }
		 */
}
