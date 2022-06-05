package no_2025;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int res = 0;
		
		for(int i=1; i<=n; i++) {
			res += i;
		}
		System.out.println(res);
	}

}

//1부터 주어진 숫자만큼 모두 더한 값을 출력하시오.
/* 메모리 2000kb 더 적음, 20ms 더 빠른 코드
import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int n = Integer.parseInt(br.readLine());
        int sum =0;
        for(int i = 1; i <= n; i++) {
            sum += i;
            if(i == n){
                 
            System.out.println(sum);
            }
        }
    }
*/