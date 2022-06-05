package no_1959;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int T =sc.nextInt();
		 for(int t=1; t<=T; t++) {
		     int N = sc.nextInt();
		     int M = sc.nextInt();
		      
		     int[] a = new int[N];
		     int[] b= new int[M];
		      
		     for(int i=0; i<N; i++) {
		     a[i] = sc.nextInt();
		     }
		                  
		     for(int j =0; j<M; j++) {
		     b[j] = sc.nextInt();
		     }
		      
		     int max = 0;
		     for(int i=0; i<M-N+1; i++) {
		     int sum =0;
		         for(int j=0; j<N; j++) {
		         sum += a[j] * b[j+i];
		         }
		         if(sum > max)
		             max = sum;
		     }
		      
		      for(int i=0; i<N-M+1; i++) {
		     int sum =0;
		         for(int j=0; j<M; j++) {
		         sum += a[j+i] * b[j];
		         }
		         if(sum > max)
		             max = sum;
		     }
		     System.out.println("#" + t + " " + max);
		         }

	}

}
