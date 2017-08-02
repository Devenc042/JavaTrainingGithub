package devendra.assignment3.experiments;

import devendra.assignment3.experiments.Cycle.Bicycle;
import devendra.assignment3.experiments.MotorCycle.Bimotorcycle;

class Cycle {
	
	class Bicycle{
		Bicycle(String s) { System.out.println(s +" Bicycle created");}
	}
}


class MotorCycle {
	
	class Bimotorcycle extends Bicycle{
/*	Implicit super constructor Cycle.Bicycle() is undefined for default constructor. Must define an explicit constructor */
		Bimotorcycle(Cycle cycle, String s) {
			cycle.super(s);
			System.out.println(s +" BiMotorCycle created");
		}	
	}
}

public class TestBimotorcycle {
	
	Bimotorcycle bmc = new Bimotorcycle(cycle, "Hero");
	
	
}
