package no_2072;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int n;
		int sum = 0;
		
		for(int j=0; j<3; j++) {
			for(int i=0; i<10; i++) {
				n = scanner.nextInt();
				sum += n;
			}
			
		}
		for(int i=0; i<t; i++) {
			System.out.println("#"+i+" "+sum);			
		}
		
	}

}

//10개의 수를 입력 받아, 그 중에서 홀수만 더한 값을 출력하는 프로그램을 작성하라.