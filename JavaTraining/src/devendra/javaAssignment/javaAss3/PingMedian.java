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

/*
// Output

Enter the ip: 
www.google.com
Enter number of ping: 
7
PING www.google.com (172.217.27.4) 56(84) bytes of data.
64 bytes from sin11s02-in-f4.1e100.net (172.217.27.4): icmp_seq=1 ttl=53 time=52.2 ms
64 bytes from sin11s02-in-f4.1e100.net (172.217.27.4): icmp_seq=2 ttl=53 time=58.9 ms
64 bytes from sin11s02-in-f4.1e100.net (172.217.27.4): icmp_seq=3 ttl=53 time=49.5 ms
64 bytes from sin11s02-in-f4.1e100.net (172.217.27.4): icmp_seq=4 ttl=53 time=50.1 ms
64 bytes from sin11s02-in-f4.1e100.net (172.217.27.4): icmp_seq=5 ttl=53 time=48.2 ms
64 bytes from sin11s02-in-f4.1e100.net (172.217.27.4): icmp_seq=6 ttl=53 time=48.9 ms
64 bytes from sin11s02-in-f4.1e100.net (172.217.27.4): icmp_seq=7 ttl=53 time=50.9 ms

--- www.google.com ping statistics ---
7 packets transmitted, 7 received, 0% packet loss, time 6007ms
rtt min/avg/max/mdev = 48.293/51.288/58.952/3.355 ms

7 packets received out of 7

Median of time:50.1 ms

*/


// Reference
// https://stackoverflow.com/questions/8815012/how-to-run-ping-command-and-get-ping-host-summary
// http://www.sanfoundry.com/10-ping-command-usage-examples-linux/
//http://www.rexegg.com/regex-quickstart.html
//https://stackoverflow.com/questions/4007302/regex-how-to-match-an-optional-character
//https://stackoverflow.com/questions/3674930/java-regex-meta-character-and-ordinary-dot
// https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
// https://www.tutorialspoint.com/java/java_strings.htm
// https://stackoverflow.com/questions/11955728/how-to-calculate-the-median-of-an-array

