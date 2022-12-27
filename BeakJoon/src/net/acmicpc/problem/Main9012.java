package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 가로 문자열 
public class Main9012 {

	public static void main(String[] args) throws Exception {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 while ( T-- > 0 ) {
			 sb.append(solve(br.readLine())).append("\n");
		 }
		 System.out.println(sb);
	}
	
	public static String solve(String s) {
		
		// 스택의 크기
		int cnt = 0;
		
		for ( char ch : s.toCharArray() ) {
			
			// 여는 괄호
			if ( ch == '(' ) {
				cnt++;
			} else if ( cnt == 0 ) { // 여는 괄호 부족
				return "NO";
			} else { // 닫는 괄호
				cnt--;
			}
		}
		if ( cnt == 0 ) {	// 스택이 비어있다 = 올바른 괄호
			return "YES";
		} else {	// 닫는 괄호 부족
			return "NO";
		}
	}
}
