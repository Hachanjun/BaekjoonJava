package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
public class Main11053 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N 입력 값 대입 
		int N = Integer.parseInt(br.readLine());
	
		// A[i]에 넣을 값을 공백으로 잘라서 대입 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 수열 A[i] 변수 
		int[] A = new int[N + 1];
		
		// N길이만큼 A[i]에 값 넣기
		for ( int i = 0; i < N; i++ ) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 비교하기 위해 값을 저장할 배열 
		int[] dp = new int[N + 1];
		
		for ( int i = 0; i < N; i++ ) {
			// 초기화 : 모든 값은 1로 초기화한다. 이유 : 자신부터 1로 시작하기 때문
			dp[i] = 1;
			for ( int j = 0; j < i; j++ ) {
				// A[j]는 A[i] 보다 앞에 있어야 하며, A[i] 보다 값이 작아야한다.
				if ( A[j] < A[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			} 
		}
		
		// 초기값 대입 이후 for문에서 비교 
		int ans = dp[0];
		
		for ( int i = 0; i < N; i++ ) {
			if ( ans < dp[i] ) {
				ans = dp[i];
			}
		}
		
		System.out.println(ans);
	}
}
