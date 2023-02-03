package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


// 로또
/*
 * 입력으로 주어진 K개의 수 중에서 6개의 수를 고르느 문제
 * 
 * K개의 수 중에서 6개를 고르는 것은 순서의 관점이 아닌 선택의 관점이다.
 * 하지만 순서 문제를 이용해서 선택 문제를 해결할 수 있다.
 * 
 * 그 이유는 같은 수가 있어도 문제없이 나오기 때문이다.
 * K개 중의 6개 수를 고르라고 했으니, 고르는 것을 1 안 고른 것을 0 
 * 고름(1)이 * 6개, 고르지 않음(0) * K-6개 
 * 위를 이용해 전체 순열을 만든다.
 */
public class Main6603 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 출력
		StringBuilder sb = new StringBuilder();
		
		// 각 테스트 케이스는 한 줄로 이루어져 있다.
		while ( true ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 테스트 케이스
			int testCase = Integer.parseInt(st.nextToken());
			if ( testCase == 0 ) break;
			
			// 테스트 케이스의 수 만큼 배열에 수를 저장
			int[] arr = new int[testCase];
			for ( int i = 0; i < testCase; i++ ) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 선택의 결과(고름, 안 고름)를 저장할 배열
			int[] select = new int[testCase];
			
			// 골라야하는 수가 6개 이니까 고르지 않은 수는 testCase - 6
			for ( int i = 0; i < testCase; i++ ) {
				if ( i < testCase - 6 )	{
					select[i] = 0;
				} else {
					select[i] = 1;
				}
			}
			
			ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
			do {
				ArrayList<Integer> current = new ArrayList<>();
				for ( int i = 0; i < testCase; i++ ) {
					if ( select[i] == 1 ) {
						current.add(arr[i]);
					}
				}
				ans.add(current);
			} while ( next_permutation(select) );
			Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
				public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
					int n = l1.size();
					int m = l2.size();
					int i = 0;

					while (i < n && i < m) {
						int t1 = l1.get(i);
						int t2 = l2.get(i);
						if (t1 < t2) {
							return -1;
						} else if ( t1 > t2 ) {
							return 1;
						} else {							
							i += 1;
						}
					}

					if (i == n && i != m) {
						return -1;
					} else if (i != n && i == m) {
						return 1;
					} else {
						return 0;
					}
				}
			});
			for (ArrayList<Integer> v : ans) {
				for (int x : v) {
					sb.append(x).append(" ");
				}
				sb.append('\n');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	public static boolean next_permutation(int[] select) {
		int standard = select.length - 1;
		while ( standard > 0 && select[standard - 1] >= select[standard] ) {
			standard -= 1;
		}
		
		if ( standard <= 0 ) {
			return false;
		}
		
		int next = select.length - 1;
		while ( select[next] <= select[standard - 1] ) {
			next -= 1;
		}
		
		int temp = select[standard - 1];
		select[standard - 1] = select[next];
		select[next] = temp;
		
		next = select.length - 1;
		while ( standard < next ) {
			temp = select[standard];
			select[standard] = select[next];
			select[next] = temp;
			
			standard += 1;
			next -= 1;
		}
		return true;
	}
}
