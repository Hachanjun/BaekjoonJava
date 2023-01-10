package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속합
public class Main1912 {

	public static void main(String[] args) throws Exception {
		
		// 입력받기 위해
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수 n에 입력
		int n = Integer.parseInt(br.readLine());
		
		// n개의 정수로 이루어진 수열(실제로 입력받은 수) 
		int[] num = new int[n + 1];
		
		// i번째에서 끝나는 연속합의 최댓값 
		int[] dp = new int[n + 1];
		
		// 수열에 입력 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < n; i++ ) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for ( int i = 0; i < n; i++ ) {
			// 연속하지 않은 경우
			dp[i] = num[i];
			
			// 0번째 수는 앞에 수가 없으니 건너뜀
			if ( i == 0 ) continue;
			
			// 앞에 수와 연속하는 경우 
			if ( dp[i] < dp[i - 1] + num[i] ) {
				dp[i] = dp[i - 1] + num[i];
			}
		}
		
		// 최댓값 비교할 변수 
		int max = -1;
		
		for ( int i = 0; i < n; i++ ) {
			// 비교 후 최댓값을 max에 대입 
			if ( max < dp[i] ) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
