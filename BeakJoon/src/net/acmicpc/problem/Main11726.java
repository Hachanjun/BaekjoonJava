package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2xn ≈∏¿œ∏µ
public class Main11726 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[1001];
		
		d[1] = 1;
		d[2] = 2;
		
		for ( int i = 3; i <= n; i++ ) {
			d[i] = d[i - 1] + d[i - 2];
			d[i] %= 10007;
		}
		
		System.out.println(d[n]);
	}
}
