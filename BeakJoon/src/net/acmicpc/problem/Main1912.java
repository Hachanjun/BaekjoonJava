package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ������
public class Main1912 {

	public static void main(String[] args) throws Exception {
		
		// �Է¹ޱ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� n�� �Է�
		int n = Integer.parseInt(br.readLine());
		
		// n���� ������ �̷���� ����(������ �Է¹��� ��) 
		int[] num = new int[n + 1];
		
		// i��°���� ������ �������� �ִ� 
		int[] dp = new int[n + 1];
		
		// ������ �Է� 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < n; i++ ) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for ( int i = 0; i < n; i++ ) {
			// �������� ���� ���
			dp[i] = num[i];
			
			// 0��° ���� �տ� ���� ������ �ǳʶ�
			if ( i == 0 ) continue;
			
			// �տ� ���� �����ϴ� ��� 
			if ( dp[i] < dp[i - 1] + num[i] ) {
				dp[i] = dp[i - 1] + num[i];
			}
		}
		
		// �ִ� ���� ���� 
		int max = -1;
		
		for ( int i = 0; i < n; i++ ) {
			// �� �� �ִ��� max�� ���� 
			if ( max < dp[i] ) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
