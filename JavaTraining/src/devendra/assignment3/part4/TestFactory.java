package devendra.assignment3.part4;
interface Cycle{
	
}

class CycleFactory{
	static public Cycle create(int i)
	{
		switch (i) 
		{
	    case 0: break;
	    case 1: return new Unicycle(); 
	    case 2: return new Bicycle();
	    case 3: return new Tricycle();
	    default: break;
	    }
		return null;
	}
}

class Unicycle implements Cycle{
	public Unicycle() 	{ System.out.println("unicycle created!!");	}
	public void Riders (int i) 	{ System.out.println("You will need "+i+" unicycles");	}	
}


class Bicycle implements Cycle{
	public Bicycle() {	System.out.println("bicycle created!!"); }
	public void Riders (int i) {
		if(i%2!=0) i=i+1;
		System.out.println("You will need "+i/2+" bicycles");
	}
}


class Tricycle implements Cycle{
	public Tricycle() {	System.out.println("tricycle created!!");	}
	public void Riders (int i) {
		if(i%3!=0) i=i+2;
		System.out.println("You will need "+i/3+" tricycles");
	}
}

public class TestFactory{
	public static void main(String args[]) {
		Cycle c = CycleFactory.create(1);
		System.out.println(c);
	}
	
}
