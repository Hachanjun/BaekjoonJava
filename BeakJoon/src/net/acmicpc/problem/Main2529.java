package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 부등호
/*
 * 부등호 기호  < 와 >가 나열된 수열 A가 있다.
 * 기호의 앞 뒤에 한 자리 숫자를 넣어서 모든 부등호 관계를 만족시키려고 한다.
 * 이 때, 선택된 수는 모두 달라야 한다.
 * k개의 부등호 관계를 모두 만족시키는 (k+1)개 자리의 정수 중에서 최댓값과 최솟값을 구하는 문제
 * 
 * ex) A = [>, <, <, >] -> 9 > 2 < 3 < 5 > 1
 * 
 */
public class Main2529 {

	public static int k;
	public static char[] sign;
	public static ArrayList<String> ans = new ArrayList<>();
	public static boolean[] check = new boolean[10]; // 0 ~ 9
	
	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 부등호 문자의 개수를 나타내는 정수 k
		k = Integer.parseInt(br.readLine());
		
		// k개의 부등호 기호가 공백을 두고 한줄에 제시 
		sign = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < k; i++ ) {	
			sign[i] = st.nextToken().charAt(0);
		}
		
		go(0 ,"");
		
		// 최댓값, 최솟값을 출력하기 위한 정렬
		Collections.sort(ans);
		int size = ans.size();
		
		// 최댓값
		System.out.println(ans.get(size - 1));
		// 최솟값
		System.out.println(ans.get(0));
	}
	
	// index : index 번째, num : 수를 다 합쳐서 문자열로 출력해야하니 문자열로 넘기기 위해
	public static void go(int index, String num) {
		
		// 모든 수를 선택한 경우
		if ( index > k ) {
			ans.add(num);
			return;
		}
		
		// index에서 들어갈 수 있는 수는 0 ~ 9
		for ( int i = 0; i <= 9; i++ ) {
			// 앞에서 선택하지 않은 수여야 한다.
			if ( check[i] ) continue;
			
			// index가 0이면 앞에있는 수가 없는 경우, 비교할 것이 없다. (항상 가능)
			// 이전 수, 선택한 수, 부등호를 만족한 경우에만 해당 수를 사용했다고 처리
			if ( index == 0 || reference(num.charAt(index - 1), (char)(i+'0'), sign[index - 1]) ) {
				check[i] = true;
				
				// 다음 index번째 호출
				go(index + 1, num + Integer.toString(i));
				
				// 다시 넣지 않았다고 처리
				check[i] = false;
			}
		}
	}
	
	public static boolean reference(char prev, char next, char x) {
		
		if ( x == '<' ) {
			if ( prev > next ) return false;
		}
		
		if ( x == '>' ) {
			if ( prev < next ) return false;
		}
		
		return true;
	}
}
