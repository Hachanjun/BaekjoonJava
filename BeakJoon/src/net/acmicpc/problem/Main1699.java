package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 제곱수의 합 
public class Main1699 {

	public static void main(String[] args) throws Exception { 
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 자연수 N
		int N = Integer.parseInt(br.readLine());
		
		// 제곱수 합의 최소 갯수 
		int[] dp = new int[N + 1];
		
		for ( int i = 1; i <= N; i++ ) {
			
			// 최솟값을 구하는 문제는 0으로 초기화 하면 안 된다.
			// i의 경우 최댓값이기 때문에 i로 초기화
			dp[i] = i;
			
			// 실수 처리를 하지 않기 위해 j * j
			for ( int j = 1; j * j <= i; j++ ) {
				if ( dp[i] > dp[i - j * j] + 1 ) {
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}
		System.out.println(dp[N]);
	}
}
