package week1.day2.classroom;

public class FindTypes {

	public static void main(String[] args) {
		String str = "$$ Welcome to 2nd Class of Automation $$ ";
		int  letter = 0, space = 0, num = 0, specialChar = 0;
		
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) //since every condition is chckd  individual blocks use elseif to check other conditions
		{
			if (Character.isLetter(arr[i])) {
				letter=letter+1;
			}
			else if (Character.isDigit(arr[i])) {
				num=num+1;
			}
			else if (Character.isSpaceChar(arr[i])) {
				space=space+1;
			}
			
			else {
				specialChar=specialChar+1;
			}
		}

		System.out.println("letter: " + letter);
		System.out.println("space: " + space);
		System.out.println("number: " + num);
		System.out.println("specialCharcter: " + specialChar);
		
		

	}

}
