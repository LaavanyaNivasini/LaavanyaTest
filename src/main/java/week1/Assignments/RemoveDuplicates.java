package week1.Assignments;

public class RemoveDuplicates {
	private static String replaceAll;

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		int count=0;
		//finish this code later with someone's help
		//System.out.println(text.replaceAll("java", ""));
		String[] split = text.split("\\s");
		for (String string : split) {
			System.out.println(string);
			
		}
		System.out.println(split.length);
		//System.out.println(split[5]);
		for (String string : split) {
			if (string.equals("java")) {
				
				count=count+1;
			}
			
		}
		if (count > 1) {
		String	replaceAll = text.replaceAll("java", "");
			System.out.println(replaceAll);
		}
	}
}
