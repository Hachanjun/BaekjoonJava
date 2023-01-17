package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 큰 증가하는 부분 수열 
public class Main11055 {

	public static void main(String[] args) throws Exception {
		
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수열 A의 크기 
		int A = Integer.parseInt(br.readLine());
		
		// 수열 A를 이루고 있는 A[i]를 공백으로 구분하여 입력 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[A + 1];
		
		for ( int i = 0; i < A; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최대 합을 저장할 배열 메모리제이션 
		int[] dp = new int[A + 1];
		
		for ( int i = 0; i < A; i++ ) {
			dp[i] = arr[i];
			
			for ( int j = 0; j < i; j++ ) {
				// j는 i보다 앞에 있어야 하고, 증가해야 하니까 arr[j]는 arr[i] 보다 작아야한다.
				if ( arr[j] < arr[i] && dp[i] < dp[j] + arr[i] ) {
					// dp[j]는 arr[j] 앞까지의 길이
					dp[i] = dp[j] + arr[i];
				}
			}
		}
		int ans = dp[0];
		for ( int i = 0; i < A; i++ ) {
			if ( ans < dp[i] ) {
				ans = dp[i];
			}
		}
		System.out.println(ans);
	}
}
