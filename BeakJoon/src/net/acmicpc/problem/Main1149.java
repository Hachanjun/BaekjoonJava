package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// RGB �Ÿ�
public class Main1149 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� �� N
		int N = Integer.parseInt(br.readLine());
		
		// 0 = red, 1 = green, 2 = blue
		// �ּڰ��� ����� �迭 �޸����̼�
		int[][] dp = new int[N + 1][3];
		
		// ����� ����� �迭 
		int[][] cost = new int[N + 1][3];
		
		// �������� ������ i�� ���� �Է¹޴´�. j(����)�� 0, 1, 2
		StringTokenizer st;
		for ( int i = 1; i <= N; i++ ) {
			st  = new StringTokenizer(br.readLine(), " ");
			for ( int j = 0; j < 3; j++ ) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*
		 * ���ӿ� ���� ���� 
		 * ��� ������ ���� N�� �Ǿ��ٰ� ���� �� �� ���� �� ������ �ڸ� ���� 1�̶�� 
		 * ��� ������ N - 1�� �� ���̰� ���� ���� ���������� �� �� ���ٸ� 
		 * ������ ��(1)�� �ƴ� ���� ���� �ϸ� �ȴ�.   
		 */
		for ( int i = 1; i <= N; i++ ) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
}
