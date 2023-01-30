package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 날짜 계산
public class Main1476 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 공백으로 구분하여 E, S, M 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 입력받은 수와 비교하기 위해, 1로 초기화 이유는 정답에는 음수가 없고, 1 1 1 은 항상 1이다.
		int e = 1;
		int s = 1;
		int m = 1;
		
		for ( int i = 1;; i++ ) {
			
			if ( e == E && s == S && m == M ) {

				System.out.println(i);
				break;
			}
			
			e += 1;
			s += 1;
			m += 1;
			
			if ( e == 16 ) e = 1;
			if ( s == 29 ) s = 1;
			if ( m == 20 ) m = 1;
		}
	}
}
