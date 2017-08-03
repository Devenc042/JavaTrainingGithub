package devendra.assignment4.part1;

@SuppressWarnings("serial")
class ExceptionCoffee extends Exception{
	public ExceptionCoffee( String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}	
}

@SuppressWarnings("serial")
class ExceptionPool extends Exception{	
	public ExceptionPool( String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}	
}

@SuppressWarnings("serial")
class ExceptionFile extends Exception{	
	public ExceptionFile( String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}	
}

public class TestException {
	
	static boolean meeting=true;
	static boolean officeboy=true;
	static String str;
	static String str2="Mesut Ozil";
	static String str3="Messi";
	
	
	static void methodForException(boolean meeting,boolean officeboy, String str) 
			throws ExceptionPool,ExceptionCoffee,ExceptionFile {
		
		if(meeting) throw new ExceptionPool("  Sorry!! can't play now");
		else System.out.println("Play pool");
		
		if(!officeboy) throw new ExceptionCoffee("  Sorry!! No help for coffee");
		else System.out.println("Enjoy your coffee");
		
		if(str.length()>7) throw new ExceptionFile("  Sorry!! Too long name");
		else System.out.println("Good name");
		
	}
	
	public static void main (String[] args) {
		
		// catches 1st exception
		try {
			methodForException(meeting,officeboy,str2);		
		}catch (Exception e) { System.out.println(e);}
		finally { System.out.println("Run successfully\n");	}
		
		// catches 2nd exception
		try {
			methodForException(!meeting,!officeboy,str2);		
		}catch (Exception e) { System.out.println(e);}
		finally { System.out.println("Run successfully\n");	}		
		
		// catches 3rd exception
		try {
			methodForException(!meeting,officeboy,str2);		
		}catch (Exception e) { System.out.println(e);}
		finally { System.out.println("Run successfully\n");	}
		
		// catches Null pointer exception
		try {
			methodForException(!meeting,officeboy,str);		
		}catch (Exception e) { System.out.println(e);}
		finally { System.out.println("Run successfully\n");	}		
		
		// Run all
		try {
			methodForException(!meeting,officeboy,str3);		
		}catch (Exception e) { System.out.println(e);}
		finally { System.out.println("Run successfully\n");	}		
		
		
	}
}


// Reference
// https://www.javatpoint.com/custom-exception
// https://docs.oracle.com/javase/tutorial/essential/exceptions/creating.html