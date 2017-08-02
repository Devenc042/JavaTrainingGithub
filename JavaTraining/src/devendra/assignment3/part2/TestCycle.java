package devendra.assignment3.part2;

class Cycle{
	Cycle(){ System.out.println("In cycle class");}
	
}
class Unicycle extends Cycle{
	Unicycle(){ System.out.println("In unicycle class");}
	void balance() { System.out.println("Unicycle balance");}
}
class Bicycle extends Cycle{
	Bicycle(){ System.out.println("In bicycle class");}
	void balance() { System.out.println("Bicycle balance");}
}
class Tricycle extends Cycle{
	Tricycle(){ System.out.println("In tricycle class");}
	
}


public class TestCycle {

	public static void main (String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\nCreating instance of each classs");
		Unicycle uc = new Unicycle();
		Bicycle bc = new Bicycle();
		Tricycle tc = new Tricycle();
		
		System.out.println("\nCasting them to array");
		Cycle[] cycle = new Cycle[3];
		System.out.println("\nUp-casting");
		cycle[0]= uc;
		cycle[1]= bc;
		cycle[2]= tc;
		
//		cycle[0].balance();		// balance() method is not defined in cycle class so either need to downcast to Unicycle class
//		cycle[1].balance();
//		cycle[2].balance();
		
		System.out.println("\nDown-casting");
		Unicycle down_uc = (Unicycle) cycle[0];
		Bicycle down_bc = (Bicycle) cycle[1];
		Tricycle down_tc = (Tricycle) cycle[2];
		
		down_uc.balance();
		down_bc.balance();
//		down_tc.balance();		// The method balance() is undefined for the type Tricycle 
		
		}
	}
