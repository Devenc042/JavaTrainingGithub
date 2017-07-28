package Devendra.assignment2;

public class Permutation {
	
	int v = 1223;
	int level = 2;
	
	public void FindingDigits(int v) {
		int n = v;
		int digit,count=0;
		int[] Digits = new int[level*2];
		
//		System.out.println("Reverse digit=");
		while(n!=0) {
			digit = n%10;
			n = n/10;
			Digits[count++]=digit;
//			System.out.println(digit);
		}
		
//		for(int i=0; Digits[i]!='\0';i++)
//			System.out.println(Digits[i]);
		
		    
			//code
			String str = "ABC";
			char[] input = str.toCharArray();
			char[] output = input.clone();
			printPermute(output, input, 0);
			
		
		
		private static void printPermute(char[] output,char[] input, int index){
		    
		    if(index == input.length){
		        System.out.println(output);
		        return;
		    }
		    
		    for(int i=0; i<input.length; i++){
		        output[index] = input[i];
		        printPermute(output, input, index+1);
		    }
		    
		}
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Permutation p = new Permutation();
		p.FindingDigits(1258);
		
	}

}
