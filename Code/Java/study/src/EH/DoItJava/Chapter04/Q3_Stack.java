package EH.DoItJava.Chapter04;

public class Q3_Stack {
	public int max;
	public int ptr1;
	public int ptr2;
	public int[] stk;
	
	// 스택이 넘쳐날 경우 발생하는 예외
	public class OverflowStackException extends RuntimeException{
		public OverflowStackException(){
			System.out.println("넘쳐난다!");
		}
	}
	
	// 스택이 비었을 경우 발생하는 예외
	public class EmptyStackException extends RuntimeException{
		public EmptyStackException(){
			System.out.println("아무것도 없다!");
		}
	}
	
	public void ptr1Push(int x) {
		if(ptr1 >= (max/2)) new OverflowStackException();
		else stk[ptr1++] = x;		
	}
	
	public void ptr2Push(int x) {				
		if((max/2) > ptr2 || max < ptr2) new OverflowStackException();
		else stk[ptr2--] = x;
	}
	
	public int ptr1Pop() {
		if(ptr1 <= 0) new EmptyStackException();
		return stk[ptr1--];
	}
	
	public int ptr2Pop() {
		if(ptr2 >= max) new EmptyStackException();
		return stk[ptr2++];
	}
	
	public void print() {
		for(int num : stk) System.out.print(num + " ");
	}
	
	// 스택을 생성합니다.
	public Q3_Stack(int capacity) {
		max = capacity;		
		try {
			stk = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}		
		ptr1 = 0;
		ptr2 = max-1;
	}
	
	public static void main(String[] args) {
		Q3_Stack stk = new Q3_Stack(6);
		stk.ptr1Push(1); 
		stk.ptr1Push(2); 
		stk.ptr1Push(3); 
		stk.ptr2Push(4); 
		stk.ptr2Push(5); 
		stk.ptr2Push(6);
		stk.print();
	}
	
}
