package week3.day1.classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		String[] str = {"HCL", "Wipro",  "Aspire Systems", "CTS"};
		int length = str.length;
		List<String> companies= new ArrayList<String>();
		for (int i = 0; i < length; i++)
		{
			companies.add(str[i]);
			
		}
		
		Collections.sort(companies);
		System.out.println("Before reversing:" +companies);
		
		for (int j = companies.size()-1; j >= 0 ; j--) 
		//for (int i = str.length-1; i >=0; i--)
		{  //not working from here check y
			System.out.println(companies.get(j));
		
	}

}}
