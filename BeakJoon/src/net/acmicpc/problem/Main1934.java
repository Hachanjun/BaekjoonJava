package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소공배수
public class Main1934 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for ( int i = 0; i < T; i++ ) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 최대공약수 구하기
			int GCD = gcd(A, B);
			
			// 최소공배수
			int LCD = ( A * B ) / GCD;
			sb.append(LCD).append('\n');
		}
		System.out.println(sb);
	}
	public static int gcd (int A, int B) {
		while ( B != 0 ) {
			int r = A % B;
			A = B;
			B = r;
		}
		return A;
	}
}
