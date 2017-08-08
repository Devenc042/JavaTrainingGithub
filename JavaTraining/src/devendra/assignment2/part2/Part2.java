package devendra.assignment2.part2;

/*Question
Create a class with two (overloaded) constructors. 
Using this, call the second constructor inside the first one.*/


public class Part2 {

	int Rollno;
	String Name;
	int Batch;
	
	/*First constructor*/
	Part2(int rn, String nm){
		this(rn,nm,3);
	}
	
	/*Second constructor*/
	Part2(int rn, String nm, int batch){
		this.Rollno = rn;
		this.Name = nm;
		this.Batch =batch;
		
	}
	
	public void display(){
		System.out.println(this.Rollno);
		System.out.println(this.Name);
		System.out.println(this.Batch);
	}
	public static void main(String[] args) {		
		Part2 p = new Part2(123,"Devendra");
		p.display();
		
	}

}
