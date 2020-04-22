package week3.day1.classroom;

import java.util.ArrayList;
import java.util.List;

public class LearnList {

	public static void main(String[] args) {
	List<String> names = new ArrayList<String>();
	names.add("Laavanya");
	names.add("Sharath");
	names.add("Preethi");
	names.add("Srinathan");
	names.add("Gayathri");
	names.add("shruthi");
	
	/*for (String name : names) {
		System.out.println(name);
	*/
	for (int i = 0; i < names.size(); i++) {
	
	if (names.get(i).startsWith("S") || names.get(i).startsWith("s")) {
		names.remove(i);
	}
	
	}
	names.add("Vinoth");
	System.out.print(names);
	}

}
