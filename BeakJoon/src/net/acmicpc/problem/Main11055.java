package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� ū �����ϴ� �κ� ���� 
public class Main11055 {

	public static void main(String[] args) throws Exception {
		
		// �Է� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� A�� ũ�� 
		int A = Integer.parseInt(br.readLine());
		
		// ���� A�� �̷�� �ִ� A[i]�� �������� �����Ͽ� �Է� 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[A + 1];
		
		for ( int i = 0; i < A; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// �ִ� ���� ������ �迭 �޸����̼� 
		int[] dp = new int[A + 1];
		
		for ( int i = 0; i < A; i++ ) {
			dp[i] = arr[i];
			
			for ( int j = 0; j < i; j++ ) {
				// j�� i���� �տ� �־�� �ϰ�, �����ؾ� �ϴϱ� arr[j]�� arr[i] ���� �۾ƾ��Ѵ�.
				if ( arr[j] < arr[i] && dp[i] < dp[j] + arr[i] ) {
					// dp[j]�� arr[j] �ձ����� ����
					dp[i] = dp[j] + arr[i];
				}
			}
		}
		int ans = dp[0];
		for ( int i = 0; i < A; i++ ) {
			if ( ans < dp[i] ) {
				ans = dp[i];
			}
		}
		System.out.println(ans);
	}
}
