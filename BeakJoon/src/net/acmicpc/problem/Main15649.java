package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N�� M (����Լ�)
/*
 * 1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ������ ��� ���ϴ� ����
 * ������ ���õ� ���� -> ������ ������ � ���� �������� �˾ƾ� ���� ���� � ���� �־���ϴ����� �� �� �ִ�.
 * � ���� ����߰�, � ���� ������� �ʾҴ��� �ľ� -> c[i] = ���(true), �̻��(false)
 * 
 * index�� �� �� �ִ� ���� c[i] == false �� �� / index�� num(����)�� �־�����, �������� index+1��°�� �Ѿ��.
 * index+1�� �Ѿ ���� num�� ����� ���ϱ� c[num] = true
 */
public class Main15649 {

	// ����� �� ���� üũ�� �迭
	public static boolean[] check = new boolean[10];
	
	// ������ ������ ����� ����ؾ� �ϴϱ� ����� ������ �迭
	public static int[] num = new int[10];
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �ڿ��� N, M�� �־�����.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// ���� ó������ 0��° ���� ä�����Ѵ�.
		go(0, N, M);
		System.out.println(sb);
		
	}
	
	// n,m�� �Է� index = index ��°�� ä����� �Ѵٴ� �ǹ�
	// n�� �߿��� m���� �����ؾ� �ϴ� ���̴ϱ� ������ ��ġ�� m-1
	public static void go(int index, int n, int m) {
		// m-1 ��° ��ġ�� ��� ���� �ְ� ���� ��ġ�� �Ѿ���� m��° ��ġ�� ���� ���̰� m��° ��ġ�� ����
		if ( index == m ) {
			for ( int i =0; i < m; i++ ) {
				sb.append(num[i]);
				if ( i != m - 1 ) sb.append(" ");
			}
			sb.append('\n');
			return;
		}
		
		// ���� �߰��ϴ� �κ�
		// ��� index ��° ��ġ�� �����ϴ� �� i�� 1~n -> �׷��� 1~n���� �� ���� �־��.
		for ( int i = 1; i <= n; i++ ) {
			// �ߺ��Ǹ� �ȵǱ� ������ i��� ���� ����� ���� ������ �ǳʶڴ�.
			if ( check[i] ) continue;
			// index ��°�� �� i�� ����
			// ��������ϱ� i�� true
			check[i] = true;
			// ������� i�� �־��ش�.
			num[index] = i;
			// ���� ��°�� index + 1�� �Ѿ��.
			go( index + 1, n, m );
			// ����Լ��� ȣ���� �������� index��°�� �� i�� �ְ� ���� �� �ִ� ����� �� ����Ŵϱ� 
			// �ٽ� ������� ���� ������ �������� �Ѵ�.
			check[i] = false;
		}
	}
}
