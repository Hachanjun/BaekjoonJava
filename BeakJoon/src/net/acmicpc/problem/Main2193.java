package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ÀÌÄ£¼ö
public class Main2193 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N + 1][2];
		
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for ( int i = 2; i <= N; i++ ) {
			for ( int j = 0; j < 2; j++ ) {
				if ( j == 0 ) {
					dp[i][j] = dp[i - 1][0] + dp[i - 1][1];
				} else {
					dp[i][j] = dp[i - 1][0];
				}
			}
		}
		
		long ans = 0;
		for ( int i = 0; i < 2; i++ ) {
			ans += dp[N][i];
		}
		System.out.println(ans);
	}
}
