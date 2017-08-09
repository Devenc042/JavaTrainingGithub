package devendra.javaAssignment.experiments;
import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RecursiveFileSearch {

/*	@path = Main directory where to search
	@regex = valid regex expression*/
	
	public void FindFile(String path, String regex)
	{	
		// Taking a root path and listing all its directory and files
		File root = new File( path );
        File[] list = root.listFiles();
        if (list == null) { System.out.println("null path :"+path); return;  }  
        
        // Matching the file or directory with regex pattern and printing absolute path
        final Pattern p = Pattern.compile(regex);
	    File[] matchingFiles = root.listFiles(new FileFilter() {
	        @Override
	        public boolean accept(File f) {
	            return p.matcher(f.getName()).matches();
	        }
	    });
	    for (File i : matchingFiles) {
		      if (i.isFile()) {
		        System.out.println("File :" + i.getAbsolutePath());
		      } else if (i.isDirectory()) {
		        System.out.println("Directory :" + i.getAbsolutePath());
		      }
		    }
        
	    // Checking the directory and if it has subdirectory, search in that also . Otherwise do nothing
        for ( File f : list ) 
        {
            if ( f.isDirectory() ) 
            {
                FindFile( f.getAbsolutePath(), regex );
                //System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else 
            {
                //System.out.println( "File:" + f.getAbsoluteFile() );
            }
        }
	}
	
	
	public static void main(String[] args) {
		RecursiveFileSearch ff = new RecursiveFileSearch();
		
		
		
		char ans='y';
		while(ans=='y' || ans=='Y')
		{
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter regex: ");
			String regex = scanner.nextLine();
			
			System.out.println("Enter path: ");
			String path = scanner.nextLine();
			
			/*
			// Example for input
			String regex = "^[p].*";
			String path = "/home/zemoso/Downloads";
			*/
			
			System.out.println("\nOutput:");
	        ff.FindFile(path,regex);
	        
	        System.out.println("\n\nDo you want to repeat (y/n): ");
	        ans = scanner.nextLine().charAt(0);        
		}

    }
}


// Sample Output:
/*
Enter regex: 
^[p].*
Enter path: 
/home/zemoso/Downloads

Output:
Directory :/home/zemoso/Downloads/others/ML/pdf Lectures
Directory :/home/zemoso/Downloads/eclipse-installer/p2
Directory :/home/zemoso/Downloads/eclipse-installer/plugins
File :/home/zemoso/Downloads/eclipse-installer/p2/profiles.info
File :/home/zemoso/Downloads/eclipse-installer/p2/pools.info
Directory :/home/zemoso/Downloads/eclipse-installer/p2/org.eclipse.equinox.p2.engine/profileRegistry
File :/home/zemoso/Downloads/eclipse-installer/plugins/org.eclipse.platform_4.7.0.v20170612-0950/plugin_customization.properties
File :/home/zemoso/Downloads/eclipse-installer/plugins/org.eclipse.platform_4.7.0.v20170612-0950/platform.jar
File :/home/zemoso/Downloads/eclipse-installer/plugins/org.eclipse.platform_4.7.0.v20170612-0950/plugin.xml
File :/home/zemoso/Downloads/eclipse-installer/plugins/org.eclipse.platform_4.7.0.v20170612-0950/plugin_customization.ini
File :/home/zemoso/Downloads/eclipse-installer/plugins/org.eclipse.platform_4.7.0.v20170612-0950/plugin.properties
File :/home/zemoso/Downloads/eclipse-installer/features/org.eclipse.ecf.core.ssl.feature_1.1.0.v20170110-1317/META-INF/maven/org.eclipse.ecf/org.eclipse.ecf.core.ssl.feature/pom.properties
File :/home/zemoso/Downloads/eclipse-installer/features/org.eclipse.ecf.core.ssl.feature_1.1.0.v20170110-1317/META-INF/maven/org.eclipse.ecf/org.eclipse.ecf.core.ssl.feature/pom.xml
File :/home/zemoso/Downloads/eclipse-installer/features/org.eclipse.ecf.filetransfer.ssl.feature_1.1.0.v20170110-1317/META-INF/maven/org.eclipse.ecf/org.eclipse.ecf.filetransfer.ssl.feature/pom.properties
File :/home/zemoso/Downloads/eclipse-installer/features/org.eclipse.ecf.filetransfer.ssl.feature_1.1.0.v20170110-1317/META-INF/maven/org.eclipse.ecf/org.eclipse.ecf.filetransfer.ssl.feature/pom.xml
File :/home/zemoso/Downloads/eclipse-installer/features/org.eclipse.ecf.filetransfer.httpclient4.ssl.feature_1.1.0.v20170110-1317/META-INF/maven/org.eclipse.ecf/org.eclipse.ecf.filetransfer.httpclient4.ssl.feature/pom.properties
File :/home/zemoso/Downloads/eclipse-installer/features/org.eclipse.ecf.filetransfer.httpclient4.ssl.feature_1.1.0.v20170110-1317/META-INF/maven/org.eclipse.ecf/org.eclipse.ecf.filetransfer.httpclient4.ssl.feature/pom.xml
File :/home/zemoso/Downloads/eclipse-installer/configuration/org.eclipse.update/platform.xml
File :/home/zemoso/Downloads/eclipse-installer/configuration/org.eclipse.osgi/130/0/.cp/icons/simple/progress_sprite.png
Do you want to more (y/n): 
y
Enter regex: 
^[d].*
Enter path: 
/home/zemoso/Downloads

Output:
Directory :/home/zemoso/Downloads/eclipse-installer/p2/org.eclipse.equinox.p2.repository/cache/downloading
File :/home/zemoso/Downloads/eclipse-installer/plugins/org.eclipse.platform_4.7.0.v20170612-0950/disabled_book.css
File :/home/zemoso/Downloads/eclipse-installer/plugins/org.eclipse.platform_4.7.0.v20170612-0950/images/dragHandle.png
File :/home/zemoso/Downloads/eclipse-installer/configuration/.metadata/.plugins/org.eclipse.oomph.setup.ui/dialog_settings.xml
Directory :/home/zemoso/Downloads/eclipse-installer/configuration/org.eclipse.osgi/100/data
File :/home/zemoso/Downloads/eclipse-installer/configuration/org.eclipse.osgi/130/0/.cp/icons/simple/delete.png
Do you want to more (y/n): 
n

*/



// Reference
// https://stackoverflow.com/questions/2056221/recursively-list-files-in-java


