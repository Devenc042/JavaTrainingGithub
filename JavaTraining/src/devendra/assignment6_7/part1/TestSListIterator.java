package devendra.assignment6_7.part1;

public class TestSListIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SList<String> sl = new SList<String>();
		SListIterator<String> slIter = sl.iterator();
		
		System.out.println(sl);
		
		System.out.println("inserting \"one\"");
		slIter.insert("one");
		System.out.println(sl);
		
		
		System.out.println("inserting \"two\"");
		slIter.insert("two");
		System.out.println(sl);
		
		System.out.println("inserting \"three\"");
		slIter.insert("three");
		System.out.println(sl);
		
		System.out.println("inserting \"four\"");
		slIter.insert("four");
		System.out.println(sl);
		
		
		
		SListIterator<String> slIter2 = sl.iterator();
		System.out.println("removing \"one\"");
		slIter2.remove();
		System.out.println(sl);
		
		System.out.println("inserting \"five\"");
		slIter2.insert("five");
		System.out.println(sl);
		
		System.out.println("removing \"two\"");
		slIter2.remove();
		System.out.println(sl);
		
		System.out.println("removing \"three\"");
		slIter2.remove();
		System.out.println(sl);
		
		System.out.println("removing \"four\"");
		slIter2.remove();
		System.out.println(sl);
		
		System.out.println("removing \"five\"");
		SListIterator<String> slIter3 = sl.iterator();
		slIter3.remove();
		System.out.println(sl);
	}

}

//Object next( )
//
//Returns the next element. Throws NoSuchElementException if there is not a next element.

//void remove( )
//
//Removes the current element. Throws IllegalStateException if an attempt is made to call remove( ) that is not preceded by a call to next( ).

/*
// Output:


SList: []
inserting "one"
SList: [one]
inserting "two"
SList: [one, two]
inserting "three"
SList: [one, two, three]
inserting "four"
SList: [one, two, three, four]
removing "one"
SList: [two, three, four]
inserting "five"
SList: [five, two, three, four]
removing "two"
SList: [five, three, four]
removing "three"
SList: [five, four]
removing "four"
SList: [five]
removing "five"
SList: []

*/		
		
