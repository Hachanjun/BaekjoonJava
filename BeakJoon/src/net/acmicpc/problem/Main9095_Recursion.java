package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1,2,3 ���ϱ� ����Լ� Ǯ��
/*
 * ���� N�� 1,2,3�� ������ ��Ÿ���� ����� ���� ���ϴ� ����
 * ������ ������ N <= 10
 * 
 * 1,2,3�� ����� �� ������, N�� �ִ� 10�̴ϱ� ����� �� �ִ� ���� ������ �ִ� 10���� ���� �ʴ´�.
 * ������ ���� 1,2,3 �� �ϳ� 
 * 
 * ����Լ��� ������� ��� ������ ���� ���س���, ������ ���� ���ο� ���� ���� �� ���� ��� ���ϴ����� Ȯ���ϴ� ����Լ�
 * go(count, sum, goal) -> ���� count ���� �� sum�� ����� ����� ��
 * N = goal
 * 
 * ���� count���� ����ؼ� ��� ���ؼ� ��������� sum
 * ���� ����(������ ������ ������ �� ���� ���)�� ���Ϸ��� ���ο� ���� �����ش�.
 * count -> count + 1
 * sum -> sum + 1
 * 
 * �Ұ����� ���(���ȣ���� ����ص� ������ ã�� �� ���� ���, ������ ������ ������ ���) : sum > goal(N) ������� �ϴ� ���� �Ѿ ���
 * ������ ã�� ��� : ������ ������ ã���Ŷ� �� �̻� �Լ� ȣ���� �� �ʿ䰡 ���� �� -> sum == goal
 * ���� ��� ȣ��(�� �� �� �ƴ� ��) : �� i�� ������ ����ߴٰ� �ϸ�,
 * -> go(count + 1, sum + i, goal)
 */
public class Main9095_Recursion {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���
		StringBuilder sb = new StringBuilder();
		
		// ���̽����̽�
		int T = Integer.parseInt(br.readLine());
		
		for ( int i = 0; i < T; i++ ) {
			// ���� N�� �־�����.
			int N = Integer.parseInt(br.readLine());
			
			sb.append(go(0, N)).append('\n');
		}
		System.out.println(sb);
	}
	
	public static int go(int sum, int n) {
		
		// �Ұ����� ���
		if ( sum > n ) return 0;
		
		// ������ ã�� ���
		if ( sum == n ) return 1;
		
		// ������ ������ ������ �� ���� ��� ���� ���¸� ���Ϸ��� ���ο� ���� �����ش�.
		int now = 0;
		for ( int i = 1; i <= 3; i++ ) {
			now += go(sum + i, n);
		}
		return now;
	}
}
