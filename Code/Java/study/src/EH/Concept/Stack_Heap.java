package EH.Concept;

public class Stack_Heap {

	public static void main(String[] args) {
		Integer a = 10;
		System.out.println(a);
		changeInteger(a);
		System.out.println(a);
		String b = "Hello";		
		changeString(b);
		System.out.println(b);				
	}
	
	static void changeString(String param) {
		param += "World";
	}
	
	static void changeInteger(Integer param) {
		param += 10;
	}
}
