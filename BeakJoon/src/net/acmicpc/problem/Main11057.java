package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 오르막 수
public class Main11057 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 길이가 N
		int N = Integer.parseInt(br.readLine());
		
		// 오르막의 갯수를 저장할 배열 메모리제이션
		long[][] dp = new long[N + 1][10];
		
		// 나눌 수
		int mod = 10007;
		
		// 모든 길이가 1인 수는 오르막수
		for ( int i = 0; i <= 9; i++ ) {
			dp[1][i] = 1;
		}
		
		/*
		 * 길이가 i이며, 마지막 수가 j일 때 그 앞에 올 수 있는 수는 너무 많기 때문에
		 * k라는 변수를 사용 
		 * 즉 i = 길이, j = 마지막 수, k = j 앞에 올 수 있는 수 
		 */
		for ( int i = 2; i <= N; i++ ) {
			for ( int j = 0; j <= 9; j++ ) {
				for ( int k = 0; k <= j; k++ ) {
					dp[i][j] += dp[i - 1][k];
					dp[i][j] %= mod;
				}
			}
		}
		long ans = 0;
		for ( int i = 0; i < 10; i++ ) {
			ans += dp[N][i];
		}
		System.out.println(ans %= mod);
	}
}
