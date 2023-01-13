package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 동물원
/*
 * 가로, 세로 붙어 있게 배치하면 안 된다. 가능한 배치의 수
 * 세로가 N칸 가로가 두 칸, 각각의 가로에 대해서 동물을 놓을 수 있는 방법을 구한다.
 * 칸이 하나일 경우 동물을 아무 것도 놓지 않는 방법 0
 * 한 쪽에만 놓는 것 1(왼), 2(오)
 * 양쪽에 놓는 것은 불가능 -> 가로 세로 붙어 있게 배치하면 안 된다.
 * 
 * 점화식
 * D[N][0] = N번 줄에 배치하지 않음.
 * D[N][1] = N번 줄의 왼쪽에만 배치함
 * D[N][2] = N번 줄의 오른쪽에만 배치함
 * 
 * 각각의 경우마다 앞에 올 수 있는 것이 무엇인지 알아야한다.
 * N이 0번일 경우 바로 위에는 N-1
 * 0번의 위에는 0,1,2 모두 올 수 있다. -> 어차피 0번은 동물이 없으니 모든 경우가 올 수 있다.
 * 1번의 위에는 0,2 -> 1번 위에 1번이 오면 세로가 붙어있게 된다.
 * 2번의 위에는 0,1
 * 
 * D[N][0] = D[N-1][0] + D[N-1][1] + D[N-1][2] -> N번 줄에 0번 방법을 사용했으면 N-1에는 0,1,2번이 올 수 있다.
 * D[N][1] = D[N-1][0] + D[N-1][2] -> 1번을 사용한 경우에는 0,2번이 올 수 있다.
 * D[N][2] = D[N-1][0] + D[N-1][1] -> 2번을 사용한 경우에는 0,1번이 올 수 있다.
 */
public class Main1309 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 우리의 크기 N
		int N = Integer.parseInt(br.readLine());
		
		// 나누는 값
		int mod = 9901;
		
		// 경우의 수를 저장할 배열 메모리제이션
		int[][] dp = new int[N + 1][3];
		
		// 초기화 동물이 없을 수도 있으니 방법으로 친다.
		dp[0][0] = 1;
		
		for ( int i = 1; i <= N; i++ ) {
			//N번 줄에 0번 방법을 사용했으면 N-1에는 0,1,2번이 올 수 있다.
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
			// 1번을 사용한 경우에는 0,2번이 올 수 있다.
			dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
			//2번을 사용한 경우에는 0,1번이 올 수 있다.
			dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
			
			// 나누기
			for ( int j =0; j < 3; j++ ) {
				dp[i][j] %= mod;
			}
		}
		System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % mod);
	}
}
