package devendra.assignment3.part5;

import devendra.assignment3.part5.Cycle.Bicycle;
import devendra.assignment3.part5.Motorcycle.Bimotorcycle;

class Cycle{
	
	class Bicycle{
		Bicycle(String s) { System.out.println(s +" Bicycle created");}
	}
}


class Motorcycle {
	
	class Bimotorcycle extends Bicycle{
/*	Implicit super constructor Cycle.Bicycle() is undefined for default constructor. Must define an explicit constructor */
		Bimotorcycle(Cycle cycle, String s) {
			cycle.super(s);
			System.out.println(s +" BiMotorCycle created");
		}
		int speed;
		void setSpeed(int i) { speed = i; }
		int getSpeed() {return speed;}
	}
}

public class TestBimotorcycle {

	public static void main(String[] args) {

		Cycle cycle = new Cycle();
		Motorcycle mc = new Motorcycle();
		Bimotorcycle bmc = mc.new Bimotorcycle(cycle, "Honda");
		bmc.setSpeed(50);
		System.out.println("Speed of motorcycle is "+bmc.getSpeed()+ "kmph");
	}
}
