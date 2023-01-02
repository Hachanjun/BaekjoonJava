package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 구하기 
public class Main1929 {

//	public static void main(String[] args) throws Exception { 
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		
//		int M = Integer.parseInt(st.nextToken());
//		int N = Integer.parseInt(st.nextToken());
//		
//		boolean[] isPrime = new boolean[N + 1];
//		
//		// true : 소수 아님 false : 소수
//		isPrime[0] = isPrime[1] = true;
//		
//		for ( int i = 2; i * i <= N; i++ ) {
//			
//			// 이미 체크된 배열이면 넘어간
//			if ( isPrime[i] == true ) {
//				continue;
//			} 
//			for ( int j = i + i; j <= N; j += i ) {
//				isPrime[j] = true;
//			}
//		}
//		for ( int i = M; i <= N; i++ ) {
//			if ( isPrime[i] == false ) {
//				sb.append(i).append('\n');
//			}
//		}
//		System.out.println(sb);
//	}
	
	public static boolean[] prime;
	
	public static void main(String[] args) throws Exception { 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		prime = new boolean[N + 1];
		get_prime();
		
		for ( int i = M; i <= N; i++ ) {
			
			//false는 소수
			if ( !prime[i] ) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	// 에라토스테네스의 체 알고리즘 
	public static void get_prime() {
		
		// true = 소수아님 fasle = 소수
		prime[0] = prime[1] = true;
		
		for ( int i = 2; i * i <= prime.length; i++ ) {
			
			// 이미 체크된 배열은 다음으로 넘어간다.
			if ( prime[i] == true ) {
				continue;
			}
			for ( int j = i + i; j < prime.length; j += i ) {
				prime[j] = true;
			}
		}
	}
}
