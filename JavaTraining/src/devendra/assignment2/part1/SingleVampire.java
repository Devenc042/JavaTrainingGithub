package devendra.assignment2.part1;

import java.util.Arrays;

public class SingleVampire {

	public static void main(String[] args) {
		SingleVampire vmp = new SingleVampire();
		
		
		for (int i=1000;i<900000;i++) {
		vmp.IsVampire(i);
		if(count==100)
			break;
		}
	}
	
	
	static int foundonce = 0;
	static int count = 0;
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
	
	public void permutation(String s , int vn) 
	{
        char[] original = s.toCharArray();
        Arrays.sort(original);
        char[] clone = new char[s.length()];
        boolean[] mark = new boolean[s.length()];
        Arrays.fill(mark, false);
        permute(original, clone, mark, 0, s.length(), vn);   
    }
	
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
	
	void IsValidNumbers(char[] clone, int length , int vn) 
	{	
    	if(clone[0]=='0'|| clone[length/2]=='0')
    	{ 
    		//System.out.println("Not vampire = "+ new String (clone)); 
    		return; 
    	}
    	
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
    	
    	if(x*y!=vn)
    	{ 
    		//System.out.println("Not vampire = "+ new String (clone)); 
    		return; 
    	}//{ System.out.println("Not vampire = "+ new String (clone)); return; } 
    	if(x%10==0 && y%10==0)
    	{ 
    		//System.out.println("Not vampire = "+ new String (clone)); 
    		return; 
    	}//{  System.out.println("Not vampire = "+ new String (clone)); return; } 
    	
//    	System.out.println("Found vampire!!!!!! = "+ vn + " "+ new String (clone)+"    x="+ x + "y="+y);
    	foundonce =1;
    	count++;
    	System.out.println("Found vampire!!!!!! = "+ vn + " "+"    x="+ x + "  y="+y + "   count"+count );
    	
    	return;     	
    }

}
