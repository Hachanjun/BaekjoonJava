package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ������
public class Main2156 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ������ ���� ���� N
		int N = Integer.parseInt(br.readLine());
		
		// ������ ���� ������ �迭
		int[] grape = new int[N + 1];
		
		// ������ ���� �Է�
		for ( int i = 1; i <= N; i++ ) {
			grape[i] = Integer.parseInt(br.readLine());
		}
		
		// ���� �ܵ��� ���� �� �ִ� ��
		int[] dp = new int[N + 1];

		// �������� ���� �� �ִ� ���� 3�� �̻� ���� �� ���� ��찡 �ֱ� ������ �̸� �ʱ�ȭ ���ش�.
		dp[1] = grape[1];
		
		// N�� 1�� �־��� �� �����Ƿ� �̷� ���� ���� ���ǽ��� �޾Ƶд�.
		// ���� dp[2]�� � ��쿡�� ù ��°�� �� ��°�� ���� ���� �ִ��̴�.
		if ( N > 1 ) {			
			dp[2] = grape[1] + grape[2];
		}
		
		for ( int i = 3; i <= N; i++ ) {
			// i��° �����ָ� ������ �ʴ� ��� �� ���� ���� ���� ����ȴ�.
			dp[i] = dp[i - 1];
			// 1�� ���� ���, grape[i-1]�� ������ ����
			dp[i] = Math.max(dp[i], dp[i - 2] + grape[i]);
			// 2�� ���� ���, grape[i-1]�� ���ð� grape[i-2]�� ������ �ʾƾ���
			dp[i] = Math.max(dp[i], dp[i - 3] + grape[i - 1] + grape[i]);
		}
		
		int ans = dp[1];
		
		for ( int i = 2; i <= N; i++ ) {
			if ( ans < dp[i] ) {
				ans = dp[i];
			}
		}
		System.out.println(ans);
	}
}
