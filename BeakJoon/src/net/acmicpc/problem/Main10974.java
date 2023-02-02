package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ��� ���� 
/*
 * do ~ while �� ���� ����Ѵ�.
 * �迭 a�� 1~N������ ���� �� �־��ְ� ��� ������ ����ϸ鼭 ���� ������ �����ش�.
 * 
 * while�� ���� �˻縦 ó���� �ϸ� ���� ������ ���� ���Ŀ� ��� ������ ���ϱ� ������ 
 * ù ������ ���� �� ����.
 */
public class Main10974 {

	public static void main(String[] args) throws Exception { 
		
		// �Է� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// N�� �־�����.
		int N = Integer.parseInt(br.readLine());
		
		// �迭�� 1 ~ N������ ���� �� �־��ش�.
		int[] permutation = new int[N];
		for ( int i = 0; i < N; i++ ) {
			permutation[i] = i + 1;
		}
		
		do {
			for ( int i = 0; i < N; i++ ) {
				sb.append(permutation[i]).append(" ");
			}
			sb.append('\n');
		} while (next_purmutation(permutation));
		
		System.out.println(sb);
	}
	
	public static boolean next_purmutation(int[] permutation) {
		
		int standard = permutation.length - 1;
		while ( standard > 0 && permutation[standard - 1] >= permutation[standard] ) {
			standard -= 1;
		}
		
		if ( standard <= 0 ) {
			return false;
		}
		
		int prev = permutation.length - 1;
		while ( permutation[prev] <= permutation[standard - 1] ) {
			prev -= 1;
		}
		
		int temp = permutation[standard - 1];
		permutation[standard - 1] = permutation[prev];
		permutation[prev] = temp;
		
		prev = permutation.length - 1;
		
		while ( standard < prev ) {
			temp = permutation[standard];
			permutation[standard] = permutation[prev];
			permutation[prev] = temp;
			
			standard += 1;
			prev -= 1;
		}
		return true;
	}
}
