package net.acmicpc.problem;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� �ﰢ��
public class Main1932 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �ﰢ���� ũ��
		int N = Integer.parseInt(br.readLine());
		
		// �ﰢ���� ���ڰ� ��� �迭
		int[][] arr = new int[N][N];
		
		// �ִ��� ��� �迭
		int[][] dp = new int[N][N];
		
		for ( int i = 0; i < N; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for ( int j = 0; j <= i; j++ ) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �� ���� �ִ� ������ �ʱ�ȭ
		dp[0][0] = arr[0][0];
		/*
		 * i, j�� ���õǱ� ���� ���õ� ���� [i - 1][j], [i - 1][j - 1] �� �ϳ���.
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
