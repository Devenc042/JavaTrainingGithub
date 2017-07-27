/**
 * 
 */
package Devendra.assignment;

/**
 * @author Devendra Choudhary
 * @authorEmail devendra.choudhary@zemosolabs.co
 */
public class singleton {
	
	String s;
	
	/*static String printStaticString (String new_string) {
		s = new_string;
		return s;
		// can not make a static reference to the non-static field	
	}*/
	
	void printNonstaticString () {
		System.out.println("Non static method, s = " + s);
	}
	
}


// Learning
/*
Static variables
When a variable is declared with the keyword static, its called a class variable. 
All instances share the same copy of the variable. 
A class variable can be accessed directly with the class, without the need to create a instance

# It is a variable which belongs to the class and not to object(instance)
# Static variables are initialized only once , at the start of the execution . These variables will be initialized first, before the initialization of any instance variables
# A single copy to be shared by all instances of the class
# A static variable can be accessed directly by the class name and doesn’t need any object
# Syntax : <class-name>.<variable-name>

Non Static variables
Without the static keyword, it’s called instance variable, 
and each instance of the class has its own copy of the variable.


Static Method

# It is a method which belongs to the class and not to the object(instance)
# A static method can access only static data. It can not access non-static data (instance variables)
# A static method can call only other static methods and can not call a non-static method from it.
# A static method can be accessed directly by the class name and doesn’t need any object
# Syntax: <class-name>.<method-name>
# A static method cannot refer to this or super keywords in anyway

Static Block
The static block, is a block of statement inside a Java class 
that will be executed when a class is first loaded into the JVM.*/