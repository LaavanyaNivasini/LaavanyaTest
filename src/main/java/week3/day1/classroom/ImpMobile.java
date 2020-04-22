package week3.day1.classroom;

public class ImpMobile implements Mobile {


	@Override
	public void searchContacts(String name) {
		System.out.println(name);
		
	}

	@Override
	public void dial(long num) {
		System.out.println(num);
		
	}

	@Override
	public void speak() {
		System.out.println("speaking to the dailledperson");
		
	}

	@Override
	public void hangup() {
		System.out.println("Hang the call");
		
	}
	public void dummy() {
		System.out.println("This is to check hidden method usage");

}
}
