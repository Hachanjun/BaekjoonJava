package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� ����
public class Main10972 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// N�� �־�����.
		int N = Integer.parseInt(br.readLine());
		
		// ��° �ٿ� ������ �־�����.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] permutation = new int[N];
		for ( int i = 0; i < N; i++ ) {
			permutation[i] = Integer.parseInt(st.nextToken());
		}
		
		if ( next_permutation(permutation) ) {
			for ( int i = 0; i < N; i++ ) {
				sb.append(permutation[i]).append(" ");
			}
			sb.append('\n');
		} else {
			sb.append("-1");
		}
		System.out.println(sb);
	}
	
	public static boolean next_permutation(int[] permutation) {
		
		/*
		 * ù ������ ���������̰� ������ ������ ��������
		 * � ������ �տ� ��� ������ �����ϴ� ������ ������ ���� ��������, �� ���� ������ �տ��� ���� �������� �޶����� ù ������ ���;��Ѵ�.
		 */
		int standard = permutation.length - 1;
		
		// ������ i��°���� ���� �����ϴ� ���������� ������ i-1��° ������ �����ϴ� ������ ����
		// �̰��� ã������ �ڿ��� ���� ���� �ϳ��� ���ϸ鼭 ��Ұ��谡 ��߳� ���� Ž���� ����
		while ( standard > 0 && permutation[standard - 1] >= permutation[standard] ) {
			standard -= 1;
		}
		
		// ������ ����, ���� ������ �����ϱ� false
		// ������� ������ ������ 7654321 
		if ( standard <= 0 ) {
			return false;
		} 
		
		// standard-1��°�� ������ �����̴ϱ� ���� ���� ã�ƾ��Ѵ�.
		// ���� ���� standard-1��° �� ���� ū �� �� ���� ���� ������ �Ѵ�.
		int prev = permutation.length - 1;
		while ( permutation[prev] <= permutation[standard - 1] ) {
			prev -= 1;
		}
		
		// permutation[standard - 1]�� permutation[prev]�� ��ȯ�Ѵ�.
		int temp = permutation[standard - 1];
		permutation[standard - 1] = permutation[prev];
		permutation[prev] = temp;
		
		prev = permutation.length - 1;

		// ������ ������ �������ش�.(ù ������ ����� �۾�)
		// �������� -> ��������
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
