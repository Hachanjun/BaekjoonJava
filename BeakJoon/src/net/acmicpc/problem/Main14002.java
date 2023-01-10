package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� �� �����ϴ� �κ� ����4 
public class Main14002 {

	// ���� A�� �̷�� �ִ� A[i]
	static int[] A;
	// ���� A�� i��° �� ������ �迭
	static int[] arrNum;
	
	public static void main(String[] args) throws Exception {
		
		// �Է� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� A�� ũ�� N
		int N = Integer.parseInt(br.readLine());
		
		A = new int[N + 1];
		
		// A[i]�� �� �Է�
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < N; i++ ) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// ���̸� ������ �迭 �޸����̼�
		int[] dp = new int[N + 1];
		
		arrNum = new int[N + 1];
		
		for ( int i = 0; i < N; i++ ) {
			// dp �ʱ�ȭ(��� ���� ó���� 1)
			dp[i] = 1;
			// arrNum �ʱ�ȭ(0 ���� �����̴ϱ� -1�� �ʱ�ȭ)
			arrNum[i] = -1;
			for ( int j = 0; j < i; j++ ) {
				// j�� i���� �տ� �־�� �ϰ�, i���� �۾ƾ��Ѵ�.
				if ( A[j] < A[i] && dp[i] < dp[j] + 1 ) {
					dp[i] = dp[j] + 1;
					arrNum[i] = j;
				}
			}
		}
		// ���� �ִ��� ����� ����, �ʱⰪ�� 1 
		int ans = dp[0];
		
		// ����Լ��� ������ int
		int num = 0;
		
		// ���� ��(ans) �� ���̰� ����Ǿ� �ִ� �迭 dp�� �� �� ū���� ans�� �ִ´�.
		for ( int i = 0; i < N; i++ ) {
			if ( ans < dp[i] ) {
				ans = dp[i];
				num = i;
			}
		}
		System.out.println(ans);
		// ����Լ� ȣ�� 
		go(num);
	}
	
	// arrNum�� ��� ������ ����ϰ�, �������� ��� A�迭�� ���� ����Ѵ�.
	public static void go(int num) {
		
		// -1�̸� Ż�� 
		if ( num == -1 )  return;
		
		// �ڽ��� ��� ȣ���ϸ鼭 arrNum[]�� ��� ������ ����Ѵ�?
		go(arrNum[num]);
		
		// ���������� A�迭�� ������ ���� ��� 
		System.out.print(A[num] + " ");
	}
}
