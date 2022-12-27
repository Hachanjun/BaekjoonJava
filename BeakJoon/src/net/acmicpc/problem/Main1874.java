package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1874 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		// M : 스택에 들어간 마지막 수
		int M = 0;
		
		Stack<Integer> stack = new Stack<>();
		while ( T-- > 0 ) {
			int X = Integer.parseInt(br.readLine());
			
			if ( X > M ) {
				// 입력받은 값이 M 보다 큰 경우 stack에 push
				while ( X > M )	{
					stack.push(++M);
					sb.append("+").append('\n');		
				}
				// M과 입력값이 같아진다면 pop
				stack.pop();
				sb.append("-").append('\n');
			
			// 입력값이 M 보다 크지 않다면 
			} else {
				boolean found = false;
				// stack이 비어있지 않다면
				if ( !stack.empty() ) {
					// stack 최상단 값을 top 변수에 복사
					int top = stack.peek();
					stack.pop();
					sb.append("-").append('\n');
					
					// 실제 그 수가 나올 때 까지 계속 빼는 것
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
