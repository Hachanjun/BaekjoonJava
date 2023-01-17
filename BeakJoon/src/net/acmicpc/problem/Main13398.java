package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속합2 
public class Main13398 {
	
	public static void main(String[] args) throws Exception {
		
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수 N 입력 
		int N = Integer.parseInt(br.readLine());
		
		// N개의 정수로 이루어진 수열 (공백으로 구분되어 입력된다.)
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < N; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// i번째에서 끝나는 연속합의 최댓값을 담을 배열 메모리제이션  
		int[] end = new int[N + 1];
		
		// i번째에서 시작하는 연속합의 최댓값을 담을 배열 메모리제이션 
		int[] start = new int[N + 1];
		
		/*
		 * end[] 구하기
		 * 왼쪽부터 시작해 i번째 수가 i-1과 연속되는 경우인지(end[i] = end[i-1] + arr[i]) 
		 * 연속되지 않는 경우인지 (end[i] = arr[i]
		 */
		for ( int i = 0; i < N; i++ ) {
			// 연속하지 않는 경우 
			end[i] = arr[i];
			// 연속하는 경우 
			if ( i > 0 && end[i] < end[i - 1] + arr[i] ) {
				end[i] = end[i - 1] + arr[i];
			}
		}
		
		/*
		 * start[] 구하기 
		 * 오른쪽 부터 시작해 i가 i+1번째 수와 연속되는 경우인지 (start[i] = start[i+1] + arr[i])
		 * 연속되지 않는 경우인지 (start[i] = arr[i])
		 */
		for ( int i = N - 1; i >= 0; i-- ) {
			// 연속되지 않는 경우 
			start[i] = arr[i];
			// 연속하는 경우
			if ( i < N - 1 && start[i] < start[i + 1] + arr[i] ) {
				start[i] = start[i + 1] + arr[i];
			}
		}
		
		// 수는 제거하지 않을 수 있다.
		int ans = end[0];
		for ( int i = 1; i < N; i++ ) {
			if ( ans < end[i] ) {
				ans = end[i];
			}
		}
		
		// 그 후 첫 번째 수부터 N - 1번째 수 까지 각각의 수를 제거하면서 정답을 비교한다.
		for ( int i = 1; i < N - 1; i++ ) {
			if ( ans < end[i - 1] + start[i + 1] ) {
				ans = end[i - 1] + start[i + 1];
			}
		}
		
		System.out.println(ans);
	}
}
