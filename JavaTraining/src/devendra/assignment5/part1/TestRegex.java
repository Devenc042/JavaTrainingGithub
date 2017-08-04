package devendra.assignment5.part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	public static final String inputStr = "S.s djfk kf*F*&^& \n \t	q"
			+ "ddfd"
			+ "dfdf"
			+ "343"
			+ "674 &6~!@ ---<.,..//d..";

	public static void main(String[] args) {
		
		String RegexPattern = "^[A-Z][\\p{ASCII}]*[\\.]$";
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

[\\p{ASCII}]* - Character Class: Matches All ASCII:[\x00-\x7F]

[\\.] - Character Class: Matches a single letter of period

$ - Matches the end of the string

*/


//Reference
// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
// http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
// https://social.msdn.microsoft.com/Forums/expression/en-US/e03303a4-7277-4d39-a154-09b4c8a93d76/regular-expression-testing-for-capital-letter-sentence-start?forum=web

