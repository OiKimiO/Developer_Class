package EH.DoItJava.Chapter06;

import java.io.*;
import EH.DoItJava.common.Common;

public class MergeSort {
	static Common c   = new Common();
	static int[] a;
	static int length;
	static int[] buff;
	
	// 테스트  : 7 22 5 11 32 120 68 70
	public static void main(String[] args) throws IOException {		
		c.sortWrite(a);	
		mergeSort();
		c.arrPrint(a);
	}
	
	public static void mergeSort() {
		buff = new int[length];
		__mergeSort(0,length-1,"main");
		buff = null;
	}
	
	public static void __mergeSort(int left, int right, String section) {
		if(left < right) {
			int aRightIdx;  	   // 현재 메서드의 실제 배열의 오른쪽 인덱스
			int center 	   = (left + right) / 2;
			int buffLength = 0;    // 현재 메서드의 임시배열 왼쪽 전체 길이 
			int buffIdx    = 0;    // 현재 메서드의 임시배열 왼쪽 시작 인덱스 
			int sortIdx    = left; // 현재 메서드의 실제 배열 정렬 시작 인덱스
			
			// 메서드 실행 순서 : 맨 아래쪽 왼쪽 -> 오른쪽 -> 위 이동
			__mergeSort(left,center,"left");	 // 배열의 앞부분을 병합정렬합니다.
			__mergeSort(center+1,right,"right"); // 배열의 뒷부분을 병합정렬합니다.
			
			System.out.println("실행 되는 구간 : " + section);
			System.out.printf("실행 구간의 범위 sortIdx = left : %d , center : %d, right : %d \n", left, center, right);
			
			// i는 left 시작점 
			for(aRightIdx = left; aRightIdx <= center; aRightIdx++) {
				buff[buffLength++] = a[aRightIdx];
				System.out.printf("1번째 for aRightIdx 의 값 : %d, buffLength 의 값 : %d \n", aRightIdx , buffLength);
			}
			
			// 임시 배열에 저장된 왼쪽 배열과 사용되는 오른쪽 배열을 비교한다. 
			while(aRightIdx <= right && buffIdx < buffLength) {
				System.out.printf("2번째 while의 buffIdx 의 값 : %d , aRightIdx 의 값 : %d \n" ,buffIdx,aRightIdx);
				a[sortIdx++] = (buff[buffIdx] <= a[aRightIdx]) ? buff[buffIdx++] : a[aRightIdx++];
			}
			
			// 임시 배열의 전체 길이보다 임시배열의 인덱스가 작다면 아래를 실행
			while(buffIdx < buffLength) {
				System.out.printf("3번째 while의 sortIdx 의 값 : %d , buffIdx 의 값 : %d \n\n" ,sortIdx,buffIdx);
				a[sortIdx++] = buff[buffIdx++];
			}
			
		}
	}
}
