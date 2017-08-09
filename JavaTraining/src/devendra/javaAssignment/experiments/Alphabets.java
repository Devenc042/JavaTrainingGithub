package devendra.javaAssignment.experiments;

import java.util.Scanner;

public class Alphabets {

	public static void main(String[] args) {
		boolean[] alpha = new boolean [26];
		int total=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String:\n");
		char[] input = sc.next().toCharArray();
		sc.close();
		
		int value;
		for(int i=0;i<input.length;i++) {
			
			
			value = ((int)Character.toLowerCase(input[i]))-97;
			if(value>=0 && value<=25)
				if(alpha[value]==false) 
					{
						alpha[value]=true; 
						total++;
					}
			
			if(total==26) { System.out.println("Success :)");	 return; }	
		}
		System.out.println("Sorry :(  , String doesnt contain all characters");
	}
	

}
