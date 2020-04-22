package week1.Assignments;

public class Palindrome {

	public static void main(String[] args) {
		String str= "madam";
		String rev= "";
	//	char[] charArray = str.toCharArray();
		for (int i = str.length()-1; i >= 0; i--) {
			rev=rev + str.charAt(i);
		}
		System.out.println("reverse of he given string is: \t" + rev);
		if (str.equals(rev)) {
			System.out.println("Given string\t" + str + "\tis a palindrome");
		}
		else {
			System.out.println("Given string is not a palindrome");
		}

	}

}
