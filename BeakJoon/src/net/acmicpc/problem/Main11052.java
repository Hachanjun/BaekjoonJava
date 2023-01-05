package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카드 구매하기
public class Main11052 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] d = new int[N + 1];
		int[] a = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for ( int i = 1; i <= N; i++ ) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		for ( int i = 1; i <= N; i++ ) {
			for ( int j = 1; j <= i; j++ ) {
				d[i] = Math.max(d[i], d[i - j] + a[j]);
			}
		}
		System.out.println(d[N]);
	}
}
