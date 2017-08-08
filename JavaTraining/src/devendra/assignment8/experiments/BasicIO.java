package devendra.assignment8.experiments;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.io.FileWriter;

public class BasicIO {

	public static void main(String[] args) throws IOException {
		int i, count;

		/*
		 * // Basic IO operation 
		 * i=System.in.read();//returns ASCII code of 1st
		 * character System.out.println((char)i);//will print the character
		 */

		/*
		 * // To print the content of file 
		 * FileReader fr=new FileReader(args[0]);
		 * while((i=fr.read())!=-1) System.out.print((char)i); fr.close();
		 */

		// Reading the input file and putting all character in HashMap
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		FileReader fr = new FileReader(args[0]);
		while ((i = fr.read()) != -1) {
			if (hmap.containsKey((char) i) == false) {
				hmap.put((char) i, 1);
			} else {
				count = hmap.get((char) i) + 1;
				hmap.put((char) i, count);
			}
		}
		fr.close();

		/*
		 * // Printing the each character count to console
		for (Map.Entry m : hmap.entrySet()) {
			System.out.println("\"" + m.getKey() + "\"" + " " + m.getValue());
		}
		*/

		
		// Writing the count of occurrence of character to testoutput.txt file
		try {
			FileWriter fw = new FileWriter(args[1]);

			fw.write("\n Input file path: " + args[0]);
			fw.write("\n Output file path: " + args[1]);
			fw.write("\n \n Count of the occurrence of all the different characters \n \n");
			for (Map.Entry m : hmap.entrySet()) {
				fw.write("\n\"" + m.getKey() + "\"" + "  " + m.getValue());
			}
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...");
	}

}
