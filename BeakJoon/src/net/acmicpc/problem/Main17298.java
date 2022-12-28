package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// ¿ÀÅ«¼ö
public class Main17298 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] ans = new int[N];
		String[] temp = br.readLine().split(" ");
		
		for ( int i = 0; i < N; i++ ) {
			A[i] = Integer.parseInt(temp[i]);
		}
				
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		for ( int i = 1; i < N; i++ ) {
			
			if ( stack.empty() ) {
				stack.push(i);
			}
			
			while ( !stack.empty() && A[stack.peek()] < A[i] ) {
				ans[stack.pop()] = A[i];
			}
			stack.push(i);
		}
		
		while ( !stack.empty() ) {
			ans[stack.pop()] = -1;
			
		}
		
		for ( int i = 0; i < N; i++ ) {
			sb.append(ans[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
