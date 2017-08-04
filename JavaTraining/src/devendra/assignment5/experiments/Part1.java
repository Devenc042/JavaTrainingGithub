package devendra.assignment5.experiments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
	
	public static final String inputStr = "HeyHe is.";

	public static void main(String[] args) {
		
		String RegexPattern = "^[A-Z][^\\.]*(\\.+)$";
		Pattern pattern = Pattern.compile(RegexPattern);
		Matcher matcher = pattern.matcher(inputStr);
		
		if(matcher.find()) System.out.println("Found");
		else System.out.println("Not Found");
		
	}
}

/*

Explanation:

^ - Matches the beginning of the string.

[A-Z] - Character class: Matches a single capital letter

[^\.]* - Character Class: Matches any character that is NOT a period. Zero or more.

(\\.+) - Group: one or more dots 

$ - Matches the end of the string

*/


//Reference
// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
// http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
// https://social.msdn.microsoft.com/Forums/expression/en-US/e03303a4-7277-4d39-a154-09b4c8a93d76/regular-expression-testing-for-capital-letter-sentence-start?forum=web








