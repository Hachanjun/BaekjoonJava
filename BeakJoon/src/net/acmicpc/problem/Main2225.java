package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// �պ��� 
public class Main2225 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ù° �ٿ� �� ������ �Է¹ޱ� ����
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		// K�� ���ؼ� ���� N�� �Ǿ�� �Ѵ�.
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// ������ ������ �迭
		long[][] dp = new long[K + 1][N + 1];
		
		// ������ ��
		long mod = 1000000000L;
		
		// �ʱ�ȭ
		dp[0][0] = 1;
		
		/*
		 * �� : k���� ���ؼ� n, �׶� ������ ���� l �̾��� �� n - l
		 * ���� :��ü�� k���ε�, ������ ��(l)�� ����ؼ� k���� �ȰŴ� k - 1
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
