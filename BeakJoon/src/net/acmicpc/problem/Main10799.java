package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기
public class Main10799 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Stack<Integer> stack = new Stack<Integer>();
		int ans = 0;
		
		for ( int i = 0 ; i < str.length(); i++ ) {
			char ch = str.charAt(i);
			
			// '(' 일 경우 stack에 index push
			if ( ch == '(' ) {
				stack.push(i);
			}  else { // ')' 일 경우 
				// 인접한 '(' 일 경우 현재 남아있는 stack size 만큼 더하고 (레이저)
				if ( stack.peek() + 1 == i ) {
					stack.pop();
					ans += stack.size();
				// 떨어져 있는 경우 쇠막대기 ( 쇠막대기 하나를 레이저 하나로 자르면 두 조각 - 그래서 +1 )
				} else {
					stack.pop();
					ans += 1;
				}
			}
		}
		System.out.println(ans);
	}
}
