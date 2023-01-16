package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 포도주
public class Main2156 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 포도주 잔의 갯수 N
		int N = Integer.parseInt(br.readLine());
		
		// 포도주 양을 저장할 배열
		int[] grape = new int[N + 1];
		
		// 포도주 양을 입력
		for ( int i = 1; i <= N; i++ ) {
			grape[i] = Integer.parseInt(br.readLine());
		}
		
		// 이전 잔들을 선택 한 최대 합
		int[] dp = new int[N + 1];

		// 연속으로 마실 수 있는 경우와 3잔 이상 마실 수 없는 경우가 있기 때문에 미리 초기화 해준다.
		dp[1] = grape[1];
		
		// N이 1로 주어질 수 있으므로 이럴 때를 위해 조건식을 달아둔다.
		// 또한 dp[2]는 어떤 경우에도 첫 번째와 두 번째를 합한 것이 최댓값이다.
		if ( N > 1 ) {			
			dp[2] = grape[1] + grape[2];
		}
		
		for ( int i = 3; i <= N; i++ ) {
			// i번째 포도주를 마시지 않는 경우 그 앞의 잔의 양이 저장된다.
			dp[i] = dp[i - 1];
			// 1번 마신 경우, grape[i-1]을 마시지 않음
			dp[i] = Math.max(dp[i], dp[i - 2] + grape[i]);
			// 2번 마신 경우, grape[i-1]을 마시고 grape[i-2]는 마시지 않아야함
			dp[i] = Math.max(dp[i], dp[i - 3] + grape[i - 1] + grape[i]);
		}
		
		int ans = dp[1];
		
		for ( int i = 2; i <= N; i++ ) {
			if ( ans < dp[i] ) {
				ans = dp[i];
			}
		}
		System.out.println(ans);
	}
}
