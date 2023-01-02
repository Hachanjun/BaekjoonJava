package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// �Ҽ� ���ϱ� 
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
//		// true : �Ҽ� �ƴ� false : �Ҽ�
//		isPrime[0] = isPrime[1] = true;
//		
//		for ( int i = 2; i * i <= N; i++ ) {
//			
//			// �̹� üũ�� �迭�̸� �Ѿ
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
			
			//false�� �Ҽ�
			if ( !prime[i] ) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	// �����佺�׳׽��� ü �˰��� 
	public static void get_prime() {
		
		// true = �Ҽ��ƴ� fasle = �Ҽ�
		prime[0] = prime[1] = true;
		
		for ( int i = 2; i * i <= prime.length; i++ ) {
			
			// �̹� üũ�� �迭�� �������� �Ѿ��.
			if ( prime[i] == true ) {
				continue;
			}
			for ( int j = i + i; j < prime.length; j += i ) {
				prime[j] = true;
			}
		}
	}
}
