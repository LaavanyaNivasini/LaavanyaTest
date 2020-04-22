package week3.day1.classroom;

import java.util.ArrayList;
import java.util.LinkedHashSet;
//import java.util.List;
import java.util.Set;
//import java.util.TreeSet;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "Paypal India";
		char[] charArray = str.toCharArray();
		Set<Character> charSet=new LinkedHashSet<Character>();	
		Set<Character> dupeCharSet=new LinkedHashSet<Character>();
		for (int i = 0; i < charArray.length; i++)
		{
		//	charSet.add(charArray[i]);
			if (charArray[i] != ' ')
			{
				if (charSet.add(charArray[i])== false)  //the process of adding every char to charSet is done here and also the condition for duplicate is checked
				{
					dupeCharSet.add(charArray[i]);
				}
				
			}
			 
		}
		System.out.println(charSet);
		System.out.println(dupeCharSet);
		}
	}


