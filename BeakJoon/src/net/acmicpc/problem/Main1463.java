package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1로 만들기
public class Main1463 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int[] memo = new int[X + 1];
		
		memo[1] = 0;
		
		for ( int i = 2; i <= X; i++ ) {
			memo[i] = memo[i -1] + 1;
			
			if ( i % 2 == 0 && memo[i] > memo[i / 2] + 1 ) {
				memo[i] = memo[i / 2] + 1;
			}
			if ( i % 3 == 0 && memo[i] > memo[i / 3] + 1 ) {
				memo[i] = memo[i / 3] + 1;
			}
		}
		System.out.println(memo[X]);
	}
	
//	public static void main(String[] args) throws Exception {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		d = new int[N + 1];
//		
//		System.out.println(go(N));
//	}
//	
//	public static int go(int n) {
//		
//		if ( n == 1 ) {
//			return 0;
//		}
//		
//		if ( d[n] > 0 ) {
//			return d[n];
//		}
//		
//		d[n] = go(n - 1) + 1;
//		if ( n % 2 == 0 ) {
//			int temp = go(n / 2) + 1;
//			
//			if ( d[n] > temp ) {
//				d[n] = temp;
//			}
//		}
//		
//		if ( n % 3 == 0 ) {
//			int temp = go(n / 3) + 1;
//			
//			if ( d[n] > temp ) {
//				d[n] = temp;
//			}
//		}
//		return d[n];
//	}
}
