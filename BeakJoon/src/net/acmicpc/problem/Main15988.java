package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1, 2, 3 더하기 3
public class Main15988 {

	public static void main(String[] args) throws Exception {
		
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 갯수
		int T = Integer.parseInt(br.readLine());
		
		// 나눌 수 
		long mod = 1000000009L;
		
		// 방법의 수를 저장할 배열 
		long[] dp = new long[1000001];
		
		// 배열 초기화, 아무 수도 사용하지 않는 방법도 있으므로 이것 또한 1개의 갯수로 친다.
		// (수를 0개 사용 ex n = 2 1+1, 0+2)
		dp[0] = 1;
		
		// N의 갯수(1000000 보다 작거나 같다) 
		for ( int i = 1; i <= 1000000; i++ ) {
			// 1, 2, 3의 합으로 이루어져 있으니 
			for ( int j = 1; j <= 3; j++ ) {
				// 마지막 수를 뺀 값이 마지막 수 앞 까지의 합
				// 마지막 수가 1 이면 그 앞 까지는 n - 1
				if ( i - j >= 0 ) {
					dp[i] += dp[i - j];
				}
			}
			dp[i] %= mod;
		}
		
		while ( T-- > 0 ) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append('\n');
		}
		System.out.println(sb);
	}
}
