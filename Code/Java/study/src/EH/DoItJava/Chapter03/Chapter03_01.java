package EH.DoItJava.Chapter03;

import java.util.*;
class Chapter03_01 {
	static class CompareT{
		
		private int num = 0;
		
		public CompareT(int num){this.num = num;}
		
		public String toString() {
			return String.valueOf(num);
		}
		
		static final Comparator<CompareT> COMPARATOR = new numOrder();
		
		// Comparator<? super ComparT> <-- 3번째 인자 
		static class numOrder implements Comparator<CompareT>{
			public int compare(CompareT d1, CompareT d2) {
				return (d1.num > d2.num) ? 1 : 
					 (d1.num < d2.num) ? - 1 : 0;
			}
		}
	}

	public static void main(String[] args) {
		CompareT[] x = { new CompareT(2)
				 		,new CompareT(6)
				 		,new CompareT(12)
				 		,new CompareT(15)
				 		,new CompareT(18)};
		int idx = Arrays.binarySearch(x, new CompareT(15), CompareT.COMPARATOR);
		if(idx < 0) System.out.println("없음");
		else System.out.println(x[idx]);
		
	}
}
