package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스티커
/*
 * 점수의 합을 최대로 만들기 위해서 큰 수 부터 선택하는 방법이 최대가 될 것 같으나 실제로는 그렇지 않다.
 * 이유는 큰 수 부터 선택하면 문제의 정답을 잘 못 구한다. 
 * 변을 공유하는 스티커가 모두 찢어지기 때문에 
 */
public class Main9465 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 T
		int T = Integer.parseInt(br.readLine());

		for ( int i = 0; i < T; i++) {
			// 카드 점수 n열 갯수
			int N = Integer.parseInt(br.readLine());
			
			// 카드 점수가 저장될 2행 N열 
			long[][] card = new long[N + 1][2];
			
			// 카드 점수를 공백으로 구분하여 입력 
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for ( int j = 1; j <= N; j++ ) {
				card[j][0] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for ( int j = 1; j <= N; j++ ) {
				card[j][1] = Integer.parseInt(st.nextToken());
			}
			
			// 최댓값을 저장할 배열 메모리제이션 
			long[][] dp = new long[N + 1][3];
			/*
			 * 0 = 뜯지않음, 1 = 위쪽 스티커 뜯음, 2 = 아래쪽 스티커 뜯음 
			 */
			for ( int j = 1; j <= N; j++ ) {
				// i - 1 열에서 스티커를 어떻게 뜯었는지 상관 없음 
				dp[j][0] = Math.max(dp[j - 1][0], Math.max(dp[j - 1][1], dp[j - 1][2]));
				// i - 1 열에서 위쪽 스티커를 뜯으면 안 된다 
				dp[j][1] = Math.max(dp[j - 1][0], dp[j - 1][2]) + card[j][0];
				// i - 1 열에서 아래쪽 스티커를 뜯으면 안 된다 
				dp[j][2] = Math.max(dp[j - 1][0], dp[j - 1][1]) + card[j][1];
			}
			long ans = 0;
			ans = Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]));
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
