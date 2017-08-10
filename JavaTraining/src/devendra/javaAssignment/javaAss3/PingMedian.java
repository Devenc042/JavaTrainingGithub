package devendra.javaAssignment.javaAss3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingMedian {
	public static void main(String args[]) {

		// User input
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ip: ");
        String ip = sc.next();
        System.out.println("Enter number of ping: ");
        int no_of_ping = sc.nextInt();
        sc.close();
        
		/*
		// Normal input
		String ip = "www.google.com";
		int no_of_ping = 5;
		*/
        
        // Ping command and Regex pattern for searching time
		String pingCmd = "ping " + ip + " -c " + no_of_ping;
		String RegexPattern = "time=\\d+(\\.\\d+)?\\sms";
		Pattern pattern = Pattern.compile(RegexPattern);
		Matcher matcher;

		// Running the process of ping command and finding the strings with having echo response time
		try {
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(pingCmd);

			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inputLine;
			int count = 0;
			double[] timeArray = new double[no_of_ping];

			// Read all lines and match those having "time=" part
			while ((inputLine = in.readLine()) != null) 
			{
				System.out.println(inputLine);
				matcher = pattern.matcher(inputLine);
				if (matcher.find()) 
				{
					String number = inputLine.substring(inputLine.lastIndexOf("time=") + 5, inputLine.length() - 3);
					if (number.length() > 0)
						timeArray[count++] = Double.parseDouble(number);
				}
			}
			in.close();

			// Packet loss also considered!!!.
			System.out.println("\n"+ count + " packets received out of "+ no_of_ping);
			
			// Sorting the array and finding the median
			Arrays.sort(timeArray);
			double median;
			if (count % 2 == 0)
				median = ((double) timeArray[count/2] + (double) timeArray[count/2 - 1]) / 2;
			else
				median = (double) timeArray[count/2];
			System.out.println("\nMedian of time = " + median + " ms" );

		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
