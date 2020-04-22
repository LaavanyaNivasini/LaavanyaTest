package week1.day1.classroom;

public class PrimeNumber {

	public static void main(String[] args) {
		int input=15;
		boolean flag=false;
		for (int i =2; i < input/2 ; i++) {
		//	int rem;
		//	rem= input%i;
			/*if(rem==0) {
				flag=true;
				break;
			}
			if(flag==true) {
				System.out.println(input+ "is a not a prime");
			}
			else {
				System.out.println(input+"is a prime");
			}*/
		for (int j = 2; j <= input/2; j++) {
			if (input%j == 0) {
				System.out.println(input+ "\t is not a prime number");
				flag=true;
				break;        //why do we need this break here 
				}
		}
			if (flag==false)   //why the flag is neccessary? and why not else condition
			{
				System.out.println(input+"\t is a prime number");
			}
				
			
		
		
		}
	}

}
