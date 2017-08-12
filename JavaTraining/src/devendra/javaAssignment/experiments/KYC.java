package devendra.javaAssignment.experiments;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class KYC {
	
	
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
		
		c1.setTime(date1); 
		c2.setTime(date2);

		
//		long diff = date2.getTime() - date1.getTime();
		String output;
		
		
		c3 = (Calendar) c1.clone();
		output = sdf.format(c1.getTime());
		System.out.print("\nform date = "+ output);
		c3.add(Calendar.YEAR,1);
		output = sdf.format(c3.getTime());
		System.out.print("  anniversary date = "+ output);
		c3.add(Calendar.YEAR,1);
		output = sdf.format(c3.getTime());
		System.out.print("  anniversary date = "+ output);
		c3.add(Calendar.YEAR,1);
		output = sdf.format(c3.getTime());
		System.out.print("  anniversary date = "+ output);
		c3.add(Calendar.YEAR,1);
		output = sdf.format(c3.getTime());
		System.out.print("  anniversary date = "+ output);
		c3.add(Calendar.YEAR,1);
		output = sdf.format(c3.getTime());
		System.out.print("  anniversary date = "+ output);
		c3.add(Calendar.DATE, -30);
		output = sdf.format(c3.getTime());
		System.out.print("  one month before = "+ output);
		output = sdf.format(c2.getTime());
		System.out.print("  current date = "+ output);
		
		if(c3.after(c2))
			System.out.print("  No Range ");
		
		
		/*
		if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)<365) {
			System.out.println("\nNo Range, dif="+ diff);
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
		
		System.out.print("\nStart date = "+ sdf.format(startdate));
		System.out.print("  End date = "+ sdf.format(enddate));
		
		*/
		
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
//        	getKYCWindow(signUpDate[i],currentDate[i]);
        }
        for (int i=0;i<n;i++) {
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

16
31-12-2013	29-1-2014
31-12-2013	30-1-2014
31-12-2013	31-1-2014
31-12-2013	1-2-2014
2-2-2012	10-10-2013
28-2-2013	10-10-2013
16-07-1998 27-06-2017
04-02-2016 04-04-2017
04-05-2017 04-04-2017
04-04-2015 15-03-2016
04-02-2017	10-10-2017
16-10-2015	26-04-2017
04-04-2015 04-04-2016
04-04-2015 04-03-2016
04-04-2015 05-03-2016
04-04-2015 06-03-2016


*/