package com.kh.teamprj.util;

import java.util.Calendar;

public class MyDateUtil {
	private static Calendar cal = Calendar.getInstance();
	
	//오늘 날짜를 문자열로 리턴
	public static String getNowDateToString() {
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String strMonth =  month / 10 == 0 ? "0" + month : "" + month;
		int date = cal.get(Calendar.DATE);
		String strDate = date / 10 == 0 ? "0" + date : "" + date;
		
		
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		
		
		
		return year + "-" + strMonth + "-" + strDate;
	}
	public static String getNowDateToString(String seperator) {
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String strMonth =  month / 10 == 0 ? "0" + month : "" + month;
		int date = cal.get(Calendar.DATE);
		String strDate = date / 10 == 0 ? "0" + date : "" + date;
		
		
		
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		
		
		
		return year + seperator + strMonth + seperator + strDate;
	}
	
	public static int[] getSemDate() {
		int nowMonth = Integer.parseInt(getNowDateToString().substring(5 , 7));
		int[] sem = new int[2];
		sem[0] = cal.get(Calendar.YEAR);
		
		
		if(nowMonth <= 6 && nowMonth >= 1) {
			sem[1] = 1;
		}
		else if(nowMonth <= 12 && nowMonth >= 7){
			sem[1] = 2;
		}
		//2022-05-05
		return sem;
	}
	
}
