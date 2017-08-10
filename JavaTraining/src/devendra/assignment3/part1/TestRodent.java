package devendra.assignment3.part1;

abstract class Rodent {
	Rodent(){
		System.out.println("Rodent was here");
	}	
	abstract void eat();
	abstract void sleep();
	abstract void code();
}

 class Mouse extends Rodent {
	 
	 Mouse(){
		 System.out.println("Mouse was here");
	 }	 
	 void eat() { System.out.println("Mouse likes to eat");}
	 void sleep() { System.out.println("Mouse likes to sleep");}
	 void code() { System.out.println("Mouse likes to code");}
}
 
 class Gerbil extends Rodent {
	 
	 Gerbil(){
		 System.out.println("Gerbil was here");
	 }	 
	 void eat() { System.out.println("Gerbil likes to eat");}
	 void sleep() { System.out.println("Gerbil likes to sleep");}
	 void code() { System.out.println("Gerbil likes to code");}
}
 class Hamster extends Rodent {
	 
	 Hamster(){
		 System.out.println("Hamster was here");
	 }	 
	 void eat() { System.out.println("Hamster likes to eat");}
	 void sleep() { System.out.println("Hamster likes to sleep");}
	 void code() { System.out.println("Hamster likes to code");}	
}
 
 class TestRodent {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Rodent[] r = new Rodent[3] ;
			r[0] = new Mouse();
			r[0].eat();
			r[0].sleep();
			r[0].code();
			
			r[1] = new Gerbil();
			r[1].eat();
			r[1].sleep();
			r[1].code();
			
			r[2] = new Hamster();
			r[2].eat();
			r[2].sleep();
			r[2].code();
		}
 }
