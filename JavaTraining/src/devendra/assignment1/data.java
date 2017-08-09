/**
 * 
 */
package devendra.assignment1;

/**
 * @author Devendra Choudhary
 * @authorEmail devendra.choudhary@zemosolabs.com
 *
 */

public class data {
	
	int a;
	char c;
	
	void printGlobal() {
		System.out.println("Global a = " + a);
		System.out.println("Global c = " + c);
	}
	
	void printLocal() {
		/*int a;
		char c;
		System.out.println("Global a = " + a);
		System.out.println("Global c = " + c);*/
		// Local variables need to be initialized. 
	}
	
}


//Learning:

/*It's not always necessary to assign a value when a field is declared. 
Fields that are declared but not initialized will be set to a reasonable default by the compiler.
Generally speaking, this default will be zero or null, depending on the data type. 
Relying on such default values, however, is generally considered bad programming style.

For type char, the default value is the null character, that is, '\u0000
For type int, the default value is zero, that is, 0

Local variables are slightly different; 
the compiler never assigns a default value to an uninitialized local variable. 
If you cannot initialize your local variable where it is declared, make sure to assign it a value before you attempt to use it. 
Accessing an uninitialized local variable will result in a compile-time error.

member variable (default OK)
static variable (default OK)
final member variable (not initialized, must set on constructor)
final static variable (not initialized, must set on a static block {})
local variable (not initialize

*/