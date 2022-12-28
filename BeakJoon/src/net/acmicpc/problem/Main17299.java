package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 오등큰수
public class Main17299 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] temp = new int[N];
		int[] ans = new int[N];
		int[] freq = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for ( int i = 0; i < N; i++ ) {
			temp[i] = Integer.parseInt(st.nextToken());
			freq[temp[i]] += 1;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for ( int i = 0; i < N; i++ ) {
			
			if ( stack.empty() ) {
				stack.push(i);
			}
			
			while ( !stack.empty() && freq[temp[stack.peek()]] < freq[temp[i]] ) {
				ans[stack.pop()] = temp[i];
			}
			stack.push(i);
		}
		while ( !stack.empty() ) {
			ans[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for ( int i = 0; i < N; i++ ) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}
}
