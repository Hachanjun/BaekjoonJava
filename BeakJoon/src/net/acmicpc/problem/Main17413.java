package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 단어뒤집기2
public class Main17413 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();

		
		// 어떤 문자열이 현재 < 를 처리하고 있는지 아닌지를 의미
		// tag인지 아닌지 모르고 현재 tag가 아니기 때문에 false
		boolean tag = false;
		String S = br.readLine();
		
		for ( char ch : S.toCharArray() ) {
			/*
			 * '<'의 경우는 2가지 
			 * 1. 진짜 문자열의 시작
			 * 2. 다른 단어가 나오고 '<'가 나온 경우
			 * 두 경우 모두 지금까지 나온 단어를 출력해야한다.
			 * 1의 경우에는 아무 것도 출력할 것이 없을 것이고 2의 경우에는 앞의 단어를 출
			 */
			if ( ch == '<' ) {
				print(stack);
				tag = true;
				sb.append(ch);
			/*
			 * '>' 가 나온 경우 tag = false 출력할 것은 '>' 것 뿐 
			 */
			} else if ( ch == '>') {
				tag = false;
				sb.append(ch);

			// 그대로 출력 
			} else if ( tag ) {
				sb.append(ch);
			} else {		// 단어 뒤집기와 동일 
				 if ( ch == ' ' ) {
					 print(stack);
					 sb.append(ch);
				 } else {	// 공백이 아니니까 스택에 추가
					 stack.push(ch);
				 }
			}
		}
		// 스택이 비어있지 않을 수가 있기 때문에 한 번 더 출력 
		print(stack);
		sb.append('\n');
		System.out.println(sb); 
	}
	
	public static void print(Stack<Character> stack) {
		while ( !stack.empty() ) {
			sb.append(stack.pop());
		}
	}
}
