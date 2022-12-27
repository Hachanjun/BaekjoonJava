package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1874 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		// M : ���ÿ� �� ������ ��
		int M = 0;
		
		Stack<Integer> stack = new Stack<>();
		while ( T-- > 0 ) {
			int X = Integer.parseInt(br.readLine());
			
			if ( X > M ) {
				// �Է¹��� ���� M ���� ū ��� stack�� push
				while ( X > M )	{
					stack.push(++M);
					sb.append("+").append('\n');		
				}
				// M�� �Է°��� �������ٸ� pop
				stack.pop();
				sb.append("-").append('\n');
			
			// �Է°��� M ���� ũ�� �ʴٸ� 
			} else {
				boolean found = false;
				// stack�� ������� �ʴٸ�
				if ( !stack.empty() ) {
					// stack �ֻ�� ���� top ������ ����
					int top = stack.peek();
					stack.pop();
					sb.append("-").append('\n');
					
					// ���� �� ���� ���� �� ���� ��� ���� ��
					if ( X == top ) {
						found = true;
					}
				}
				
				if ( !found ) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println(sb);
	}
}
