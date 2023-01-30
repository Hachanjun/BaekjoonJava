package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 동물원 - 1차원 다이나믹으로 해결하는 방법
/*
 * 이전 점화식
 * D[N][0] = N번 줄에 배치하지 않음.
 * D[N][1] = N번 줄의 왼쪽에만 배치함
 * D[N][2] = N번 줄의 오른쪽에만 배치함
 * 
 * 이번에는 동물을 안 놓는 경우를 처리하지 않고 해결 죽, 동물을 놓지 않는 방법은 점화식에서 제외
 * i번째 줄의 이전에 동물이 있는 줄은 어디일까? 알 수 없다.(변수 처리 ex) i-1, i-2..)
 * 동물을 i-1번째 줄에 놓을 수도 있고, i-2, i-3..2, 1 일 수도 있다.
 * 동물을 붙어있게 배치 할 수 없다는 조건이 있으므로,
 * i번째 왼쪽에 동물을 놓은 경우 i-1 줄에는 오른쪽에 놓는 것만 하능하나, 
 * 만약 i-1번째 줄에 동물을 놓지 않고 i-2번째 줄이 이전 줄이라고 한다면, 동물을 어떻게 놔도 문제가 되지 않는다.
 * 
 * 동물을 놓지 않는 방법을 다이나믹에서 건너뛰는 방식으로 처리
 * 
 */
public class Main1309_1 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 우리의 크기 N
		int N = Integer.parseInt(br.readLine());
		
		// 나눌 값
		int mod = 9901;
		
		// 경우의 수를 저장할 배열 메모리제이션
		int[] dp = new int[N + 1];
		
		// 경우의 수들의 합을 저장할 배열 메모리제이션
		int[] sum = new int[N + 1];
		
		
	}
}
