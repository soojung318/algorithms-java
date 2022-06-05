package no_2058;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int sum = 0;
		for(int i=0; i<4; i++) {
			int a = n %10;
			n = n/10;
			sum += a;
			System.out.println("a>>"+a);
			System.out.println("n>>"+n);
			System.out.println("sum>>"+sum);
		}
		System.out.println("최종 sum>>"+sum);
	}

}

//하나의 자연수를 입력 받아 각 자릿수의 합을 계산하는 프로그램을 작성하라