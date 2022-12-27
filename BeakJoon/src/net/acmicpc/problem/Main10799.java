package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// �踷���
public class Main10799 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Stack<Integer> stack = new Stack<Integer>();
		int ans = 0;
		
		for ( int i = 0 ; i < str.length(); i++ ) {
			char ch = str.charAt(i);
			
			// '(' �� ��� stack�� index push
			if ( ch == '(' ) {
				stack.push(i);
			}  else { // ')' �� ��� 
				// ������ '(' �� ��� ���� �����ִ� stack size ��ŭ ���ϰ� (������)
				if ( stack.peek() + 1 == i ) {
					stack.pop();
					ans += stack.size();
				// ������ �ִ� ��� �踷��� ( �踷��� �ϳ��� ������ �ϳ��� �ڸ��� �� ���� - �׷��� +1 )
				} else {
					stack.pop();
					ans += 1;
				}
			}
		}
		System.out.println(ans);
	}
}
