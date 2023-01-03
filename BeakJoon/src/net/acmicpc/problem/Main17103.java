package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// °ñµå¹ÙÈå ÆÄÆ¼¼Ç
public class Main17103 {

	public static boolean[] isPrime;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		isPrime = new boolean[1000001];
		get_prime();
		
		while ( T-- > 0 ) {
			int N = Integer.parseInt(br.readLine());
			
			int ans = 0;
			for ( int i = 2; i <= N / 2; i++ ) {
				if ( !isPrime[i] && !isPrime[N - i] ) {
					ans++;
				}
			}
			sb.append(ans).append('\n');					
		}
		System.out.println(sb);
	}
	
	public static void get_prime() {
		
		isPrime[0] = isPrime[1]	= true;
		
		for ( int i = 2; i * i < 1000000; i++ ) {
			if ( isPrime[i] == true ) {
				continue;
			}
			for ( int j = i + i; j < 1000000; j += i ) {
				isPrime[j] = true;
			}
		}
	}
}
