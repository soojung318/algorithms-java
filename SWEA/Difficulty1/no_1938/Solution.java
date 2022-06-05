package no_1938;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
	}

}
//두 개의 자연수를 입력받아 사칙연산을 수행하는 프로그램을 작성하라.



//[제약 사항]

//1. 두 개의 자연수 a, b는 1부터 9까지의 자연수이다. (1 ≤ a, b ≤ 9)

//2. 사칙연산 + , - , * , / 순서로 연산한 결과를 출력한다.

//3. 나누기 연산의 결과에서 소수점 이하의 숫자는 버린다.