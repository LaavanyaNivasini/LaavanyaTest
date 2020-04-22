package week4.day1;

import java.util.LinkedHashMap;
import java.util.Map;

public class LearnMap1 {

	public static void main(String[] args) {
		String str = "please focus first";
		char[] charArray = str.toCharArray();
		Map<Character,Integer> map= new LinkedHashMap<Character,Integer>();
		for (char c : charArray) {
			if(map.containsKey(c))
			{
				Integer value = map.get(c);
				map.put(c, value+1);
			}
			else
			{ if(c!= ' ')
			map.put(c, 1);
			}
		}
		System.out.println(map);

	}

}
