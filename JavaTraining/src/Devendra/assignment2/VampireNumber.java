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
		
		int TotalVampire = 105;
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
				
				
			}
			
			if(count ==TotalVampire) {
				return;
			}
				
		}
		
	}
	
	public boolean IsVampire(int v) {
		int start_level = (int) Math.pow(10, level);
		int factor1,factor2;
		for (int i=start_level; i*i<=v ; i++) {
			
			if(v%i==0) {
				factor1 = i;
				factor2 = v/i;
				
				if(ConditionMeet(factor1,factor2)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean ConditionMeet(int factor1 , int factor2) {
		level = 5;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VampireNumber dev = new VampireNumber();
		dev.printVampire();

	}

}
