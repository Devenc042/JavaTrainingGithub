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
	
	
	public boolean IsVampire( int v) {
		
		return true;
	}
	
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
			
			if(count ==TotalVampire)
			{
				return;
			}
				
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VampireNumber dev = new VampireNumber();
		dev.printVampire();

	}

}
