package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대공약수와 최소공배수
public class Main2609 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		// 최대공약수
		int GCD = gcd(A, B);
		sb.append(GCD).append('\n');
		
		// 최소공배수
		int LCM = (A * B) / GCD;
		sb.append(LCM);
		
		System.out.println(sb);
	}
	
	public static int gcd(int A, int B) {
		while ( B != 0 ) {
			int r = A % B;
			A = B;
			B = r;
		}
		return A;
	}
}
