package devendra.assignment2.part3;

public class Part3 {
	
	Part3(String str){
		System.out.println(str);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Part3 [] array = new Part3[10];	
	}

}

// When you run the program, notice whether the initialization messages from the constructor calls are printed.

// It is not printed.

// if we do Part3 [] array=new Part3[10]; then no objects are created except your array, 
// each field will be null until you initialize it. 
// Above only create place to store reference of Part3 Class object. 
// Although Array array is created but its not referencing any object and we can't do like array[i].someMethod(). 
