package devendra.javaAssignment.experiments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReachableTest {
 public static void main(String args[]) {
     /*try {
       InetAddress address = InetAddress.getByName("www.google.com");
       System.out.println("Name: " + address.getHostName());
       System.out.println("Addr: " + address.getHostAddress());
       System.out.println("Reach: " + address.isReachable(300000));
     }
     catch (UnknownHostException e) {
       System.err.println("Unable to lookup web.mit.edu");
     }
     catch (IOException e) {
       System.err.println("Unable to reach web.mit.edu");
     }*/
     
     /*
     long currentTime = System.currentTimeMillis();
     boolean isPinged = InetAddress.getByName("8.8.8.8").isReachable(2000); // 2 seconds
     currentTime = System.currentTimeMillis() - currentTime;
     if(isPinged) {
         System.out.println("pinged successfully in "+ currentTime+ "millisecond");
     } else {
         System.out.println("PIng failed.");
     }
     */
	 
	 
	 
     
     String ip = "www.google.com";
     String pingResult = "";
     int no_of_ping=5;
     String pingCmd = "ping " + ip + " -c "+ no_of_ping;    
     
     String RegexPattern = "time=\\d+(\\.\\d+)?\\sms";
     Pattern pattern = Pattern.compile(RegexPattern);
     Matcher matcher ;
		
		
     try 
     {
         Runtime r = Runtime.getRuntime();
         Process p = r.exec(pingCmd);

         BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
         String inputLine;
         int count=0;
         double[] timeArray = new double[no_of_ping];
         
         while ((inputLine = in.readLine()) != null) 
         {
             System.out.println(inputLine);
//             if(inputLine.length()>0)
//             if(inputLine.matches("time=\\d+(\\.\\d+)?\\sms"))
             
             matcher = pattern.matcher(inputLine);
        		if(matcher.find()) 
        		
        		
             {
        			System.out.println("Found");
            	 pingResult += inputLine;
            	 String number = inputLine.substring(inputLine.lastIndexOf("time=")+5, inputLine.length()-3);
            	 System.out.println("length="+number.length()+" "+number);
            	 if(number.length()>0) timeArray[count++]= Double.parseDouble(number);
            	 System.out.println("digit="+ timeArray[count-1]);
             }
        		else System.out.println("Not Found");
         }
         in.close();
         
         Arrays.sort(timeArray);
         double median;
         if (timeArray.length % 2 == 0)
             median = ((double)timeArray[timeArray.length/2] + (double)timeArray[timeArray.length/2 - 1])/2;
         else
             median = (double) timeArray[timeArray.length/2];
         System.out.println("Median of time:" + median);
         
     } 
     catch (IOException e) 
     {
         System.out.println(e);
     }
   }
}
