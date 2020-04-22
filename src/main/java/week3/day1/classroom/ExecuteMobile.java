package week3.day1.classroom;

public class ExecuteMobile {

	public static void main(String[] args) {
		Mobile obj= new ImpMobile();
		//ImpMobile obj= new ImpMobile();
		obj.searchContacts("reethi");
		obj.dial(1234567890);
		obj.speak();
		obj.hangup();
	//	obj.dummy();

	}

}
