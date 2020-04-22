package week1.day2.classroom;
import java.util.*;
public class PrintDuplicatesInArray {

	public static void main(String[] args) {
		int[] arr= {14,12,13,11,15,14,18,16,17,19,18,17,20};
		Arrays.sort(arr);
		for (int elmnt : arr) {
			System.out.println(elmnt);
		}
		//int len=arr.length;
		//int count;
		/*for (int i = 0; i < arr.length-1; i++)
		{
		  count=0;
			for (int j = i; j < arr.length; j++) 
			 {
				if (arr[j]==arr[i])
				{
					count=count+1;
					
				}
				while(count>0)
				{
				System.out.println(arr[i]);
			    }
			
		     } */
      for (int i = 0; i < arr.length-1; i++) {
		if (arr[i]==arr[i+1]) {
			System.out.println("duplicates are:" +arr[i]);
		}
	}
	}

  }

