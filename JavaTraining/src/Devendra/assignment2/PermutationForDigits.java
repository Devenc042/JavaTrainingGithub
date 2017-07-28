package Devendra.assignment2;

public class PermutationForDigits {
	
	
	int v = 1223;
	int level = 2;
	
	public void FindingDigits(int v) {
		int n = v;
		int digit;
		String str = "";
		
		while(n!=0) {
			digit = n%10;
			n = n/10;
			str = str + (char) (digit+48);
		}
        System.out.println(str);
        System.out.println("");



	char[] input = str.toCharArray();
	char[] output = input.clone();
	printPermute(output, input, 0);	
	}	


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
    

	
	public static void main(String[] args) {
		PermutationForDigits p = new PermutationForDigits();
		p.FindingDigits(125);
		
	}
}
