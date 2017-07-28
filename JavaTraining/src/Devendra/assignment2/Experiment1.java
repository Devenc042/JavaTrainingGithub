package Devendra.assignment2;

public class Experiment1 {
	
		boolean IsValidNumbers(char[] clone, int length) {
    	
    	if(clone[0]=='0'|| clone[length/2]=='0') return false;
    	
    	int x=0;
    	int power=(length/2)-1;
    	for(int i=0;i<length/2;i++) {
    		x = x + Character.getNumericValue(clone[i])*(int)Math.pow(10,power--); 
    	}
    	System.out.println(x);
    	
    	int y=0;
    	power=(length/2)-1;
    	for(int i=length/2;i<length;i++) {
    		y = y + Character.getNumericValue(clone[i])*(int)Math.pow(10,power--); 
    	}
    	System.out.println(y);
    	
    	if(x*y!=v) return false;
    	if(x%10==0 && y%10==0) return false;
    	
    	return true;    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] clone = {'2','3','4','5','6','7'};
		Experiment1 e = new Experiment1();
		e.IsValidNumbers(clone, 6);
		

	}

}
