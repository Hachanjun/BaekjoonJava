package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� ����
// ���� �������� �ε�ȣ�� �ٲٸ� �ȴ�.
public class Main10973 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// N�� �־�����.
		int N = Integer.parseInt(br.readLine());
		
		// ������ �־�����.
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
		int standard = permutation.length - 1;
		
		while ( standard > 0 && permutation[standard - 1] <= permutation[standard] ) {
			standard -= 1;
		}
		
		if ( standard <= 0 ) {
			return false;
		}
		
		int next = permutation.length - 1;
		while ( permutation[next] >= permutation[standard - 1] ) {
			next -= 1;
		}
		
		int temp = permutation[standard - 1];
		permutation[standard - 1] = permutation[next];
		permutation[next] = temp;
		
		next = permutation.length - 1;
		
		while ( standard < next ) {
			temp = permutation[standard];
			permutation[standard] = permutation[next];
			permutation[next] = temp;
			
			standard += 1;
			next -= 1;
		}
		
		return true;
	}
}
