package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 수 이어쓰기 1
/*
 *  ex) N = 120
 *  1 ~ 9 		1자릿수 * (9 - 1 + 1)
 *  10 ~ 99		2자릿수 * (99 - 10 + 1)
 *  100 ~ 120	3자릿수 * (120 - 100 + 1) 
 *  -> 수의 자릿수 별로 나누어서 문제를 해결할 수 있다. -> 1 ~ N까지 수가 빠짐없이 있기 때문에 이 방식으로 풀 수 있다.
 */
public class Main1748 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long ans = 0L; 
		/*
		 * start ~ start * 10 - 1 까지 계산하는 방식
		 * start는 1 부터 10배 되기 때문에 (1, 10, 100, 1000...)
		 * end의 경우에는 (9, 99, 999, 9999...)
		 * 예외로는 가장 마지막 수가 주어진(N) 수 보다 클 경우 N으로 대입시킨다.
		 */
		for ( int start = 1, length = 1; start <= N; start *= 10, length++ ) {
			int end = start * 10 - 1;
			if ( end > N ) {
				end = N;
			}
			// 수의 길의에 수의 갯수를 곱해서 N까지 합친 수의 길이를 구할 수 있다.
			ans += (long)(end - start + 1) * length;
		}
		System.out.println(ans);
	}
}
