package week1.day1.classroom;

public class FibonacciSeries {

	public static void main(String[] args) {
		int range=8,firstNum=0,secNum=1;
		
		/*for (int i = 0; i <= range; i++) {
			firstNum=i;
			System.out.println("firstNum:" + firstNum)
		for (int j = 1; j < 8; j++) {
			
			secNum=firstNum+j;
			firstNum=secNum
		}	*/
			
		System.out.println(firstNum);
		System.out.println(secNum);
		for (int i = 1; i < range; i++) {
			int sum;
			sum=firstNum+secNum;
			System.out.println("sum is:\t"+sum);
			firstNum=secNum;
			secNum=sum;
			/*System.out.println("New secnum is:\t"+secNum);*/
		}
	}

}
