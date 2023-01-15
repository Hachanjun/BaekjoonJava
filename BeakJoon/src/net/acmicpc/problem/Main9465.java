package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��ƼĿ
/*
 * ������ ���� �ִ�� ����� ���ؼ� ū �� ���� �����ϴ� ����� �ִ밡 �� �� ������ �����δ� �׷��� �ʴ�.
 * ������ ū �� ���� �����ϸ� ������ ������ �� �� ���Ѵ�. 
 * ���� �����ϴ� ��ƼĿ�� ��� �������� ������ 
 */
public class Main9465 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// �׽�Ʈ���̽� T
		int T = Integer.parseInt(br.readLine());

		for ( int i = 0; i < T; i++) {
			// ī�� ���� n�� ����
			int N = Integer.parseInt(br.readLine());
			
			// ī�� ������ ����� 2�� N�� 
			long[][] card = new long[N + 1][2];
			
			// ī�� ������ �������� �����Ͽ� �Է� 
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for ( int j = 1; j <= N; j++ ) {
				card[j][0] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for ( int j = 1; j <= N; j++ ) {
				card[j][1] = Integer.parseInt(st.nextToken());
			}
			
			// �ִ��� ������ �迭 �޸����̼� 
			long[][] dp = new long[N + 1][3];
			/*
			 * 0 = ��������, 1 = ���� ��ƼĿ ����, 2 = �Ʒ��� ��ƼĿ ���� 
			 */
			for ( int j = 1; j <= N; j++ ) {
				// i - 1 ������ ��ƼĿ�� ��� ������� ��� ���� 
				dp[j][0] = Math.max(dp[j - 1][0], Math.max(dp[j - 1][1], dp[j - 1][2]));
				// i - 1 ������ ���� ��ƼĿ�� ������ �� �ȴ� 
				dp[j][1] = Math.max(dp[j - 1][0], dp[j - 1][2]) + card[j][0];
				// i - 1 ������ �Ʒ��� ��ƼĿ�� ������ �� �ȴ� 
				dp[j][2] = Math.max(dp[j - 1][0], dp[j - 1][1]) + card[j][1];
			}
			long ans = 0;
			ans = Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]));
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
