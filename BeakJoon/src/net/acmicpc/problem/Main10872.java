package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10872 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans = factorial(N);
		
		System.out.println(ans);
	}
	
	public static int factorial(int n) {
		
		if ( n <= 1 ) {
			return 1;
		}
		
		return n * factorial(n - 1);
	}
}
