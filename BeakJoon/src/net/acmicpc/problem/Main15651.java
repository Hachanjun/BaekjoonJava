package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N�� M 3
/*
 * 1~N���� �ڿ��� �߿� M���� �� ������ ��� ���ϴ� ����(�ߺ� ���� ����)
 * N�� M 1���� �ߺ� ó���ߴ� �κ��� �����ָ� �ȴ�.
 */
public class Main15651 {

	// ����� ������ �����Ѵٰ� ������ �ᱣ���� ������ �迭
	public static int[] num = new int[10];
	
	// ���
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
	
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ù° �ٿ� �ڿ��� N�� M�� �־�����.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// ���� ó������ 0��° ���� ä�����Ѵ�.
		go(0, N, M);
		System.out.println(sb);
	}
	
	// index = index��° ���� ä��ٴ� �ǹ�
	public static void go(int index, int n, int m) {
		// m�� ������ �ڸ���, m-1���� ä��� m�ڸ��� ���� �Դٸ� ����� ���(m=3�̶��, 012 ������ 2��° �ڸ����� ä��ϱ�)
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
		
		// ���� �߰��ϴ� �κ�
		// ��� index ��° ��ġ�� �����ϴ� �� i�� 1~n���� -> 1~n���� �ϳ��� �� �־��.
		for ( int i = 1; i <= n; i++ ) {
			num[index] = i;
			
			// ���� ��°�� index+1�� �Ѿ��.
			go( index + 1, n, m);
		}
	}
}
