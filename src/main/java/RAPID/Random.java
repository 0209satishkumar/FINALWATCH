package RAPID;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Random {

	public static void main(String[] args) {
		
//		int min = 1;
//	      int max = 10000;
//	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
//	      System.out.println("randomnumber ="+random_int);
		
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String dateFormatted= dateFormat.format(date);
		
		System.out.println(dateFormatted);

	}
	
}
