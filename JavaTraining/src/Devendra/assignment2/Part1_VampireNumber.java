package Devendra.assignment2;

import java.util.Arrays;

public class Part1_VampireNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Part1_VampireNumber vn = new Part1_VampireNumber();
		vn.printVampire();

	}
	
	static int level = 0;		// keep the number of even digits
	static int v = 0, default_vmp =0;
	static int vampirecount = 0;
	public void printVampire() {
		
		int TotalVampire = 10;		// Number of vampire numbers to print
		
		int count=0,max_even=10*10-1;	
		for (int i=10;i<=max_even;i++) {
			
			default_vmp = 0;
			IsVampire(i);
			
			
			if(default_vmp==1)	{
				System.out.println("vampire number ="+i +" level="+level);
				vampirecount = vampirecount +1;
			}			
			if(i==max_even && count<TotalVampire) {
				i = (max_even +1)*10;
				i = i-1; 				// for i++ after this step
				max_even= (max_even+1)*100-1;
				level++;				
			}			
			if(vampirecount ==TotalVampire) {		// when required number of vampires are there, stop 
				return;
			}				
		}		
	}
	
	public void IsVampire(int vn) {
		v = vn;
		int number = vn;
		int digit;
		String str = "";
		
		while(number!=0) {
			digit = number%10;
			number = number/10;
			str = str + (char) (digit+48);
		}
       permutation(str);
	}
	
	public void permutation(String s) {
        char[] original = s.toCharArray();
        Arrays.sort(original);
        char[] clone = new char[s.length()];
        boolean[] mark = new boolean[s.length()];
        Arrays.fill(mark, false);
        permute(original, clone, mark, 0, s.length());
        
    }
	
	private void permute(char[] original, char[] clone, boolean[] mark, int length, int n) {
		
        if (length == n) {
            //System.out.println(clone);
            // making two numbers
            (IsValidNumbers(clone,length));                
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
	
	void IsValidNumbers(char[] clone, int length) {
    	
    	if(clone[0]=='0'|| clone[length/2]=='0') { default_vmp = 0; return; }
    	
    	int x=0;
    	int power=(length/2)-1;
    	for(int i=0;i<length/2;i++) {
    		x = x + Character.getNumericValue(clone[i])*(int)Math.pow(10,power--); 
    	}
    	//System.out.println("level="+level+" x="+x);
    	
    	int y=0;
    	power=(length/2)-1;
    	for(int i=length/2;i<length;i++) {
    		y = y + Character.getNumericValue(clone[i])*(int)Math.pow(10,power--); 
    	}
    	//System.out.print(" y="+y);
    	
    	if(x*y!=v) { default_vmp = 0; return; }
    	if(x%10==0 && y%10==0) { default_vmp = 0; return; }
    	
    	{ default_vmp = 1; return; }   	
    }
}
