package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ������2 
public class Main13398 {
	
	public static void main(String[] args) throws Exception {
		
		// �Է� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� N �Է� 
		int N = Integer.parseInt(br.readLine());
		
		// N���� ������ �̷���� ���� (�������� ���еǾ� �Էµȴ�.)
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < N; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// i��°���� ������ �������� �ִ��� ���� �迭 �޸����̼�  
		int[] end = new int[N + 1];
		
		// i��°���� �����ϴ� �������� �ִ��� ���� �迭 �޸����̼� 
		int[] start = new int[N + 1];
		
		/*
		 * end[] ���ϱ�
		 * ���ʺ��� ������ i��° ���� i-1�� ���ӵǴ� �������(end[i] = end[i-1] + arr[i]) 
		 * ���ӵ��� �ʴ� ������� (end[i] = arr[i]
		 */
		for ( int i = 0; i < N; i++ ) {
			// �������� �ʴ� ��� 
			end[i] = arr[i];
			// �����ϴ� ��� 
			if ( i > 0 && end[i] < end[i - 1] + arr[i] ) {
				end[i] = end[i - 1] + arr[i];
			}
		}
		
		/*
		 * start[] ���ϱ� 
		 * ������ ���� ������ i�� i+1��° ���� ���ӵǴ� ������� (start[i] = start[i+1] + arr[i])
		 * ���ӵ��� �ʴ� ������� (start[i] = arr[i])
		 */
		for ( int i = N - 1; i >= 0; i-- ) {
			// ���ӵ��� �ʴ� ��� 
			start[i] = arr[i];
			// �����ϴ� ���
			if ( i < N - 1 && start[i] < start[i + 1] + arr[i] ) {
				start[i] = start[i + 1] + arr[i];
			}
		}
		
		// ���� �������� ���� �� �ִ�.
		int ans = end[0];
		for ( int i = 1; i < N; i++ ) {
			if ( ans < end[i] ) {
				ans = end[i];
			}
		}
		
		// �� �� ù ��° ������ N - 1��° �� ���� ������ ���� �����ϸ鼭 ������ ���Ѵ�.
		for ( int i = 1; i < N - 1; i++ ) {
			if ( ans < end[i - 1] + start[i + 1] ) {
				ans = end[i - 1] + start[i + 1];
			}
		}
		
		System.out.println(ans);
	}
}
