package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// �ܾ������2
public class Main17413 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();

		
		// � ���ڿ��� ���� < �� ó���ϰ� �ִ��� �ƴ����� �ǹ�
		// tag���� �ƴ��� �𸣰� ���� tag�� �ƴϱ� ������ false
		boolean tag = false;
		String S = br.readLine();
		
		for ( char ch : S.toCharArray() ) {
			/*
			 * '<'�� ���� 2���� 
			 * 1. ��¥ ���ڿ��� ����
			 * 2. �ٸ� �ܾ ������ '<'�� ���� ���
			 * �� ��� ��� ���ݱ��� ���� �ܾ ����ؾ��Ѵ�.
			 * 1�� ��쿡�� �ƹ� �͵� ����� ���� ���� ���̰� 2�� ��쿡�� ���� �ܾ ��
			 */
			if ( ch == '<' ) {
				print(stack);
				tag = true;
				sb.append(ch);
			/*
			 * '>' �� ���� ��� tag = false ����� ���� '>' �� �� 
			 */
			} else if ( ch == '>') {
				tag = false;
				sb.append(ch);

			// �״�� ��� 
			} else if ( tag ) {
				sb.append(ch);
			} else {		// �ܾ� ������� ���� 
				 if ( ch == ' ' ) {
					 print(stack);
					 sb.append(ch);
				 } else {	// ������ �ƴϴϱ� ���ÿ� �߰�
					 stack.push(ch);
				 }
			}
		}
		// ������ ������� ���� ���� �ֱ� ������ �� �� �� ��� 
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
