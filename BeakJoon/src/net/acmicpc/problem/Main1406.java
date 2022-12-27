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
		
		// Ŀ���� ������ �� �ڿ� ��ġ�ϰ� ������ �Է¹��� ���ڿ��� �������� �̵�
		for ( int i = 0; i < str.length(); i++ ) {
			left.push(str.charAt(i));
		}
		
		int T = Integer.parseInt(br.readLine());
		
		while ( T-- > 0 ) {
			String what = br.readLine();
			
			for ( char ch : what.toCharArray() ) {
				
				// Ŀ���� �������� �̵� > ���� stack���� ������ stack���� push
				if ( ch == 'L' ) {
					if ( !left.empty() ) {
						right.push(left.pop());
					}
				}
				
				// Ŀ���� ���������� �̵� > ������ stack���� ���� stack���� push
				else if ( ch == 'D' ) {
					if ( !right.empty() ) {
						left.push(right.pop());
					}
				}
				
				// Ŀ�� ���� ���� ����
				else if ( ch == 'B' ) {
					if ( !left.empty() ) {						
						left.pop();
					}
				}
				
				// Ŀ�� ���� ���� �߰�
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
