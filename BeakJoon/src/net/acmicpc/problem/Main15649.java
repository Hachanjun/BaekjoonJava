package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (재귀함수)
/*
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 모두 구하는 문제
 * 순서와 관련된 문제 -> 각각의 순서에 어떤 수가 들어가는지를 알아야 다음 수에 어떤 수를 넣어야하는지를 알 수 있다.
 * 어떤 수를 사용했고, 어떤 수를 사용하지 않았는지 파악 -> c[i] = 사용(true), 미사용(false)
 * 
 * index에 올 수 있는 수는 c[i] == false 인 수 / index에 num(숫자)를 넣었으면, 다음에는 index+1번째로 넘어간다.
 * index+1로 넘어갈 때는 num은 사용한 수니까 c[num] = true
 */
public class Main15649 {

	// 사용한 수 인지 체크할 배열
	public static boolean[] check = new boolean[10];
	
	// 수열을 실제로 만들고 출력해야 하니까 결과를 저장할 배열
	public static int[] num = new int[10];
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 자연수 N, M이 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 제일 처음에는 0번째 수를 채워야한다.
		go(0, N, M);
		System.out.println(sb);
		
	}
	
	// n,m은 입력 index = index 번째를 채우려고 한다는 의미
	// n개 중에서 m개를 선택해야 하는 것이니까 마지막 위치는 m-1
	public static void go(int index, int n, int m) {
		// m-1 번째 위치에 어떠한 수를 넣고 다음 위치로 넘어갔으면 m번째 위치는 없는 것이고 m번째 위치가 정답
		if ( index == m ) {
			for ( int i =0; i < m; i++ ) {
				sb.append(num[i]);
				if ( i != m - 1 ) sb.append(" ");
			}
			sb.append('\n');
			return;
		}
		
		// 수를 추가하는 부분
		// 어떠한 index 번째 위치에 들어가야하는 수 i는 1~n -> 그래서 1~n까지 한 번씩 넣어본다.
		for ( int i = 1; i <= n; i++ ) {
			// 중복되면 안되기 때문에 i라는 수가 사용한 적이 있으면 건너뛴다.
			if ( check[i] ) continue;
			// index 번째에 수 i를 넣음
			// 사용했으니까 i는 true
			check[i] = true;
			// 결과에도 i를 넣어준다.
			num[index] = i;
			// 다음 번째인 index + 1로 넘어간다.
			go( index + 1, n, m );
			// 재귀함수의 호출이 끝났으면 index번째에 수 i를 넣고 만들 수 있는 결과를 다 만든거니까 
			// 다시 사용하지 않은 것으로 만들어줘야 한다.
			check[i] = false;
		}
	}
}
