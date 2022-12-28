package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 찾기
public class Main1978 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while ( st.hasMoreTokens() ) {
			int N = Integer.parseInt(st.nextToken());
			boolean isPrime = true;
			
			if ( N == 1 ) {
				continue;
			}
			
			for ( int i = 2; i * i < N; i++ ) {	
				if ( N % i == 0 ) {
					isPrime = false;
				} 
			}
			if ( isPrime ) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
