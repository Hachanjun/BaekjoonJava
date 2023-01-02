package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main6588 {

	public static boolean[] prime;
	public static int MAX = 1000000;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		prime = new boolean[MAX + 1];
		get_prime();
		
		while ( true ) {
			
			int N = Integer.parseInt(br.readLine());
			if ( N == 0 ) {
				break;
			}
			
			for ( int i = 2; i <= N; i++ ) {
				
				if ( !prime[i] && !prime[N - i] ) {
					sb.append( N + " = " + i + " + " + (N - i) ).append('\n');
					break;
				}
			}
		}
		System.out.println(sb);
	}
	
	public static void get_prime() {
	
		// true 소수가 아니다.
		prime[0] = prime[1] = true;
		
		for ( int i = 2; i * i <= MAX; i++ ) {
			
			// 이미 체크된 배열은 다음으로 넘어간다.
			if ( prime[i] == true ) {
				continue;
			}
			
			for ( int j = i + i; j <= MAX; j += i ) {
				prime[j] = true;
			}		
		}
	}
}
