package devendra.javaAssignment.javaAss2;

import java.util.Scanner;

public class Alphabets {

	public static void main(String[] args) {
		
		// boolean array to store all small case alphabets (a-z)
		boolean[] alpha = new boolean [26];
		
		
		// Taking input into a character array
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String:");
		char[] input = sc.next().toCharArray();
		sc.close();
		
		// If input is alphabet, put that into array and increase total till total reaches 26 or end of input array
		int value,total=0;
		for(int i=0;i<input.length;i++) 
		{			
			value = ((int)Character.toLowerCase(input[i]))-97;
			if(value>=0 && value<=25)
			{
				if(alpha[value]==false) 
					{
						alpha[value]=true; 
						total++;
					}	
			}		
			if(total==26) 
			{ 
				System.out.println("Success :)");
				return; 
			}	
		}
		
		// if total is not 26, not all alphabets occurred in input
		System.out.println("Sorry :(  , String doesnt contain all characters");
	}
}


// Time and space complexity



