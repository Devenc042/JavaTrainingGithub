package devendra.assignment2.part2;

public class Part2 {

	int Rollno;
	String Name;
	int Batch;
	
	Part2(int rn, String nm){
		this(rn,nm,3);
	}
	
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
		// TODO Auto-generated method stub
		
		Part2 p = new Part2(123,"Devendra");
		p.display();
		
	}

}
