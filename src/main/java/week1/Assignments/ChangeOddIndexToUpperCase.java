package week1.Assignments;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		String str= "changeme";
		char[] arr=str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (i%2 != 0) {
				//str.toUpperCase(arr[i]);
				System.out.println(Character.toUpperCase(str.charAt(i)));
			//	break;
			}
		
		else{
			System.out.println(arr[i]);
		}
 
		}
	}

}
