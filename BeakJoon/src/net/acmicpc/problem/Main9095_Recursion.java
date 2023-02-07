package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1,2,3 더하기 재귀함수 풀이
/*
 * 정수 N을 1,2,3의 합으로 나타내는 방법의 수를 구하는 문제
 * 문제의 제한은 N <= 10
 * 
 * 1,2,3만 사용할 수 있으며, N이 최대 10이니까 사용할 수 있는 수의 갯수는 최대 10개를 넘지 않는다.
 * 각각의 수는 1,2,3 중 하나 
 * 
 * 재귀함수를 만들려면 어딘가 까지의 합을 구해놓고, 마지막 수에 새로운 수를 썼을 때 합이 어떻게 변하는지를 확인하는 재귀함수
 * go(count, sum, goal) -> 숫자 count 개로 합 sum을 만드는 경우의 수
 * N = goal
 * 
 * 숫자 count개를 사용해서 계속 더해서 만들었더니 sum
 * 다음 상태(문제의 정답을 구하지 못 했을 경우)를 구하려면 새로운 수를 더해준다.
 * count -> count + 1
 * sum -> sum + 1
 * 
 * 불가능한 경우(재귀호출을 계속해도 정답을 찾을 수 없는 경우, 문제의 조건을 위배한 경우) : sum > goal(N) 만들려고 하는 수를 넘어간 경우
 * 정답을 찾은 경우 : 문제의 정답을 찾은거라 더 이상 함수 호출을 할 필요가 없을 때 -> sum == goal
 * 다음 경우 호출(위 둘 다 아닐 때) : 수 i를 다음에 사용했다고 하면,
 * -> go(count + 1, sum + i, goal)
 */
public class Main9095_Recursion {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 출력
		StringBuilder sb = new StringBuilder();
		
		// 테이스케이스
		int T = Integer.parseInt(br.readLine());
		
		for ( int i = 0; i < T; i++ ) {
			// 정수 N이 주어진다.
			int N = Integer.parseInt(br.readLine());
			
			sb.append(go(0, N)).append('\n');
		}
		System.out.println(sb);
	}
	
	public static int go(int sum, int n) {
		
		// 불가능한 경우
		if ( sum > n ) return 0;
		
		// 정답을 찾은 경우
		if ( sum == n ) return 1;
		
		// 문제의 정답을 구해지 못 했을 경우 다음 상태를 구하려면 새로운 수를 더해준다.
		int now = 0;
		for ( int i = 1; i <= 3; i++ ) {
			now += go(sum + i, n);
		}
		return now;
	}
}
