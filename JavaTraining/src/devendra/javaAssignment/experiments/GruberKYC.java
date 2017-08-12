package devendra.javaAssignment.experiments;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GruberKYC {
	
	
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
		Calendar anniversary = Calendar.getInstance();
		
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
		int day = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
		if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)<365) {
			System.out.println("\nNo Range, dif="+ diff);
			return;
		}
		
		c1.setTime(date1); 
		c2.setTime(date2);
		anniversary.set(c2.get(Calendar.YEAR),c1.get(Calendar.MONTH),c1.get(Calendar.DATE));
		c3 = (Calendar) anniversary.clone();
		c4 = (Calendar) anniversary.clone();
		
		c3.add(Calendar.DATE, -30);
		c4.add(Calendar.DATE, 30);
		
		
		if(   !(c2.after(c3) && c2.before(c4)) && (anniversary.after(c2))) {
			anniversary.set(c2.get(Calendar.YEAR)-1,c1.get(Calendar.MONTH),c1.get(Calendar.DATE));
			c3 = (Calendar) anniversary.clone();
			c4 = (Calendar) anniversary.clone();
			c3.add(Calendar.DATE, -30);
			c4.add(Calendar.DATE, 30);
		}
		
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
        }*/
        
        sc.close();
        
        
	}
}

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




04-02-2017	10-10-2017  =>> No Range
16-10-2015	26-04-2017 	==> Start date = 16-09-2016  End date = 15-11-2016






package devendra.javaAssignment.javaAss4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HealthCareKYC {
	
	// To validate the date in given format
	public static boolean isValidFormat(String format, String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(format);
		sdf.setLenient(false);
			try {
				sdf.parse(dateStr);
				return true;
			} catch (ParseException e) {
				System.out.print("\n"+e.getMessage());
				return false;
				}
	}
	
	
	// To obtain the KYC Window for input signup and current dates
	public static void getKYCWindow(String signupStr , String currentStr) {
		
		Calendar signup = Calendar.getInstance();
		Calendar current = Calendar.getInstance();
		Calendar satrting = Calendar.getInstance();
		Calendar ending = Calendar.getInstance();
		Calendar anniversary = Calendar.getInstance();
		
		Date date1,date2,startdate,enddate;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date1 = sdf.parse(signupStr);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
			return;
		}
		
		try {
			date2 = sdf.parse(currentStr);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
			return;
		}
		
		c1.setTime(date1); 
		c2.setTime(date2);
		
		c3 = (Calendar) c1.clone();
		c3.add(Calendar.YEAR,1);
		c3.add(Calendar.DATE, -30);
		if(c3.after(c2)) {
			System.out.print("\nNo Range ");
			return;
		}
			
		
		anniversary.set(c2.get(Calendar.YEAR),c1.get(Calendar.MONTH),c1.get(Calendar.DATE));
		c3 = (Calendar) anniversary.clone();
		c4 = (Calendar) anniversary.clone();	
		c3.add(Calendar.DATE, -30);
		c4.add(Calendar.DATE, 30);
		
		if(   !(c2.after(c3) && c2.before(c4)) && (anniversary.after(c2))) {
			anniversary.set(c2.get(Calendar.YEAR)-1,c1.get(Calendar.MONTH),c1.get(Calendar.DATE));
			c3 = (Calendar) anniversary.clone();
			c4 = (Calendar) anniversary.clone();
			c3.add(Calendar.DATE, -30);
			c4.add(Calendar.DATE, 30);
		}
		
		if(c4.after(c2)) {
			enddate = c2.getTime();
		}else {
			enddate = c4.getTime();
		}
		startdate = c3.getTime();
		
		System.out.print("\n" + sdf.format(startdate));
		System.out.print("  " + sdf.format(enddate));
	}
	
	public static void main(String [] args) {
		//TODO: what if some has anniversary on leap year, then for nonleap year, will there be anniversary??
		
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nubmer of inputs: ");
        int n = sc.nextInt();
        
        String[] signUpDate = new String[n];
        String[] currentDate = new String[n];
        
        for(int i=0;i<n;i++) {
        	signUpDate[i]=sc.next();
        	currentDate[i]=sc.next();
        }
        for (int i=0;i<n;i++) {
        	if(isValidFormat("dd-MM-yyyy",signUpDate[i]) && isValidFormat("dd-MM-yyyy",currentDate[i])  )
        	getKYCWindow(signUpDate[i],currentDate[i]);
        }
        sc.close();
	}
}



/*
Test Input
7
16-07-1998 27-06-2017
04-02-2016 04-04-2017
04-05-2017 04-04-2017
04-04-2015 04-04-2016
04-04-2015 15-03-2016
04-02-2017	10-10-2017
16-10-2015	26-04-2017

Test output
16-06-2017 27-06-2017
05-01-2017 06-03-2017
No range
05-03-2016 04-04-2016
05-03-2016 15-03-2016
No range
16-09-2016 15-11-2016

Mix of invalid dates and valid dates
7
16-00-1998 27-06-2017
04-05-2017 04-04-2017
04-02-2016 04-34-2017
46-07-1998 27-06-2017
04-04-2015 04-04-2016
04-04-2015 15-03-2016
4-07-1998 27-06-2017

Output:
Unparseable date: "16-00-1998"
No Range 
Unparseable date: "04-34-2017"
Unparseable date: "46-07-1998"
05-03-2016  04-04-2016
05-03-2016  15-03-2016
04-06-2017  27-06-2017

*/

*/