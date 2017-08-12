package devendra.javaAssignment.experiments;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GruberHealthcare {
	
	/*boolean isValidDate(dateString)
	{
	    // First check for the pattern
	    if(!/^\d{1,2}\/\d{1,2}\/\d{4}$/.test(dateString))
	        return false;

	    // Parse the date parts to integers
	    var parts = dateString.split("/");
	    var day = parseInt(parts[1], 10);
	    var month = parseInt(parts[0], 10);
	    var year = parseInt(parts[2], 10);

	    // Check the ranges of month and year
	    if(year < 1000 || year > 3000 || month == 0 || month > 12)
	        return false;

	    var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

	    // Adjust for leap years
	    if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
	        monthLength[1] = 29;

	    // Check the range of the day
	    return day > 0 && day <= monthLength[month - 1];
	}*/

	public static boolean isValidFormat(String format, String dateStr) {
		Date date = null;

		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(format);
		sdf.setLenient(false);

		try {
			date = sdf.parse(dateStr);
			return true;

		} catch (ParseException e) {
			System.out.println(e.getMessage());
			return false;

		}
	}
        
    
	
	
/*	private boolean isValidDate(String dateOfBirth) {
        boolean valid = true;
        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
            DateTime dob = formatter.parseDateTime(dateOfBirth);
        } catch (Exception e) {
            valid = false;
        }
        return valid;
    }
*/
	
	
	
	
	public static void main(String [] args) {
		
		/*Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nubmer of inputs: ");
        int n = sc.nextInt();
        String[] signUpDate = new String[n];
        String[] currentDate = new String[n];
        String[] startDate = new String[n];
        String[] endDate = new String[n];
        
        for(int i=0;i<n;i++) {
        	signUpDate[i]=sc.next();
        	currentDate[i]=sc.next();
        }
        for(int i=0;i<n;i++) {
            System.out.println("Signup: "+signUpDate[i]+ "  Current: "+ currentDate[i]);
        }
        sc.close();
        */
        
        String inputString1 = "23-10-1997";
        String inputString2 = "27-04-1997";
        
        System.out.println("All ok");
        System.out.println(isValidFormat("dd-MM-yyyy","23-5-997"));
        
        System.out.println(isValidFormat("dd-MM-yyyy","23-15-997"));
        
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
	}

}






/*

package devendra.javaAssignment.javaAss4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HealthCareKYC {
	
	
	public static boolean isValidFormat(String format, String dateStr) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(format);
		sdf.setLenient(false);

			try {
				date = sdf.parse(dateStr);
				System.out.print(date);
				return true;
			} catch (ParseException e) {
				System.out.print(e.getMessage());
				return false;
				}
	}
	
	public static void getKYCWindow(String signup , String current) {
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();
		
		Date date1,date2,startdate,enddate;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			date1 = sdf.parse(signup);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
			return;
		}
		
		try {
			date2 = sdf.parse(current);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
			return;
		}
		
		long diff = date2.getTime() - date1.getTime();
		if(diff<0) {
			System.out.println("\nNo Range");
			return;
		}
		
		c1.setTime(date1); // Now set form date
		c2.setTime(date2);
		
		Calendar anniversary = Calendar.getInstance();
		anniversary.set(c2.get(Calendar.YEAR),c1.get(Calendar.MONTH),c1.get(Calendar.DATE));		// c1.get(Calendar.MONTH); Jan = 0, dec = 11
		if(!anniversary.after(c2))
			anniversary.set(c2.get(Calendar.YEAR)-1,c1.get(Calendar.MONTH),c1.get(Calendar.DATE));
		String output = sdf.format(anniversary.getTime());
		System.out.println("anniversary date = "+ output);
		
		c3 = (Calendar) anniversary.clone();
		c4 = (Calendar) anniversary.clone();
		
		c3.add(Calendar.DATE, -30);
		output = sdf.format(c3.getTime());
//		System.out.println(output);
		c4.add(Calendar.DATE, 30);
		output = sdf.format(c4.getTime());
//		System.out.println(output);
		
		if(c4.after(c2)) {
			enddate = c2.getTime();
		}else {
			enddate = c4.getTime();
		}
		startdate = c3.getTime();
		
		System.out.print("\nStart date = "+ sdf.format(startdate));
		System.out.print("  End date = "+ sdf.format(enddate));
		
		
		
//		c.add(Calendar.DATE, 5); // Adding 5 days
//		String output = sdf.format(c.getTime());
//		System.out.println(output);
		
	}
	
	public static void main(String [] args) {
		//TODO: what if some has anniversary on leap year, then for nonleap year, will there be anniversary??
		
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nubmer of inputs: ");
        int n = sc.nextInt();
        
//        String format = "dd-MM-yyyy";
        String[] signUpDate = new String[n];
        String[] currentDate = new String[n];
//        String[] startDate = new String[n];
//        String[] endDate = new String[n];
        
        for(int i=0;i<n;i++) {
        	signUpDate[i]=sc.next();
        	currentDate[i]=sc.next();
        	getKYCWindow(signUpDate[i],currentDate[i]);
        }
        /*for(int i=0;i<n;i++) {
            System.out.println("Signup= "+ isValidFormat(format, signUpDate[i])+ "  Current= "+ isValidFormat(format, currentDate[i]));
        }
        
        sc.close();
        
        
	}
}

*/

/*
Test Input

5

16-07-1998 27-06-2017
04-02-2016 04-04-2017
04-05-2017 04-04-2017
04-04-2015 04-04-2016
04-04-2015 15-03-2016
 

Test output

16-06-2017 27-06-2017
05-01-2017 06-03-2017
No range
05-03-2016 04-04-2016
05-03-2016 15-03-2016

*/