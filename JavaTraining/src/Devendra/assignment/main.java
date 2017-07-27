/**
 * 
 */
package Devendra.assignment;

/**
 * @author Devendra Choudhary
 * @authorEmail devendra.choudhary@zemosolabs.co
 */
public class main {

	public static void main(String[] args) {
		
		data data2 = new data();
		data2.printGlobal();
		data2.printLocal();		// Local variables need to be initialized.
		
		singleton singleton2 = new singleton();
		//singleton2.printStaticString("Devendra");   // We can not initialized a non static variable in a static method. Only static variable and method can be used in this method.  
		singleton2.printNonstaticString();

	}

}
