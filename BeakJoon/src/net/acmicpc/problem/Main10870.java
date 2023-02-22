package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 피보나치수
public class Main10870 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄에 n이 주어진다.
		int n = Integer.parseInt(br.readLine());
		
		/*int[] sum = new int[n + 1];
		sum[0] = 0;
		sum[1] = 1;
		for ( int i = 2; i < sum.length; i++ ) {
			sum[i] = sum[i - 1] + sum[i - 2];
		}
		System.out.println(sum[n]);*/
		
		System.out.println(fibonacci(n));
	}
	
	public static int fibonacci(int n) {
		
		if ( n == 0 ) {
			return 0;
		} else if ( n == 1 ) {
			return 1;
		}
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
