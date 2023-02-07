package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암호만들기
/*
 * 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음과 최소 두 개의 자음으로 구성
 * 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열
 * 암호로 사용할 수 있는 문자의 종류는 C가지
 * 가능성있는 암호를 모두 구하는 문제
 * 
 * 문제의 제한 : 3<=L<=C<=15
 * 암호는 서로 다른 L개의 알파벳 소문자로 구성되며, C가지 중에서 어떤 알파벳이 등장하거나 등장하지 않거나 둘 중 하나 
 * 
 * 조건
 * - 증가하는 순서로 배열(알파벳을 정렬 - 정렬된 순서를 유지하면서 암호에 포함시킬지 말지 선택)
 * - 최소 한 개의 모음과 최소 두 개의 자음으로 구성
 * 
 * go(n, alpha, password, i)
 * - n : 입력받는 수, 만들어야 하는 암호의 길이
 * - alpha : 입력받는 수, 사용할 수 있는 알파벳(배열)
 * - password : 현재까지 만든 암호
 * - i : 사용할지 말지 결정해야하는 알파벳의 인덱스
 * 
 * 정답을 찾은 경우 : password의 길이 == n
 * 불가능한 경우(더 이상 선택할 수 있는 알파벳이 없는 경우) : i >= alpha
 * 다음 경우(index i번째의 알파벳을 사용할 수도, 사용하지 않을 수도 있다.)
 * - i번째 알파벳을 사용하는 경우 : go(n, alpha, password+alpha[i], i+1)
 * - i번째 알파벳을 사용하지 않는 경우 : go(n, alpha, password, i+1)
 * 
 * 최소 한 개의 모음과 최소 두 개의 자음으로 구성 조건 처리
 * 
 */
public class Main1759 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄에 두 수 L,C가 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		// 주어지는 알파벳을 저장할 배열
		String[] alpha = new String[C];
		st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < C; i++ ) {
			alpha[i] = st.nextToken();
		}
		
		// 증가하는 순서로 배열하기 때문에 정렬을 해준다.
		Arrays.sort(alpha);
		
		go(L, alpha, "", 0);
	}
	
	public static void go(int L, String[] alpha, String password, int index) {
		
		StringBuilder sb = new StringBuilder();
		
		// 정답을 찾은 경우
		if ( password.length() == L ) {
			if ( check(password) ) {
				sb.append(password).append('\n');
			}
			System.out.print(sb);
			return;
		}
		
		// 불가능한 경우
		if ( index >= alpha.length ) {
			return;
		}
		
		// 다음 경우(index i번째의 알파벳을 사용할 수도, 사용하지 않을 수도 있다.)
		// i번째 알파벳을 사용하는 경우
		go(L, alpha, password + alpha[index], index + 1);
		// i번째 알파벳을 사용하지 않는 경우
		go(L, alpha, password, index + 1);
		
	}
	
	// 최소 한 개의 모음과 두 개의 자음 조건 처리 
	public static boolean check(String password) {
		
		int ja = 0;
		int mo = 0;
		for ( char x : password.toCharArray() ) {
			if ( x =='a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' ) {
				mo += 1;
			} else {
				ja += 1;
			}
		}
		// 최소 한 개의 모음과 최소 두 개의 자음으로 구성
		return ja >= 2 && mo >= 1;
	}
}
