package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 리모컨
/*
 * tv 채널을 로미컨을 이용해 바꾸는 문제
 * 현재 보고 있는 채널 : 100
 * 이동하려고 하는 채널이 N일때 리모컨 버튼을 누르는 횟수를 최소로 하는 문제
 * 
 * 예를들어, 5457에 이동하려면 5, 4, 5, 7을 눌러 4번만에 이동할 수 있다.
 * 만약, 숫자 버튼 7이 고장났다고 하면, 5, 4, 5, 6, + 또는 5, 4, 5, 8, -를 눌러 5번만에 이동할 수 있다.
 * 
 * 만약, 6, 7, 8이 고장났고 5457에 이동하고 싶은 경우가 있다고 하면
 * 5,4,3,5,+,+,+,5...
 * +나 -를 누르다가 숫자 버튼을 누르는 순간 그 전까지 입력한 것은 모두 의미 없어진다.
 * 
 * 최솟값을 구하는 문제에서 중복이 발생하면 최솟값을 만들 수 없다.
 * 
 * 따라서, 숫자 버튼을 누르고, 그 다음 +나 - 중 하나만 연속해서 눌러야한다.
 */
public class Main1107 {

	public static boolean[] broken = new boolean[10];
	
	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 이동하려고 하는 채널 N
		int N = Integer.parseInt(br.readLine());
		
		// 고장난 버튼의 갯수
		int cnt = Integer.parseInt(br.readLine());
		
		// 고장난 버튼이 있는 경우 고장난 버튼을 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for ( int i = 0; i < cnt; i ++ ) {
			int[] err = new int[cnt];
			err[i] = Integer.parseInt(st.nextToken());
			// 고장난 버튼은 true로 값을 설정
			broken[err[i]] = true;
		}
		
		int ans = N - 100;
		if ( ans < 0 ) {
			ans -= ans;
		}
		
		// 이동할 채널을 정한다. ( 0 ~ 500000 까지 다 이동을 해본다. )
		for ( int i = 0; i <= 500000; i++ ) { 
			// 이동을 한다는 것은 숫자 버튼만 이용해서 이동할 채널이 ch이고, ch를 결정
			int ch = i;
			int len = possible(ch);
			
			if ( len > 0 ) {
				int press = ch - N;
				if ( press < 0 ) {
					press -= press;
				}
				
				if ( ans > len + press ) {
					ans = len + press;
				}
			}
		}
		
		System.out.println(ans);
		
		/*
		 * 이 채널(ch)를 이동할 수 있는지를 검사해야 한다.
		 * 수를 10으로 계속해서 나누면서 하나씩 검사하는 방법 
		 */
		
		// 버튼이 고장나 있으며 true, 아니면 false
		/*
		 * c에 포함되어 있는 숫자 중에 고장난 버튼이 있는지 확인한다.
		 * while ( c > 0 ) {
		 * 		// broken이 true가 된다면 고장난 버튼이 있으니 이동하지 못 한다는 의미의 false
		 * 		if ( broken [c % 10] return false;
		 * 		c /= 10;
		 * }
		 * 
		 *	// 그게 아니면
		 * return true;
		 * 
		 * 반례가 있다. 모든 경우의 답을 구할 수 없다. ( 0일 경우 )
		 * if ( c == 0 ) {
		 * 		
		 * }
		 */
	}
	
	public static int possible(int ch) {
		if ( ch == 0 ) {
			if ( broken[0] ) {
				return 0;
			} else {
				return 1;
			}
		}
		
		int len = 0;
		while ( ch > 0 ) {
			if ( broken[ ch % 10 ] ) {
				return 0;
			}
			len += 1;
			ch /= 10;
		}
		
		return len;
	}
}
