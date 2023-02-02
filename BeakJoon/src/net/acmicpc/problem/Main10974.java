package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 모든 순열 
/*
 * do ~ while 을 많이 사용한다.
 * 배열 a에 1~N까지의 수를 다 넣어주고 계속 순열을 출력하면서 다음 순열을 구해준다.
 * 
 * while에 대한 검사를 처음에 하면 다음 순열을 구한 이후에 모든 순열을 구하기 때문에 
 * 첫 순열을 구할 수 없다.
 */
public class Main10974 {

	public static void main(String[] args) throws Exception { 
		
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// N이 주어진다.
		int N = Integer.parseInt(br.readLine());
		
		// 배열에 1 ~ N까지의 수를 다 넣어준다.
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
