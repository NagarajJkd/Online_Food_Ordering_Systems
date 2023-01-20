package com.OFOS.generic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int randomNumber(int number) {
		Random ran=new Random();
		int random = ran.nextInt(number);
		return random;
	}

	public String getSystemDate() {
		Date d=new Date();
		String date = d.toString();
		return date;
	}
	
	public String getSystemDateAndTimeInFormate() {
		SimpleDateFormat dateformate=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date sysDate=new Date();
		String getdateandtime = dateformate.format(sysDate);
		System.out.println(getdateandtime);
		return getdateandtime.replace(":", "-");
	}
}
