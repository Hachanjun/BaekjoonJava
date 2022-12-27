package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ���� ���ڿ� 
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
		
		// ������ ũ��
		int cnt = 0;
		
		for ( char ch : s.toCharArray() ) {
			
			// ���� ��ȣ
			if ( ch == '(' ) {
				cnt++;
			} else if ( cnt == 0 ) { // ���� ��ȣ ����
				return "NO";
			} else { // �ݴ� ��ȣ
				cnt--;
			}
		}
		if ( cnt == 0 ) {	// ������ ����ִ� = �ùٸ� ��ȣ
			return "YES";
		} else {	// �ݴ� ��ȣ ����
			return "NO";
		}
	}
}
