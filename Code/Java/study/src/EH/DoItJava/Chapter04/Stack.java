package EH.DoItJava.Chapter04;

public class Stack {
	private int max; 	// 스택 용량
	private int ptr; 	// 스택 포인터
	private int[] stk;	// 스택 본체
	
	// 실행 시 예외 : 스택이 비어 있음
	public class EmptyStackException extends RuntimeException{
		public EmptyStackException(){}
	}
	
	// 실행 시 예외 : 스택이 가득참
	public class OverflowStackException extends RuntimeException{
		public OverflowStackException(){}
	}
	
	// 스택에 x를 푸시
	public int push(int x) throws OverflowStackException{
		// 스택에 x를 푸시
		if(ptr >= max) throw new OverflowStackException();
		return stk[ptr++] = x;
	}
	
	// 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
	public int pop() throws EmptyStackException{
		if(ptr <= 0) throw new EmptyStackException();
		return stk[--ptr];
	}
	
	// 스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
	public int peek() throws EmptyStackException{
		if(ptr <= 0) throw new EmptyStackException();
		return stk[ptr-1];
	}
	
	// 스택에서 x를 찾아 인덱스(없으면 -1)을 반환
	public int indexOf(int x) {
		for(int i = ptr - 1; i>=0;i--) // 정상쪽에서 선형검색
			if(stk[i] == x) return i; // 검색성공		
		return -1; // 검색실패
	}
	
	// 스택을 비움
	public void clear() {
		ptr = 0;
	}
	
	// 스택의 용량을 반환
	public int capacity() {
		return max;
	}
	
	// 스택에 쌓여 있는 데이터 수를 반환
	public int size() {
		return ptr;
	}
	
	// 스택이 비어 있는가?
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	// 스택에 가득 찼는가?
	public boolean isFull() {
		return ptr >= max;
	}
	
	public void dump() {
		if(ptr <= 0) System.out.println("스택이 비어 있습니다.");
		else {
			for(int num : stk) System.out.println(num +" ");
		}
	}
	
	// 생성자 호출시 Stack을 생성한다. 	
	public Stack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];		// 스택 본체용 배열을 생성
		}catch(OutOfMemoryError e){ // 생성할 수 없음
			max = 0;
		}
	}
	
}
