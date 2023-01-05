package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10844 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long mod = 1000000000L;
		long[][] dp = new long[N + 1][10];
		
		for ( int i = 1; i <= N; i++ ) {
			dp[1][i] = 1;
		}
		
		for ( int i = 2; i <= N; i++ ) {
			for ( int j = 0; j <= i; j++ ) {
				if ( j == 0 ) {
					dp[i][0] = dp[i - 1][1] % mod;
				}
				
				if ( j == 9 ) {
					dp[i][9] = dp[i - 1][8] % mod;
				}
				
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		long ans = 0;
		for ( int i = 0; i < N; i++ ) {
			ans += dp[N][i];
		}
		System.out.println(ans % mod);
	}
}
