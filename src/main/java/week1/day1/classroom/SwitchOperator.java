package week1.day1.classroom;

public class SwitchOperator {

	public static void main(String[] args) {
		
		String operations="add";
		int a=6,b=3;
		
		switch (operations) {
		case "add":
			int sum = a+b;
			System.out.println(sum);
			break;
		case "sub":
			int subtr = a-b;
			System.out.println(subtr);
			break;
		case "mul":
			int mult = a*b;
			System.out.println(mult);
			break;
		case "div":
			int divide = a/b;
			System.out.println(divide);
			break;

		default:
			System.out.println("invalid operation");
			break;
		}

	}

}
