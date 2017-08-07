package devendra.assignment6_7.experiments;

public class TestSListIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SList<String> sl = new SList<String>();
		SListIterator<String> slIter = sl.iterator();
		
		System.out.println(sl);
		
		System.out.println("inserting \"hi\"");
		slIter.insert("hi");
		System.out.println(sl);
		
		
		System.out.println("inserting \"there\"");
		slIter.insert("there");
		System.out.println(sl);
		
		System.out.println("inserting \"sweetie\"");
		slIter.insert("sweetie");
		System.out.println(sl);
		
		System.out.println("inserting \"pie\"");
		slIter.insert("pie");
		System.out.println(sl);
		
		
		
		SListIterator<String> slIter2 = sl.iterator();
		System.out.println("removing \"hi\"");
		slIter2.remove();
		System.out.println(sl);
		
		System.out.println("inserting \"hello\"");
		slIter2.insert("hello");
		System.out.println(sl);
		
		System.out.println("removing \"there\"");
		slIter2.remove();
		System.out.println(sl);
		
		System.out.println("removing \"sweetie\"");
		slIter2.remove();
		System.out.println(sl);
		
		System.out.println("removing \"pie\"");
		slIter2.remove();
		System.out.println(sl);
		
		System.out.println("removing \"hello\"");
		SListIterator<String> slIter3 = sl.iterator();
		slIter3.remove();
		System.out.println(sl);
	}

}
