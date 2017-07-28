package Devendra.assignment2;

import java.util.Arrays;

public class PermutationWithoutRepetition {
	
	public static void main(String[] args)
    {
		int v = 1260;
		int level = 2;
		
		
		int number = v;
		int digit;
		String str = "";
		
		while(number!=0) {
			digit = number%10;
			number = number/10;
			str = str + (char) (digit+48);
		}

        PermutationWithoutRepetition p = new PermutationWithoutRepetition();
        p.permutation(str);
    }
	
	public void permutation(String s) {
        char[] original = s.toCharArray();
        Arrays.sort(original);
        char[] clone = new char[s.length()];
        boolean[] mark = new boolean[s.length()];
        Arrays.fill(mark, false);
        permute(original, clone, mark, 0, s.length());
    }

	int x;
	int y;
	
    private void permute(char[] original, char[] clone, boolean[] mark, int length, int n) {
        if (length == n) {
            System.out.println(clone);
            // making two numbers
            if(IsValidNumbers(clone),length){
            	//yes
            }else{
            	//no
            }
            
            
            return;
        }

        for (int i = 0; i < n; i++) {
            if (mark[i] == true) continue;
            // dont use this state. to keep order of duplicate character
            if (i > 0 && original[i] == original[i-1] && mark[i-1] == false) continue;
            mark[i] = true;
            clone[length] = original[i];
            permute(original, clone, mark, length+1, n);
            mark[i] = false;
        }
    }
    
    boolean IsValidNumbers(char[] clone, int length) {
    	
    	if(clone[0]=='0'|| clone[length/2]=='0') return false;
    	
    	int x=0;
    	int power=(length/2)-1;
    	for(int i=0;i<length/2;i++) {
    		x = x + Character.getNumericValue(clone[i])*(int)Math.pow(10,power--); 
    	}
    	return true;    	
    }

}
