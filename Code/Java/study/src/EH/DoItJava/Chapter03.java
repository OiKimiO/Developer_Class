package EH.DoItJava;

import java.io.*;
import java.util.*;
public class Chapter03 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String str = br.readLine();
		int[] a = new int[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			a[i] = str.charAt(i) - '0';
		}
		
		// printSeqSearch(a,4);
		// searchIdx(a,9);
		binarySearch(a,4,0,a.length);
	}
	
	static void searchIdx(int[] a, int key) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < a.length; i++) {
			if(a[i] == key) list.add(i);
		}
		System.out.println(list.size());
	}
	
	static void binarySearch(int[] a, int key, int start, int end) {		
		while(true) {
			int mid = (start + end) / 2;
			if(key == mid) {
				System.out.println(mid);
				break;
			}
			if(mid > key){				
				binarySearch(a,key,start,mid - 1);				
			}else if(mid < key){				
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
