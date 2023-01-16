package net.acmicpc.problem;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정수 삼각형
public class Main1932 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 삼각형의 크기
		int N = Integer.parseInt(br.readLine());
		
		// 삼각형의 숫자가 담길 배열
		int[][] arr = new int[N][N];
		
		// 최댓값이 담길 배열
		int[][] dp = new int[N][N];
		
		for ( int i = 0; i < N; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for ( int j = 0; j <= i; j++ ) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 맨 위에 있는 값으로 초기화
		dp[0][0] = arr[0][0];
		/*
		 * i, j가 선택되기 전에 선택된 수는 [i - 1][j], [i - 1][j - 1] 중 하나다.
		 * dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j]
		 */
		for ( int i = 1; i < N; i++ ) {
			for ( int j = 0; j<=i; j++ ) {
				dp[i][j] = dp[i - 1][j] + arr[i][j];
				
				System.out.println("i = " + i + " j = " + j + "===========" + dp[i][j]);
				
				if ( j - 1 >= 0 && dp[i][j] < dp[i - 1][j - 1] + arr[i][j] ) {
					dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
				}
			}
		}
		int ans = dp[N - 1][0];
		for ( int i = 0; i < N; i++ ) {
			if ( ans < dp[N - 1][i] ) {
				ans = dp[N - 1][i];
			}
		}
		System.out.println(ans);
	}
}
