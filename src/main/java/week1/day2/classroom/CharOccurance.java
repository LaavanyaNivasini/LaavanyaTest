package week1.day2.classroom;

public class CharOccurance {

	public static void main(String[] args) {
		String str= "welcome to chennai";
		int count=0;
		char[]  charArr=str.toCharArray();
		/*for (char c : charArr) {
			System.out.println(c);
		}
		//int len=charArr.length;
		 */
	for (int i = 0; i < charArr.length; i++) {
			//if (str.charAt(i).equals(str.charAt(1))) {
			if (charArr[i]=='c')
			{
	
				count=count+1;
			}
		 
		}

	 System.out.println(count);	
	}

}
