package week1.day2.classroom;
import java.util.Arrays;
public class FindSecondLargest {

	public static void main(String[] args)
	{
		int[] data= {3,2,11,4,6,7};
		/*int[] sortedData;*/
		Arrays.sort(data);
		
		System.out.println("Sorted Array is:");
		for (int i= 0; i< data.length; i++) {
			System.out.println(data[i]);
		}
		System.out.println("First largest is:\t"+data[data.length-1]);
		System.out.println("second largest is:\t"+data[data.length-2]);

	}

}
