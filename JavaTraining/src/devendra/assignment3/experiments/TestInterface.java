package devendra.assignment3.experiments;


// Three Interfaces
 interface Interface1{
	int method11(int a, int b);
	int method12(int c, String s);
}
 
 interface Interface2{
		int method21(int a, int b);
		int method22(int c, String s);
}

 interface Interface3{
		int method31(int a, int b);
		int method32(int c, String s);
}
 

 // Grouped Interface
 interface GroupedInterface extends Interface1,Interface2,Interface3{
	 void printGroup();	
 }
 
 
 // a class
 class Team{
	 String team = "Arsenal";
	 int jersy = 11;
 }
 
 
 // Concrete class
 class Manager extends Team implements GroupedInterface {

	public int method11(int a, int b) {
		System.out.println("Concrete class: sum = "+ (a+b));
		return 0;
	}

	public int method12(int c, String s) {
		System.out.println("Concrete class: Jersy = "+ c +" Player =" + s);
		return 0;
	}

	public void printGroup() {
		System.out.println("COYG");	
	}


	public int method21(int a, int b) {
		return 0;
	}

	public int method22(int c, String s) {
		System.out.println("Concrete class: Jersy = "+ c +" Player =" + s);
		return 0;
	}

	public int method31(int a, int b) {
		return 0;
	}

	public int method32(int c, String s) {
		System.out.println("Concrete class: Jersy = "+ c +" Player =" + s);
		return 0;
	}
	 
 }

public class TestInterface {
	
	public static void method1(Interface1 i1) { i1.method11(1,3);}
	public static void method2(Interface2 i2) { i2.method22(17,"Sanchez");}
	public static void method3(Interface3 i3) { i3.method32(11,"Ozil");}
	public static void method4(GroupedInterface i4) { i4.printGroup();}
	
	

	public static void main(String[] args) {
		
		Manager wenger = new Manager();
		method1(wenger);
		method2(wenger);
		method3(wenger);
		method4(wenger);

	}

}


