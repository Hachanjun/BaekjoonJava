package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카잉 달력
/*
 * 건너뛰며 해보기 : 모든 경우의 수를 계산할 필요가 없다고 느껴지면, 건너뛰면서 계산
 * M,N <= 40000 -> 16억 / 1초에 1억 정도 -> 16초 (모든 경우를 계산했을 경우)
 * M,N이 주어졌을 때 해당 수 만큼(M,N) 반복된다. x,y가 주어졌을 때 몇 번째 해인지 구하는 문제
 * 
 * 나머지 연산을 통해 계산 -> 나머지 연산을 하기 위해서는 모든 수에서 -1을 해준다.
 * -> 예들들어 x = 5, N = 5일 경우 나머지를 할 경우 나머지가 5가 아닌 0이 되기 때문에 
 * 즉 0 ~ N-1을 만들기 위해
 * 
 * M이 고정된 수로 한다면, N번만 계산해주면 된다. -> 서로다른 N이 나오는 경우는 N가지 밖에 없다.
 */
public class Main6064 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 T
		int T = Integer.parseInt(br.readLine());
		
		// M, N, x, y 입력
		for ( int i = 0; i < T; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			// 문제에서 유효하지 않은 표현이면 -1을 출력하라고 했기 때문에 boolean으로 해결
			boolean ok = false;
			
			// j+=M -> M만큼씩 건너뛰면 x는 고정시킬 수 있다.
			for ( int j = x; j < M * N; j += M ) {
				if ( j % N == y ) {
					// 나머지 연산을 위해 -1 했기 때문에 +1
					sb.append(j + 1).append('\n');
					ok = true;
					break;
				} 
			}
			if ( !ok ) {
				sb.append("-1").append('\n');
			}
		}
		System.out.println(sb);
	}
}
