package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� �� �����ϴ� �κ� ����
public class Main11722 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� A�� ũ�� N
		int N = Integer.parseInt(br.readLine());
		
		// ���� A�� �̷�� �ִ� A[i]
		int[] arr = new int[N + 1];
		
		// �������� �����Ͽ� A[i]�� �Է�
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 1; i <= N; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// ������ ���̸� ������ �迭 �޸����̼�
		int[] dp = new int[N + 1];
		
		for ( int i = 1; i <= N; i++ ) {
			dp[i] = 1;
			for ( int j = 1; j <= i; j++ ) {
				// A[j] > A[i] (�����ϴ� �κ� �����̱� ������(��)), j�� i���� Ŀ���Ѵ�.(����(��°))
				if ( arr[j] > arr[i] && dp[i] < dp[j] + 1 ) {
					dp[i] = dp[j] + 1;
				}
			}
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
