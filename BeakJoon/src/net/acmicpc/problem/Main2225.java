package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 합분해 
public class Main2225 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄에 두 정수를 입력받기 위해
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		// K를 더해서 합이 N이 되어야 한다.
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 갯수를 저장할 배열
		long[][] dp = new long[K + 1][N + 1];
		
		// 나누는 수
		long mod = 1000000000L;
		
		// 초기화
		dp[0][0] = 1;
		
		/*
		 * 합 : k개를 합해서 n, 그때 마지막 수가 l 이었을 때 n - l
		 * 갯수 :전체가 k개인데, 마지막 수(l)을 사용해서 k개가 된거니 k - 1
		 */
		
		for ( int i = 1; i <= K; i++ ) {
			for ( int j = 0; j <= N; j++ ) {
				for ( int l = 0; l <= j; l++ ) {
					dp[i][j] += dp[i - 1][j - l];
					dp[i][j] %= mod;
				}
			}
		}
		
		System.out.println(dp[K][N]);
	}
}
