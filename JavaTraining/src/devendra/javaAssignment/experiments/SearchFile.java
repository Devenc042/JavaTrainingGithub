package devendra.javaAssignment.experiments;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SearchFile {
	
	
	public static void main (String[] args) throws IOException {
		
/*		// List all files or folders of a directory
		
		File folder = new File("/home/zemoso/Desktop/JavaGit/JavaTraining/src/devendra/assignment3");
		File[] listOfFiles = folder.listFiles();

	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	        System.out.println("File " + listOfFiles[i].getName());
	      } else if (listOfFiles[i].isDirectory()) {
	        System.out.println("Directory " + listOfFiles[i].getName());
	      }
	    }*/
    
/*		
		System.out.println("Enter your username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Your username is " + username);
		
		char ans='y';
		int i;
		while(ans=='y' || ans=='Y')
		{
			FileReader fr = null;
			try {
				fr = new FileReader(args[0]);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while ((i = fr.read()) != -1) {
				System.out.print((char)i);
			}
			fr.close();
		}
*/
		
/*		
		PathMatcher matcher =
			    FileSystems.getDefault().getPathMatcher("glob:*.{java,class}");

			Path filename = Paths.get("/home/zemosoDesktop/JavaGit/JavaTraining/src/devendra/assignment3/part1");
			if (matcher.matches(filename)) {
			    System.out.println(filename);
			}*/
			
			
			/*Path startingDir = Paths.get(args[0]);
	        String pattern = args[2];

	        Finder finder = new Finder(pattern);
	        Files.walkFileTree(startingDir, finder);
	        finder.done();*/
			
			/*
			File dir = new File("/home/zemoso/Desktop/JavaGit/JavaTraining/src/devendra/assignment3");
		    File[] files = dir.listFiles(new FilenameFilter() {
		        @Override
		        public boolean accept(File dir, String name) {
		            return name.matches("*.*");
		        }
		    });
		    */
		    
		    String regex = "java*.*";
		    final Pattern p = Pattern.compile(regex);
		    
			File dir = new File("/home/zemoso/Desktop/JavaGit/JavaTraining/src/devendra");
		    File[] pagesTemplates = dir.listFiles(new FileFilter() {
		        @Override
		        public boolean accept(File f) {
		            return p.matcher(f.getName()).matches();
		        }
		    });
		    for (int i = 0; i < pagesTemplates.length; i++) {
			      if (pagesTemplates[i].isFile()) {
			        System.out.println("File " + pagesTemplates[i].getName());
			      } else if (pagesTemplates[i].isDirectory()) {
			        System.out.println("Directory " + pagesTemplates[i].getName());
			      }
			    }
	}
	

}



//Reference:
	// https://examples.javacodegeeks.com/core-java/util/regex/list-files-with-regular-expression-filtering/
//
