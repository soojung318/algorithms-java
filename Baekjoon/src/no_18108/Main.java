package no_18108;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int b = scanner.nextInt();
		int result = 0;
		if(b>=1000 && b<=3000) {
			result = b - 543;
		}
		System.out.println(result);
	}

}
