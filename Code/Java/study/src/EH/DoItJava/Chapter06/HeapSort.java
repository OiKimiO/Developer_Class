package EH.DoItJava.Chapter06;

import java.io.IOException;
import java.util.ArrayList;

import EH.DoItJava.common.Common;

public class HeapSort {
	static Common c   = new Common();
	static int[] arr;
	static int length = 0;
	
	public static void main(String[] args) throws IOException {	
		arr = c.sortWrite(arr);
		length = arr.length;
		heapSort();
	}
	
	public static void heapSort() {
		// a[i] ~ a[n-1]를 힙으로 만들기
		// downHeap 메서드를 사용하여 배열 a를 힙으로 만듭니다.
		int arrLastIdx = length-1;
		for(int rootIdx = arrLastIdx / 2; rootIdx >= 0; rootIdx--) 
			// c.printfln("rootIdx의 값 ::: %d, root value 의 값 ::: %d", rootIdx, arr[rootIdx]);			
			downHeap(rootIdx,length-1);
			// c.enter();
		
		c.enterPrint(1,"힙정렬 완료",2);
		
		for(int i = arrLastIdx; i >= 0; i--) {
			c.swap(arr, 0, i); // 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환			
			c.titleArrPrint("swap ::: ", arr);			
			downHeap(0,i-1);   // a[0] ~ a[i-1]을 힙으로 만듭니다.
			c.titleArrPrint("downHeap ::: ", arr);			
		}
		
		//c.arrPrint(arr);
		
	}

	private static void downHeap(int leftIdx, int rightIdx) {
		int rootValue = arr[leftIdx];  // 루트 value
		int childIdx;			 	   // 큰 값을 가지는 노드
		int parentIdx;			 	   // 부모 		
		c.printfln("downHeap() >>> ");
		
		// 부모노드가 자식 노드와 변경될 수 있는 횟수
		for(parentIdx = leftIdx; parentIdx < (rightIdx + 1) / 2; parentIdx = childIdx) {
			c.printfln(" leftIdx의 값 ::: %d , rightIdx의 값 ::: %d", leftIdx , rightIdx);
			int childLeftIdx  = parentIdx * 2 + 1; // 왼쪽 자식
			int childRightIdx = childLeftIdx + 1;  // 오른쪽 자식			
			childIdx = (childRightIdx <= rightIdx && arr[childRightIdx] > arr[childLeftIdx]) ? childRightIdx : childLeftIdx; // 자식 노드 중 큰 값을 가진 노드의 인덱스를 자식 인덱스에 넣는다.
			c.printfln("  childLeftIdx의 값 ::: %d , childRightIdx의 값 ::: %d , parentIdx의 값 ::: %d , childIdx의 값 ::: %d", childLeftIdx, childRightIdx, parentIdx , childIdx);
			if(rootValue >= arr[childIdx]) break;
			arr[parentIdx] = arr[childIdx];
			c.titleArrPrint("     ", arr);			
		}
		arr[parentIdx] = rootValue;
		
	}

}
