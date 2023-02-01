package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��¥ ���
public class Main1476 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �������� �����Ͽ� E, S, M �Է�
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// �Է¹��� ���� ���ϱ� ����, 1�� �ʱ�ȭ ������ ���信�� ������ ����, 1 1 1 �� �׻� 1�̴�.
		int e = 1;
		int s = 1;
		int m = 1;
		
		for ( int i = 1;; i++ ) {
			
			if ( e == E && s == S && m == M ) {

				System.out.println(i);
				break;
			}
			
			e += 1;
			s += 1;
			m += 1;
			
			if ( e == 16 ) e = 1;
			if ( s == 29 ) s = 1;
			if ( m == 20 ) m = 1;
		}
	}
}