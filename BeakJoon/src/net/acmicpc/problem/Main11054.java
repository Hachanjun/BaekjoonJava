package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 바이토닉 부분수열
public class Main11054 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수열 A의 크기 N
		int N = Integer.parseInt(br.readLine());
		
		// 수열 A를 이루고 있는 A[i]
		int[] arr = new int[N + 1];
		
		// 공백으로 구분하여 수열 A[i] 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < N; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// LIS의 길이를 저장할 배열 메모리제이션
		int[] lis = new int[N + 1];
		
		// LDS의 길이를 저장할 배열 메모리제이션
		int[] lds = new int[N + 1];
		
		// LIS 
		for ( int i = 0; i < N; i++ ) {
			lis[i] = 1;
			for ( int j = 0; j < i; j++ ) {
				if ( arr[j] < arr[i] && lis[j] + 1 > lis[i] ) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		// LDS
		/*
		 * lds[i] = arr[i] 에서 시작하는 가장 긴 감소하는 부분 수열 길이
		 * arr[i] = 첫 번째 수, arr[i] 뒤에는 어떤 수가 올 지 모른다.(arr[j])
		 * i 보다 j가 뒤에 있어야 한다. i < j
		 * i 번째 보다 j 번째는 작아야한다. arr[i] > arr[j] (감소)
		 * 
		 * 이 방법의 경우 시작하는 조건이 있다.(LIS 방법 사용 x)
		 * 시작이기 때문에 뒤에 있는 정보를 구해놔야 한다.
		 * N을 먼저 구하고 N-1, N-2... -> N-2(3) N-1(2) N(1) (숫자)순
		 */
		// lds[N]을 구해야 lds[N-1]을 구하고, lds[N-2]를 구한다.
		for ( int i = N - 1; i >= 0; i-- ) {
			lds[i] = 1;
			// i + 1 인 이유는 뒤에 있기 때문이다.
			for ( int j = i + 1; j < N; j++ ) {
				// 작은 수 중에 가장 큰 값을 구한다.
				if ( arr[i] > arr[j] && lds[j] + 1 > lds[i] ) {
					lds[i] = lds[j] + 1;
				}
			}
		}
		
		int ans = 0;
		for ( int i = 0; i < N; i++ ) {
			if ( ans < lis[i] + lds[i] - 1 ) {
				ans = lis[i] + lds[i] - 1;
			}
		}
		System.out.println(ans);
	}
}
