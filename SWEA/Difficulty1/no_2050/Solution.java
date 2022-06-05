package no_2050;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		for(int i=0; i<s.length(); i++) {
			int num = (int)s.charAt(i);
			System.out.println(num);
			System.out.format("%d ",num-64);
		}
	}
}
