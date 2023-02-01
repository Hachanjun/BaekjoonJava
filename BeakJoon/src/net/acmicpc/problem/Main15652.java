package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N�� M 4
/*
 * 1���� N���� �ڿ��� �߿��� M���� �� ������ ��� ���ϴ� ����(�ߺ� ���� ����, �񳻸�����)
 * �񳻸����� :  11223 (���� ���� ������, ���������� ����)
 * 
 * (������ �����̶�� index��° �ڸ��� i��� ���� ����, index+1��°���� i+1~N�� �� �� �־ ���۰�(start)�� i+1�� �Ѱ�������,
 *  �� ������ ���� ���� �� �� ������(�ߺ� ���) i~N�����̴�. -> start�� �Ѱ��ִ� ���� i)
 */
public class Main15652 {

	// �ᱣ���� ������ �迭 
	public static int[] num = new int[10];
	
	// ��� 
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		// �Է� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �ڿ��� N�� M�� �־�����.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		go(0, 1, N, M);
		System.out.println(sb);
	}
	
	public static void go(int index, int start, int n, int m) {
		if ( index == m ) {
			for ( int i = 0; i < m; i++ ) {
				sb.append(num[i]);
				
				if ( i != m - 1 ) {
					sb.append(" ");
				}
			}
			sb.append('\n');
			return;
		}
		
		// index ��°�� � �� i�� �־��� ��, ���� ��°�� index+1 ��°�� ���� ���� �� �� ������
		// i~N���� �� �� �ִ�. �׷��� start�� �Ѱ��ִ� ���� i(�ߺ� ���)
		for ( int i = start; i <= n; i++ ) {
			num[index] = i;
			go(index + 1, i, n, m);
		}
	}
}
