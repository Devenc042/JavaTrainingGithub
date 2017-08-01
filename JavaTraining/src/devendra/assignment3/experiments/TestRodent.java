package devendra.assignment3.experiments;

abstract class Rodent {
	Rodent(){
		System.out.println("Rodent was here");
	}	
	abstract void Eat();
	abstract void Sleep();
	abstract void Code();
}

 class Mouse extends Rodent {
	 
	 Mouse(){
		 System.out.println("Mouse was here");
	 }	 
	 void Eat() { System.out.println("Mouse likes to eat");}
	 void Sleep() { System.out.println("Mouse likes to sleep");}
	 void Code() { System.out.println("Mouse likes to code");}
}
 
 class Gerbil extends Rodent {
	 
	 Gerbil(){
		 System.out.println("Gerbil was here");
	 }	 
	 void Eat() { System.out.println("Gerbil likes to eat");}
	 void Sleep() { System.out.println("Gerbil likes to sleep");}
	 void Code() { System.out.println("Gerbil likes to code");}
}
 class Hamster extends Rodent {
	 
	 Hamster(){
		 System.out.println("Hamster was here");
	 }	 
	 void Eat() { System.out.println("Hamster likes to eat");}
	 void Sleep() { System.out.println("Hamster likes to sleep");}
	 void Code() { System.out.println("Hamster likes to code");}	
}
 
 class TestRodent {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Rodent[] r = new Rodent[3] ;
			r[0] = new Mouse();
			r[0].Eat();
			
			r[1] = new Gerbil();
			r[1].Sleep();
			
			r[2] = new Hamster();
			r[2].Code();
		}
 }
