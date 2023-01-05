package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1, 2, 3 ¥ı«œ±‚
public class Main9095 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for ( int i = 4; i < 11; i++ ) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append('\n');
		}
		System.out.println(sb);
	}
}
