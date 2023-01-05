package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main15990 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		long mod = 1000000009L;
		int limit = 100000;
		int[][] d = new int[limit + 1][4];
		
		for ( int i = 1; i <= limit; i++ ) {
			if ( i - 1 >= 0 ) {
				d[i][1] = d[i - 1][2] + d[i - 1][3];
				if ( i == 1 ) {
					d[i][1] = 1;
				}
			}
			
			if ( i - 2 >= 0 ) {
				d[i][2] = d[i - 2][1] + d[i - 2][3];
				if ( i == 2 ) {
					d[i][2] = 1;
				} 
			}
			
			if ( i - 3 >= 0 ) {
				d[i][3] = d[i - 3][1] + d[i - 3][2];
				if ( i == 3 ) {
					d[i][3] = 1;
				}
			}
			d[i][1] %= mod;
			d[i][2] %= mod;
			d[i][3] %= mod;
		}
		
		while ( T-- > 0 ) {
			int n = Integer.parseInt(br.readLine());
			sb.append((d[n][1] + d[n][2] + d[n][3]) % mod).append('\n');
		}
		System.out.println(sb);
	}
}
