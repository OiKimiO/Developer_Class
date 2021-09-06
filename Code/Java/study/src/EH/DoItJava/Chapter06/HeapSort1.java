package EH.DoItJava.Chapter06;

import java.io.IOException;

import EH.DoItJava.common.Common;

public class HeapSort1 {

	static Common c = new Common();
	static int[] arr;
	static int length = 0;
	
	public static void main(String[] args) throws IOException {	
		arr = c.sortWrite(arr);
		length = arr.length;
		heapSort();
	}

	private static void heapSort() {
		int arrLastIdx = length - 1;
		
		// 힙정렬을 합니다. 배열 중 루트 값을 가장 크게 하고, 그 이하의 자식 노드 값을 작게 만듭니다.
		for(int rootIdx = arrLastIdx / 2; rootIdx >= 0; rootIdx--) downHeap(rootIdx,length - 1);
		
		// 힙정렬한 배열을 토대로 배열의 순서를 정합니다.
		for(int i = arrLastIdx; i >= 0; i--) {
			c.swap(arr, 0, i); // 최상위 루트 노드는 가장 큰값임으로 그 값과 마지막 값을 교환합니다.
			downHeap(0,i-1);   // 최상위 루트에 가장 큰 값이 오도록 배열을 수정합니다.
		}
		c.titleArrPrint("결과 ::: ", arr);
	}

	private static void downHeap(int leftIdx, int rightIdx) {
		int rootValue = arr[leftIdx]; // 루트 노드이 값입니다.
		int parentIdx, childIdx;	  // 부모 노드의 인덱스와 자식 노드의 인덱스입니다.
		
		// 현재 루트 노드를 기준으로 마지막 자식 노드에 도달할 수 있는 반복 횟수 입니다. 
		for(parentIdx = leftIdx; parentIdx < (rightIdx+1) / 2; parentIdx = childIdx) {
			int childLeftIdx  = parentIdx * 2 + 1; // 부모 노드를 기준으로 왼쪽 자식 노드의 인덱스를 구합니다.
			int childRightIdx = childLeftIdx + 1;  // 부모 노드를 기준으로 오른쪽 자식 노드의 인덱스를 구합니다.
			
			// 오른쪽 자식 노드가 배열의 마지막 노드를 넘지 않으면서, 두 자식 노드들의 값중 가장 높은 값의 인덱스를 childIdx로 추가합니다.
			childIdx = (childRightIdx <= rightIdx && arr[childLeftIdx] < arr[childRightIdx]) ? childRightIdx : childLeftIdx;
			
			// 자식 인덱스의 값이 루트 값보다 작을 경우 downHeap 메서드를 중지합니다.
			if(rootValue >= arr[childIdx]) break;
			
			// 부모 값에 자식 값을 넣습니다.
			arr[parentIdx] = arr[childIdx];
		}
		arr[parentIdx] = rootValue;		
	}
	
	
}
