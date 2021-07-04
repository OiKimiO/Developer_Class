package EH.DoItJava.Chapter04;

// 링버퍼-큐를 구현함
public class Queue{
	private int max, front, rear, num;
	private int[] queue; 
	
	// 데이터를 초과 입력!
	public class OverflowQueueException extends RuntimeException{
		public OverflowQueueException(){}
	}
	
	// 데이터가 비었음!
	public class EmptyQueueException extends RuntimeException{
		public EmptyQueueException(){}
	}
	
	// 큐에 데이터를 넣는다.
	public void Enque(int x) throws OverflowQueueException {
		if(num >= max) throw new OverflowQueueException(); // 큐가 가득차면 예외 처리 
		queue[rear++] = x;
		num++;
		if(rear == max) rear = 0;
		
	}
	
	// 큐에 데이터를 뺀다.
	public int Dequeue() throws EmptyQueueException{
		if(num <= 0) throw new EmptyQueueException();
		int Num = queue[front++];
		num--;
		if(front == max) front = 0;
		return Num;
	}
	
	// 큐에서 데이터에 해당하는 인덱스를 찾는다.
	public int indexOf(int x) {
		int idx = 0;
		for(int i = 0; i < num; i++)
			idx = (i + front) % max; // 큐 배열에서 찾고자 하는 숫자의 인덱스를 알아야 함으로 front인덱스가 max값을 넘기지 않도록 만듦
			if(queue[idx] == x) return idx;		
		return -1;
	}
	
	// 큐 생성자
	public Queue(int capacity){
		front = rear = num = 0;
		max = capacity;
		try {
			queue = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
