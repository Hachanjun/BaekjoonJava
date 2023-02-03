 package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ���̸� �ִ��
/*
 * �� N���� �־����� ��, ���� ����� �ִ�� �ϴ� ��� 
 * ������ 8�ۿ� �� �Ǹ�, ���� ������ ������ �� �ִ�.
 * ������ 8�̱� ������ 8 * 8! = 32�� -> ��� ��츦 �� �غ��� �ȴ�.
 * 
 * ������ �� ����� ���� ���� ������ �����ִ´�� ���
 */
public class Main10819 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 3 <= N <= 8 �� N�� �־�����.
		int N = Integer.parseInt(br.readLine());
		
		// �迭�� ����ִ� ������ �־�����.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] permutation = new int[N];
		for ( int i = 0; i < N; i++ ) {
			permutation[i] = Integer.parseInt(st.nextToken());
		}
		
		// ������ �ʼ� 
		// ���� ������ �̿��ؼ� ��� ������ ���Ϸ��� ��� ������ ù ���� ���� �����ؾ��Ѵ�.
		// ù ������ ���������̴ϱ� ������ ������Ѵ�.
		Arrays.sort(permutation);
		int ans = 0;
		do {
			int temp = calculator(permutation);
			ans = Math.max(ans, temp);
		} while( next_permutation(permutation) );
		
		System.out.println(ans);
	}
	
	// ������ �����ִ� ��, ��� ������ ���� ���̸� ���� �� ������ �����ش�.
	public static int calculator(int[] permutation) {
		int sum = 0;
		for ( int i = 1; i < permutation.length; i++ ) {
			sum += Math.abs(permutation[i] - permutation[i - 1]);
		}
		return sum;
	}
	
	public static boolean next_permutation(int[] permutation) {
		int standard = permutation.length - 1;
		while ( standard > 0 && permutation[standard - 1] >= permutation[standard] ) {
			standard -= 1;
		}
		
		if ( standard <= 0 ) {
			return false;
		}
		
		int next = permutation.length - 1;
		while ( permutation[next] <= permutation[standard - 1] ) {
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
