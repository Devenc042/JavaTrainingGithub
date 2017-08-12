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
		
		
		// Making calendar instance of require Dates
		Calendar signup = Calendar.getInstance();
		Calendar current = Calendar.getInstance();
		Calendar starting = Calendar.getInstance();
		Calendar ending = Calendar.getInstance();
		Calendar anniversary = Calendar.getInstance();
		
		// To set date1 as signup and date2 as current
		Date date1,date2;
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
		signup.setTime(date1); 
		current.setTime(date2);
		
		
		// To check that at least first anniversary date and signup date is before current date
		starting = (Calendar) signup.clone();
		starting.add(Calendar.YEAR,1);
		starting.add(Calendar.DATE, -30);
		if(starting.after(current)) {
			System.out.print("\nNo Range ");
			return;
		}
			
		
		// Setting current anniversary date
		anniversary.set(current.get(Calendar.YEAR),signup.get(Calendar.MONTH),signup.get(Calendar.DATE));
		starting = (Calendar) anniversary.clone();
		ending = (Calendar) anniversary.clone();	
		starting.add(Calendar.DATE, -30);
		ending.add(Calendar.DATE, 30);
		
		// anniversary should be 
		if(   !(current.after(starting) && current.before(ending)) && (anniversary.after(current))) {
			anniversary.set(current.get(Calendar.YEAR)-1,signup.get(Calendar.MONTH),signup.get(Calendar.DATE));
			starting = (Calendar) anniversary.clone();
			ending = (Calendar) anniversary.clone();
			starting.add(Calendar.DATE, -30);
			ending.add(Calendar.DATE, 30);
		}
		
		
		Date startdate,enddate;
		if(ending.after(current)) {
			enddate = current.getTime();
		}else {
			enddate = ending.getTime();
		}
		startdate = starting.getTime();
		
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