package week4.day1;

import java.util.LinkedHashMap;
import java.util.Map;

public class LearnMap2 {

	public static void main(String[] args) {
		String str ="please focusf";
		char[] charArray = str.toCharArray();
		char ch = 'e';
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		for (char c : charArray)
		{
			if(c==ch)
			{
				if(map.containsKey(c)) 
				{
				Integer val = map.get(c);
				map.put(c, val+1);
				}
				else
				map.put(c, 1);
			}
				
		}
		System.out.println(map);
	}

}
