package devendra.assignment2.part1;

import java.util.Arrays;

public class SingleVampire {

	/*Main function and keep counting vampire till they reach 100*/
	public static void main(String[] args) {
		SingleVampire vmp = new SingleVampire();		
		
		for (int i=1000;i<900000;i++) {
		vmp.IsVampire(i);
		if(count==100)
			break;
		}
	}
	
	/*Static variables for checking whether a number is vampire or not , and total count*/
	static int foundonce = 0;
	static int count = 0;
	
	
	/*Method to check whether a number is vampire, 
	It first break the number into string and check their all permuatation*/
	public void IsVampire(int vn) 
	{
		foundonce = 0;
		int number = vn;
		int digit;
		String str = "";
		
		while(number!=0) {
			digit = number%10;
			number = number/10;
			str = str + (char) (digit+48);
		}
       permutation(str,vn);
	}
	
	/*Method for converting of string into char array and find all permuatation*/
	public void permutation(String s , int vn) 
	{
        char[] original = s.toCharArray();
        Arrays.sort(original);
        char[] clone = new char[s.length()];
        boolean[] mark = new boolean[s.length()];
        Arrays.fill(mark, false);
        permute(original, clone, mark, 0, s.length(), vn);   
    }
	
	/*This method do permuatation and also pass vampire number to finally check for its vampirety*/
	private void permute(char[] original, char[] clone, boolean[] mark, int length, int n, int vn) 
	{	
		if(foundonce==1) return;
		
        if (length == n) 
        {
            IsValidNumbers(clone,length,vn);
            return;
        }
        for (int i = 0; i < n; i++) 
        {
            if (mark[i] == true) continue;
            // dont use this state. to keep order of duplicate character
            if (i > 0 && original[i] == original[i-1] && mark[i-1] == false) continue;
            mark[i] = true;
            clone[length] = original[i];
            permute(original, clone, mark, length+1, n ,vn);
            mark[i] = false;
        }     
    }
	
	/*Breaking number into two and checking their validity*/
	void IsValidNumbers(char[] clone, int length , int vn) 
	{	
		//If leading digit is zero of either broken number, then not a vampire
    	if(clone[0]=='0'|| clone[length/2]=='0')
    	{  
    		return; 
    	}
    	
    	// creating two broken numbers x and y
    	int x=0;
    	int power=(length/2)-1;
    	for(int i=0;i<length/2;i++) {
    		x = x + Character.getNumericValue(clone[i])*(int)Math.pow(10,power--); 
    	}
    	
    	int y=0;
    	power=(length/2)-1;
    	for(int i=length/2;i<length;i++) {
    		y = y + Character.getNumericValue(clone[i])*(int)Math.pow(10,power--); 
    	}
    	
    	// If product of x and y is not equal to vampire no, then not a vampire
    	if(x*y!=vn)
    	{ 
    		return; 
    	}
    	
    	// Both x and y should not contain zero at unit digit
    	if(x%10==0 && y%10==0)
    	{ 
    		return; 
    	}
    	
    	// Finally, it passed all condition so vampire number
    	foundonce =1;
    	count++;
    	System.out.println("Found vampire!!!!!! = "+ vn + " "+"    x="+ x + "  y="+y + "   count"+count );   	
    	return;     	
    }

}

/*
Output:

	Found vampire!!!!!! = 1260     x=21  y=60   count1
	Found vampire!!!!!! = 1395     x=15  y=93   count2
	Found vampire!!!!!! = 1435     x=35  y=41   count3
	Found vampire!!!!!! = 1530     x=30  y=51   count4
	Found vampire!!!!!! = 1827     x=21  y=87   count5
	Found vampire!!!!!! = 2187     x=27  y=81   count6
	Found vampire!!!!!! = 6880     x=80  y=86   count7
	Found vampire!!!!!! = 102510     x=201  y=510   count8
	.
	.
	.
	.
	Found vampire!!!!!! = 315594     x=534  y=591   count92
	Found vampire!!!!!! = 315900     x=351  y=900   count93
	Found vampire!!!!!! = 319059     x=351  y=909   count94
	Found vampire!!!!!! = 319536     x=336  y=951   count95
	Found vampire!!!!!! = 326452     x=524  y=623   count96
	Found vampire!!!!!! = 329346     x=342  y=963   count97
	Found vampire!!!!!! = 329656     x=356  y=926   count98
	Found vampire!!!!!! = 336550     x=530  y=635   count99
	Found vampire!!!!!! = 336960     x=360  y=936   count100
	*/
	
	
