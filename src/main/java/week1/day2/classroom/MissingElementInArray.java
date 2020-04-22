package week1.day2.classroom;
import java.util.Arrays;


public class MissingElementInArray {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		for (int i = arr[0]; i < arr.length; i++) {
			if(i != arr[i-arr[0]]) {
				System.out.println(i);
			break;
		/*for (int i = 0; i < arr.length; i++) {
			
			if((arr[(i+1)]-arr[i]) != 1) {
				System.out.println(i);
			break;
		}*/
				}
		}
	}

}
