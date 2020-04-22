package week1.day2.classroom;

public class ReverseString {

	public static void main(String[] args) {
		String test= "feeling good";
		int len=test.length();
		for (int i = len-1; i >= 0; i--) 
		{
			System.out.println(test.charAt(i));
		} 
			
		}

	}


