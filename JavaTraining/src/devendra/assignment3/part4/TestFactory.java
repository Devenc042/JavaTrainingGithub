package devendra.assignment3.part4;
interface Cycle{
	void Riders(int i);
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
	public void Riders (int i) 	{ System.out.println("You are "+i+" people and will need "+i+" unicycles");	}	
}


class Bicycle implements Cycle{
	public Bicycle() {	System.out.println("bicycle created!!"); }
	public void Riders (int i) {
		int j=i;
		if(i%2!=0)  j=i+1;
		System.out.println("You are "+i+" people and will need "+j/2+" bicycles");
	}
}


class Tricycle implements Cycle{
	public Tricycle() {	System.out.println("tricycle created!!");	}
	public void Riders (int i) {
		int j=i;
		if(i%3!=0) j=i+2;
		System.out.println("You are "+i+" people and will need "+j/3+" tricycles");
	}
}

public class TestFactory{
	public static void main(String args[]) {
		
		int type = 3;
		int passangers = 11;
		
		Cycle c = CycleFactory.create(type);
		System.out.println(c + "\n");
		if(c!=null) {c.Riders(passangers);}
		else { System.out.println("No cycle !!!, Sorry ,Can't ride  :( ");}
	}
	
}


// Reference
//https://stackoverflow.com/questions/7550612/in-simplest-terms-what-is-a-factory
//https://stackoverflow.com/documentation/design-patterns/1375/factory/12131/factory-example-by-implementing-factory-method-java#t=201609281820153329325
