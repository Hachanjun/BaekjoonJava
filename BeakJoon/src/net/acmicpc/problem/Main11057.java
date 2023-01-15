package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ������ ��
public class Main11057 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���̰� N
		int N = Integer.parseInt(br.readLine());
		
		// �������� ������ ������ �迭 �޸����̼�
		long[][] dp = new long[N + 1][10];
		
		// ���� ��
		int mod = 10007;
		
		// ��� ���̰� 1�� ���� ��������
		for ( int i = 0; i <= 9; i++ ) {
			dp[1][i] = 1;
		}
		
		/*
		 * ���̰� i�̸�, ������ ���� j�� �� �� �տ� �� �� �ִ� ���� �ʹ� ���� ������
		 * k��� ������ ��� 
		 * �� i = ����, j = ������ ��, k = j �տ� �� �� �ִ� �� 
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
