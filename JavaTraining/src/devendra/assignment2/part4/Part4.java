package devendra.assignment2.part4;

public class Part4 {
	
	Part4(String str){
		System.out.println(str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Part4 [] array = new Part4[5];	
		for(int i=0;i<array.length;i++) {
			array[i] = new Part4(i + " coffee arrived!!");
		}
	}

}