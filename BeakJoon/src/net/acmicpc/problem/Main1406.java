package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1406 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		// 커서는 문자의 맨 뒤에 위치하고 있으니 입력받은 문자열을 왼쪽으로 이동
		for ( int i = 0; i < str.length(); i++ ) {
			left.push(str.charAt(i));
		}
		
		int T = Integer.parseInt(br.readLine());
		
		while ( T-- > 0 ) {
			String what = br.readLine();
			
			for ( char ch : what.toCharArray() ) {
				
				// 커서가 왼쪽으로 이동 > 왼쪽 stack에서 오른쪽 stack으로 push
				if ( ch == 'L' ) {
					if ( !left.empty() ) {
						right.push(left.pop());
					}
				}
				
				// 커서가 오른쪽으로 이동 > 오른쪽 stack에서 왼쪽 stack으로 push
				else if ( ch == 'D' ) {
					if ( !right.empty() ) {
						left.push(right.pop());
					}
				}
				
				// 커서 기준 왼쪽 삭제
				else if ( ch == 'B' ) {
					if ( !left.empty() ) {						
						left.pop();
					}
				}
				
				// 커서 기준 왼쪽 추가
				else if ( ch == 'P' ) {
					char plus = what.charAt(2);
					left.push(plus);
				}
			}
		}
		while ( !left.empty() ) {
			right.push(left.pop());
		}
		while ( !right.empty() ) {
			sb.append(right.pop());
		}
		System.out.println(sb);
	}
}
