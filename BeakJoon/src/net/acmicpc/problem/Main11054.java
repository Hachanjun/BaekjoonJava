package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���� �� ������� �κм���
public class Main11054 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� A�� ũ�� N
		int N = Integer.parseInt(br.readLine());
		
		// ���� A�� �̷�� �ִ� A[i]
		int[] arr = new int[N + 1];
		
		// �������� �����Ͽ� ���� A[i] �Է�
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < N; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// LIS�� ���̸� ������ �迭 �޸����̼�
		int[] lis = new int[N + 1];
		
		// LDS�� ���̸� ������ �迭 �޸����̼�
		int[] lds = new int[N + 1];
		
		// LIS 
		for ( int i = 0; i < N; i++ ) {
			lis[i] = 1;
			for ( int j = 0; j < i; j++ ) {
				if ( arr[j] < arr[i] && lis[j] + 1 > lis[i] ) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		// LDS
		/*
		 * lds[i] = arr[i] ���� �����ϴ� ���� �� �����ϴ� �κ� ���� ����
		 * arr[i] = ù ��° ��, arr[i] �ڿ��� � ���� �� �� �𸥴�.(arr[j])
		 * i ���� j�� �ڿ� �־�� �Ѵ�. i < j
		 * i ��° ���� j ��°�� �۾ƾ��Ѵ�. arr[i] > arr[j] (����)
		 * 
		 * �� ����� ��� �����ϴ� ������ �ִ�.(LIS ��� ��� x)
		 * �����̱� ������ �ڿ� �ִ� ������ ���س��� �Ѵ�.
		 * N�� ���� ���ϰ� N-1, N-2... -> N-2(3) N-1(2) N(1) (����)��
		 */
		// lds[N]�� ���ؾ� lds[N-1]�� ���ϰ�, lds[N-2]�� ���Ѵ�.
		for ( int i = N - 1; i >= 0; i-- ) {
			lds[i] = 1;
			// i + 1 �� ������ �ڿ� �ֱ� �����̴�.
			for ( int j = i + 1; j < N; j++ ) {
				// ���� �� �߿� ���� ū ���� ���Ѵ�.
				if ( arr[i] > arr[j] && lds[j] + 1 > lds[i] ) {
					lds[i] = lds[j] + 1;
				}
			}
		}
		
		int ans = 0;
		for ( int i = 0; i < N; i++ ) {
			if ( ans < lis[i] + lds[i] - 1 ) {
				ans = lis[i] + lds[i] - 1;
			}
		}
		System.out.println(ans);
	}
}
