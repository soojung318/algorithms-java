package no_2063;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num[] = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);	//배열을 오름차순으로 정렬
		System.out.println(num[(n-1)/2]);
	}

}
