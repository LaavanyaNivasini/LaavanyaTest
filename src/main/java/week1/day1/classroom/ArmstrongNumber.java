package week1.day1.classroom;

public class ArmstrongNumber {
	public static void main(String[] args) {
		int input=1533;
		int calculated=0,reminder,original;
		original=input;
		while (input>0) {
		
			reminder= input%10;
			calculated=calculated+(reminder*reminder*reminder);
			input=input/10;
		}
		System.out.println("Finalresult:"+calculated);
		if (calculated == original) {
			System.out.println(calculated + "is an armstrong number");
		}
			
		else {
				System.out.println(calculated+ "is not an armstrong");
			}	
		
	}

}
