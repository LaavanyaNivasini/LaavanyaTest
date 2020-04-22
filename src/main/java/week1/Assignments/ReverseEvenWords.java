package week1.Assignments;

public class ReverseEvenWords {

	
	//this code is also wrong check and do again
	public static void main(String[] args) 
	{
	      String test="I am a software tester"; 
	      //String[] str= {"I","am","a","software","tester"}; //Tis is manual splittig of the givn sentence and below is using the split() method 
	      String[] split = test.split("\\s");
	      for (int i = 0; i < split.length; i++)
	     {
	    	 // System.out.println(str[i]);
	    	  
	    	  if (i%2 !=0) 
	    	{
				String[] split2 = split[i].split("");
				for (int j = split2.length-1; j >=0 ; j--) 
				{
					
					System.out.println(split2[j]);
				}
			}
			
	    	else {
				System.out.println(split[i]);
			}
		}
	}	
}
		
			
		

	


