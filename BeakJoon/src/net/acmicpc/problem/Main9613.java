package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// GCDÀÇ ÇÕ
public class Main9613 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while ( t-- > 0 ) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			int ans = 0;
			
			for ( int i = 0; i < n; i++ ) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			for ( int i = 0; i < n; i++ ) {
				for ( int j = i + 1; j < n; j++ ) {
					ans += gcd(a[i], a[j]);
				}
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	public static int gcd ( int a, int b ) {
		
		while ( b != 0 ) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
