package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� �� �����ϴ� �κ� ����
public class Main11053 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N �Է� �� ���� 
		int N = Integer.parseInt(br.readLine());
	
		// A[i]�� ���� ���� �������� �߶� ���� 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// ���� A[i] ���� 
		int[] A = new int[N + 1];
		
		// N���̸�ŭ A[i]�� �� �ֱ�
		for ( int i = 0; i < N; i++ ) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// ���ϱ� ���� ���� ������ �迭 
		int[] dp = new int[N + 1];
		
		for ( int i = 0; i < N; i++ ) {
			// �ʱ�ȭ : ��� ���� 1�� �ʱ�ȭ�Ѵ�. ���� : �ڽź��� 1�� �����ϱ� ����
			dp[i] = 1;
			for ( int j = 0; j < i; j++ ) {
				// A[j]�� A[i] ���� �տ� �־�� �ϸ�, A[i] ���� ���� �۾ƾ��Ѵ�.
				if ( A[j] < A[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			} 
		}
		
		// �ʱⰪ ���� ���� for������ �� 
		int ans = dp[0];
		
		for ( int i = 0; i < N; i++ ) {
			if ( ans < dp[i] ) {
				ans = dp[i];
			}
		}
		
		System.out.println(ans);
	}
}
