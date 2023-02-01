package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M 3
/*
 * 1~N까지 자연수 중에 M개를 고른 수열을 모두 구하는 문제(중복 선택 가능)
 * N과 M 1에서 중복 처리했던 부분을 지워주면 된다.
 */
public class Main15651 {

	// 결과를 수열에 저장한다고 했으니 결괏값을 저장할 배열
	public static int[] num = new int[10];
	
	// 출력
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
	
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄에 자연수 N과 M이 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 제일 처음에는 0번째 수를 채워야한다.
		go(0, N, M);
		System.out.println(sb);
	}
	
	// index = index번째 수를 채운다는 의미
	public static void go(int index, int n, int m) {
		// m이 마지막 자릿수, m-1까지 채우고 m자릿수 까지 왔다면 결과를 출력(m=3이라면, 012 순으로 2번째 자리까지 채우니까)
		if ( index == m ) {
			for ( int i = 0; i < m; i++ ) {
				sb.append(num[i]);
				
				if ( i != m - 1 ) {
					sb.append(" ");
				}
			}
			sb.append('\n');
			return;
		}
		
		// 수를 추가하는 부분
		// 어떠한 index 번째 위치에 들어가야하는 수 i는 1~n까지 -> 1~n까지 하나씩 다 넣어본다.
		for ( int i = 1; i <= n; i++ ) {
			num[index] = i;
			
			// 다음 번째인 index+1로 넘어간다.
			go( index + 1, n, m);
		}
	}
}
