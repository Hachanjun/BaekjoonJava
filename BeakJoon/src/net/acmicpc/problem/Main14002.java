package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열4 
public class Main14002 {

	// 수열 A를 이루고 있는 A[i]
	static int[] A;
	// 수열 A의 i번째 를 저장할 배열
	static int[] arrNum;
	
	public static void main(String[] args) throws Exception {
		
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수열 A의 크기 N
		int N = Integer.parseInt(br.readLine());
		
		A = new int[N + 1];
		
		// A[i]에 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < N; i++ ) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 길이를 저장할 배열 메모리제이션
		int[] dp = new int[N + 1];
		
		arrNum = new int[N + 1];
		
		for ( int i = 0; i < N; i++ ) {
			// dp 초기화(모든 수는 처음에 1)
			dp[i] = 1;
			// arrNum 초기화(0 부터 시작이니까 -1로 초기화)
			arrNum[i] = -1;
			for ( int j = 0; j < i; j++ ) {
				// j는 i보다 앞에 있어야 하고, i보다 작아야한다.
				if ( A[j] < A[i] && dp[i] < dp[j] + 1 ) {
					dp[i] = dp[j] + 1;
					arrNum[i] = j;
				}
			}
		}
		// 길이 최댓값을 출력할 변수, 초기값은 1 
		int ans = dp[0];
		
		// 재귀함수에 전달할 int
		int num = 0;
		
		// 현재 값(ans) 와 길이가 저장되어 있는 배열 dp와 비교 후 큰값을 ans에 넣는다.
		for ( int i = 0; i < N; i++ ) {
			if ( ans < dp[i] ) {
				ans = dp[i];
				num = i;
			}
		}
		System.out.println(ans);
		// 재귀함수 호출 
		go(num);
	}
	
	// arrNum에 담긴 값들을 출력하고, 마지막에 담긴 A배열의 값을 출력한다.
	public static void go(int num) {
		
		// -1이면 탈출 
		if ( num == -1 )  return;
		
		// 자신을 계속 호출하면서 arrNum[]에 담긴 값들을 출력한다?
		go(arrNum[num]);
		
		// 최종적으로 A배열의 마지막 값을 출력 
		System.out.print(A[num] + " ");
	}
}
