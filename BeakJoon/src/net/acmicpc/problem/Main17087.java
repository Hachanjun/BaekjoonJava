package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ¼û¹Ù²ÀÁú6
public class Main17087 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] a = new int[N];
		int[] b = new int[N];
		
		int ans = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for ( int i = 0; i < N; i++ ) {
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Math.abs(S - a[i]);
		}

		ans = b[0];
		for ( int i = 1; i < N; i++ ) {
			ans = gcd(ans, b[i]);
		}
		System.out.println(ans);
	}
	
	public static int gcd(int a, int b) {
		
		while ( b != 0 ) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
