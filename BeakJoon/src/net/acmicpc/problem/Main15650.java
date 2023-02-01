package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N�� M 2
/*
 * 1~N���� �ߺ����� M���� �� ������ ��� ���ϴ� ����(��������)
 * ex) N=5, M=3 �� �� 123 124 125 132�� �ƴ϶� 134�� �;��Ѵ�.
 * 
 * N�� M 1������ index ��° ���� 1~N�߿��� �տ��� ������� ���� ������ �ߴٸ�,
 * N�� M 2������ index ��°�� num�� �־��ٸ�, num+1 ���� N �߿��� �տ��� ������� ���� ������ �Ѵ�.
 * 
 * N�� M 1������ check[]���� �տ��� ����� ������ �ƴ����� �Ǵ��ߴٸ�,
 * N�� M 2������ �׷� �ʿ䰡 ����.
 * �� �����δ� �׻� � ���� �־��ٸ� �� �������� num+1 ���� ä���, ���� ���� ���� �� ���� ū �� �߿� �ϳ��� ����ϱ� ������
 * ���� ���� ������ ���� ���� ����.
 */
public class Main15650 {

	// ������ ����� ����ؾ��ϴϱ� ����� ������ �迭
	public static int[] num = new int[10];
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �ڿ��� N�� M�� �־�����.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 0��°�� �� �� �ִ� ���� 1�̱� ������ start�� 1�� �;��Ѵ�.
		go(0, 1, N, M);
		System.out.println(sb);
	}
	
	// index = �� ��°�� ä��ٴ� �ǹ�, start = index ��°�� ���� ä����� �ϴµ�, ������ ���� start~N����
	// n�� �߿��� m�� �����ؾ� �ϴϱ� ������ ��ġ�� m-1
	public static void go(int index, int start, int n, int m) {
		
		if ( index == m ) {
			for ( int i = 0; i < m; i++ ) {
				sb.append(num[i]);
				if ( i != m - 1 ) sb.append(" ");
			}
			sb.append('\n');
			return;
		}
		
		// index ��°���� � �� i�� �־��� ��, ���� ���´� index+1�� �ǰ� ���⿡ ���� �� �ִ� ���� i+1~N
		for ( int i = start; i <= n; i++ ) {
			num[index] = i;
			// start�� i+1�� �Ѱ���� �Ѵ�.
			go(index + 1, i + 1, n, m);
		}
	}
}
