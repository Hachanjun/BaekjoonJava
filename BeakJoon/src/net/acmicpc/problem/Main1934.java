package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// �ּҰ����
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
			
			// �ִ����� ���ϱ�
			int GCD = gcd(A, B);
			
			// �ּҰ����
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
