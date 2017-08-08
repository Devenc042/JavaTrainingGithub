package devendra.assignment2.part4;

/*Question:
	Complete the previous exercise by creating objects to attach to the array of references.
*/	
	
public class Part4 
{	
	Part4(String str)
	{
		System.out.println(str);
	}

	public static void main(String[] args) 
	{
		Part4 [] array = new Part4[5];	
		for(int i=0;i<array.length;i++) 
		{
			// creating objects to attach to the array of references
			array[i] = new Part4(i + " coffee arrived!!");
		}
	}

}


// Output:

// 0 coffee arrived!!
// 1 coffee arrived!!
// 2 coffee arrived!!
// 3 coffee arrived!!
// 4 coffee arrived!!
