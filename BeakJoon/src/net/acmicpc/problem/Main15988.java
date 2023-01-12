package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1, 2, 3 ���ϱ� 3
public class Main15988 {

	public static void main(String[] args) throws Exception {
		
		// �Է� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// �׽�Ʈ ����
		int T = Integer.parseInt(br.readLine());
		
		// ���� �� 
		long mod = 1000000009L;
		
		// ����� ���� ������ �迭 
		long[] dp = new long[1000001];
		
		// �迭 �ʱ�ȭ, �ƹ� ���� ������� �ʴ� ����� �����Ƿ� �̰� ���� 1���� ������ ģ��.
		// (���� 0�� ��� ex n = 2 1+1, 0+2)
		dp[0] = 1;
		
		// N�� ����(1000000 ���� �۰ų� ����) 
		for ( int i = 1; i <= 1000000; i++ ) {
			// 1, 2, 3�� ������ �̷���� ������ 
			for ( int j = 1; j <= 3; j++ ) {
				// ������ ���� �� ���� ������ �� �� ������ ��
				// ������ ���� 1 �̸� �� �� ������ n - 1
				if ( i - j >= 0 ) {
					dp[i] += dp[i - j];
				}
			}
			dp[i] %= mod;
		}
		
		while ( T-- > 0 ) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append('\n');
		}
		System.out.println(sb);
	}
}
