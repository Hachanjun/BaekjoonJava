package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이전 순열
public class Main10973 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N이 주어진다.
		int N = Integer.parseInt(br.readLine());
		
		// 순열이 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] permutation = new int[N];
		for ( int i = 0; i < N; i++ ) {
			permutation[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}
	
	public static boolean next_permutation(int[] permutation) {
		int standard = permutation.length - 1;
		
		while ( standard > 0 && permutation[standard - 1] >= permutation[standard] ) {
			standard -= 1;
		}
		
		if ( standard <= 0 ) {
			return false;
		}
		
		int prev = permutation.length - 1;
		while ( prev > 0 && permutation[prev] >= permutation[standard - 1] ) {
			prev -= 1;
		}
		
		int temp = permutation[standard - 1];
		permutation[standard - 1] = permutation[prev];
		permutation[prev] = temp;
		
		prev = permutation.length - 1;
		
		while ( standard > prev ) {
			temp = permutation[standard];
			permutation[standard] = permutation[prev];
			permutation[prev] = temp;
		}
		
		return true;
	}
}
