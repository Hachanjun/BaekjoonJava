package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// �� �̾�� 1
/*
 *  ex) N = 120
 *  1 ~ 9 		1�ڸ��� * (9 - 1 + 1)
 *  10 ~ 99		2�ڸ��� * (99 - 10 + 1)
 *  100 ~ 120	3�ڸ��� * (120 - 100 + 1) 
 *  -> ���� �ڸ��� ���� ����� ������ �ذ��� �� �ִ�. -> 1 ~ N���� ���� �������� �ֱ� ������ �� ������� Ǯ �� �ִ�.
 */
public class Main1748 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long ans = 0L; 
		/*
		 * start ~ start * 10 - 1 ���� ����ϴ� ���
		 * start�� 1 ���� 10�� �Ǳ� ������ (1, 10, 100, 1000...)
		 * end�� ��쿡�� (9, 99, 999, 9999...)
		 * ���ܷδ� ���� ������ ���� �־���(N) �� ���� Ŭ ��� N���� ���Խ�Ų��.
		 */
		for ( int start = 1, length = 1; start <= N; start *= 10, length++ ) {
			int end = start * 10 - 1;
			if ( end > N ) {
				end = N;
			}
			// ���� ���ǿ� ���� ������ ���ؼ� N���� ��ģ ���� ���̸� ���� �� �ִ�.
			ans += (long)(end - start + 1) * length;
		}
		System.out.println(ans);
	}
}
