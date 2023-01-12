package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// �������� �� 
public class Main1699 {

	public static void main(String[] args) throws Exception { 
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �ڿ��� N
		int N = Integer.parseInt(br.readLine());
		
		// ������ ���� �ּ� ���� 
		int[] dp = new int[N + 1];
		
		for ( int i = 1; i <= N; i++ ) {
			
			// �ּڰ��� ���ϴ� ������ 0���� �ʱ�ȭ �ϸ� �� �ȴ�.
			// i�� ��� �ִ��̱� ������ i�� �ʱ�ȭ
			dp[i] = i;
			
			// �Ǽ� ó���� ���� �ʱ� ���� j * j
			for ( int j = 1; j * j <= i; j++ ) {
				if ( dp[i] > dp[i - j * j] + 1 ) {
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}
		System.out.println(dp[N]);
	}
}
