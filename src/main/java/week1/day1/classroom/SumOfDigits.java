package week1.day1.classroom;

public class SumOfDigits {

	public static void main(String[] args) {
		int num = 12345;
		int sum=0;
		int r;
	while(num>0)
	{		r= num%10;
		System.out.println("Reminder is:" +r);
		sum = sum+r;
		System.out.println("New sum is:" +sum);
		num= num/10;
		System.out.println("New num is:"+num);
			
	}	
		System.out.println("Final sum is the given numbers:"+sum);
	}

}
