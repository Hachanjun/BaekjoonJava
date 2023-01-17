package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 감소하는 부분 수열
public class Main11722 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수열 A의 크기 N
		int N = Integer.parseInt(br.readLine());
		
		// 수열 A를 이루고 있는 A[i]
		int[] arr = new int[N + 1];
		
		// 공백으로 구분하여 A[i]에 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 1; i <= N; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 수열의 길이를 저장할 배열 메모리제이션
		int[] dp = new int[N + 1];
		
		for ( int i = 1; i <= N; i++ ) {
			dp[i] = 1;
			for ( int j = 1; j <= i; j++ ) {
				// A[j] > A[i] (감소하는 부분 수열이기 때문에(수)), j는 i보다 커야한다.(길이(번째))
				if ( arr[j] > arr[i] && dp[i] < dp[j] + 1 ) {
					dp[i] = dp[j] + 1;
				}
			}
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
