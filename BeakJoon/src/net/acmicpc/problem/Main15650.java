package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M 2
/*
 * 1~N까지 중복없이 M개를 고른 수열을 모두 구하는 문제(오름차순)
 * ex) N=5, M=3 일 때 123 124 125 132가 아니라 134가 와야한다.
 * 
 * N과 M 1에서는 index 번째 수가 1~N중에서 앞에서 사용하지 않은 수여야 했다면,
 * N과 M 2에서는 index 번째에 num을 넣었다면, num+1 부터 N 중에서 앞에서 사용하지 않은 수여야 한다.
 * 
 * N과 M 1에서는 check[]에서 앞에서 사용한 수인지 아닌지를 판단했다면,
 * N과 M 2에서는 그럴 필요가 없다.
 * 그 이유로는 항상 어떤 수를 넣었다면 그 다음에는 num+1 부터 채우고, 다음 수는 현재 수 보다 큰 것 중에 하나를 사용하기 때문에
 * 같은 수를 여러번 쓰는 경우는 없다.
 */
public class Main15650 {

	// 수열을 만들고 출력해야하니까 결과를 저장할 배열
	public static int[] num = new int[10];
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 자연수 N과 M이 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 0번째에 올 수 있는 수는 1이기 때문에 start에 1이 와야한다.
		go(0, 1, N, M);
		System.out.println(sb);
	}
	
	// index = 몇 번째를 채운다는 의미, start = index 번째의 수를 채우려고 하는데, 가능한 수는 start~N까지
	// n개 중에서 m을 선택해야 하니까 마지막 위치는 m-1
	public static void go(int index, int start, int n, int m) {
		
		if ( index == m ) {
			for ( int i = 0; i < m; i++ ) {
				sb.append(num[i]);
				if ( i != m - 1 ) sb.append(" ");
			}
			sb.append('\n');
			return;
		}
		
		// index 번째에서 어떤 수 i를 넣었을 때, 다음 상태는 index+1이 되고 여기에 넣을 수 있는 수는 i+1~N
		for ( int i = start; i <= n; i++ ) {
			num[index] = i;
			// start는 i+1로 넘겨줘야 한다.
			go(index + 1, i + 1, n, m);
		}
	}
}
