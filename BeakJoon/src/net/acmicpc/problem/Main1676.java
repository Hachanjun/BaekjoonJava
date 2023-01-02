package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1676 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while ( num >= 5 ) {
			cnt += num / 5;
			num /= 5;
		}
		System.out.println(cnt);
	}
}
