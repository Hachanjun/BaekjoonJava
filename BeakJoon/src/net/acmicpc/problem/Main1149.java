package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// RGB 거리
public class Main1149 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 집의 수 N
		int N = Integer.parseInt(br.readLine());
		
		// 0 = red, 1 = green, 2 = blue
		// 최솟값이 저장될 배열 메모리제이션
		int[][] dp = new int[N + 1][3];
		
		// 비용이 저장될 배열 
		int[][] cost = new int[N + 1][3];
		
		// 공백으로 구분해 i번 집을 입력받는다. j(색상)는 0, 1, 2
		StringTokenizer st;
		for ( int i = 1; i <= N; i++ ) {
			st  = new StringTokenizer(br.readLine(), " ");
			for ( int j = 0; j < 3; j++ ) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*
		 * 연속에 대한 조건 
		 * 어떠한 수들을 더해 N이 되었다고 했을 때 그 수들 중 마지막 자리 수가 1이라면 
		 * 어떠한 수들은 N - 1이 될 것이고 같은 수가 연속적으로 올 수 없다면 
		 * 마지막 수(1)이 아닌 수가 오게 하면 된다.   
		 */
		for ( int i = 1; i <= N; i++ ) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
}
