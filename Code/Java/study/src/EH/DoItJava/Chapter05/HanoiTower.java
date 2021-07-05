package EH.DoItJava.Chapter05;

import java.util.*;
public class HanoiTower {
	static int N, cnt;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		move(N,1,3);
		System.out.println(cnt);
	}
	
	public static void move(int no, int x, int y) {
		if(no > 1) move(no-1,x,6-x-y);
		System.out.println("원반["+no+"]은 " + x + "기둥에서 " + y + "기둥으로 이동했습니다.");
		cnt++;
		if(no > 1) move(no-1,6-x-y,y);
	}
}