package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M 4
/*
 * 1부터 N까지 자연수 중에서 M개를 고른 수열을 모든 구하는 문제(중복 선택 가능, 비내림차순)
 * 비내림차순 :  11223 (같은 수가 있으며, 오름차순을 만족)
 * 
 * (순서가 기준이라면 index번째 자리에 i라는 수가 오면, index+1번째에는 i+1~N이 올 수 있어서 시작값(start)을 i+1로 넘겨줬지만,
 *  이 문제는 같은 것이 올 수 있으니(중복 허용) i~N까지이다. -> start로 넘겨주는 값이 i)
 */
public class Main15652 {

	// 결괏값을 저장할 배열 
	public static int[] num = new int[10];
	
	// 출력 
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 자연수 N과 M이 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		go(0, 1, N, M);
		System.out.println(sb);
	}
	
	public static void go(int index, int start, int n, int m) {
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
		
		// index 번째에 어떤 수 i를 넣었을 때, 다음 번째인 index+1 번째는 같은 수가 올 수 있으니
		// i~N까지 올 수 있다. 그래서 start로 넘겨주는 값이 i(중복 허용)
		for ( int i = start; i <= n; i++ ) {
			num[index] = i;
			go(index + 1, i, n, m);
		}
	}
}
