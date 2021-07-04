package EH.DoItJava.Chapter03;

import java.io.*;
import java.util.*;

class Id{
	private static int counter = 0; // 아이디를 몇개 부여했는지 저장
	private int id;
	private int counter2 = 0;

	// 생성자
	public Id(){ 
		id = ++counter;
		++counter2;
	}

	// 아이디를 반환하는 인스턴스 메서드
	public int getId() {return id;}

	// counter를 반환하는 클래스 메서드 
	public static int getCounter(){return counter;}	
	public int getCounter2(){return counter2;}	
}

public class Chapter03{
	public static void main(String[] args) throws IOException {
		Id c = new Id();
		Id d = new Id();
		System.out.println(c.getCounter());
		System.out.println(d.getCounter2()); 
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String str = br.readLine();
		int[] a = new int[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			a[i] = str.charAt(i) - '0';
		}
		
		binarySearchX(a,10,0,a.length - 1);
	}
	
	static void searchIdx(int[] a, int key) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < a.length; i++) {
			if(a[i] == key) list.add(i);
		}
		System.out.println(list.size());
	}
	
	static void binarySearchX(int[] a, int key, int start, int end) {			
		if(start > end) {
			System.out.println("삽입포인터는 " + start + "입니다.");
			// System.out.println("찾고자 하는 데이터가 없습니다!");
			return;
		}
		int mid = (start + end) / 2;		
		if(a[mid] == key) {
			inner : for(int i = mid; i > 0; i--) {
				if(a[i] == 0) break inner;
				if(a[i] == a[i-1]) {
					mid = i-1;
				}else {
					break inner;
				}
			}
			System.out.println("찾고자 하는 값은  ::: a[" + mid + "]에 있습니다.");
			return;
		}
		if(a[mid] > key) end = mid - 1;
		else if(a[mid] < key) start = mid + 1;
		binarySearchX(a,key,start,end);
		return;
	}
	
	static void binarySearch(int[] a, int key, int start, int end) {		
		while(true) {
			int mid = (start + end) / 2;
			if(key == a[mid]) {
				System.out.println(mid);
				break;
			}
			if(a[mid] > key){
				binarySearch(a,key,start,mid - 1);				
			}else if(a[mid] < key){				
				binarySearch(a,key,mid + 1,end);
			}
			break;
		}
	}
	
	static void printSeqSearch(int[] a, int searchValue) {		
		for(int i = 0; i < a.length; i++) {
			String blank = "  | ";
			for(int j = 1; j <= i; j++) {
				blank += "  ";
			}
			System.out.println(blank+"*");
			System.out.println(arrPrint(a, i));
			
			if(a[i] == 4) {
				System.out.println("찾고자 하는 값은 " + (i + 1) + "번째에 있습니다.");
				break;
			}
		}
	}
	
	static String arrPrint(int[] a, int idx) {
		String print = idx + " | ";
		for(int num : a) print += num + " ";
		return print;
	}
	
	
	static void seqSearchSen(int[] a, int searchValue) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == 4) System.out.println("찾고자 하는 값은 " + (i + 1) + "번째에 있습니다.");
		}
	}
}
