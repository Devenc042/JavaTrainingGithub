/**
 * 
 */
package Devendra.assignment2;

/**
 * @author zemoso
 *
 */
public class VampireNumber {

	/**
	 * @param v = vampire number
	 */

	static int level = 0;
	
	public void printVampire() {
		
		int TotalVampire = 10;
		int count=0,max_even=10*10-1;
		for (int i=10;i<=max_even;i++) {
			
			if(IsVampire(i))
			{
				System.out.println(i);
				count = count +1;
			}
			
			if(i==max_even && count<TotalVampire) {
				i = (max_even +1)*10;
				i = i-1; 				// for i++ after this step
				max_even= (max_even+1)*100-1;
				level++;				
			}
			
			if(count ==TotalVampire) {
				return;
			}
				
		}
		
	}
	
	public boolean IsVampire(int v) {
		
		
		
		return false;
	}
	
	public boolean ConditionMeet(int factor1 , int factor2) {
		int n = (level+1)*2;
		
		int digits1 = ValidDigit(factor1);
		int digits2 = ValidDigit(factor2);
		
		if ((digits1 == digits2) && (digits1 == n/2)) {
			return true;
		}
		return false;
	}
	
	int ValidDigit(int factor1) {
		
		return 1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VampireNumber dev = new VampireNumber();
		dev.printVampire();

	}

}
