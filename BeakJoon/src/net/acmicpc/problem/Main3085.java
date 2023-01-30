package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ��������
public class Main3085 {

	// ���� ũ��
	public static char[][] board;
	
	// �Է¹��� ���� ũ�� N
	public static int N;
	
	// ���� �� �ִ� �ִ� ���� ����
	public static int max = 0;
	
	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new char[N][N];
		
		// ���� �Է¹ޱ�
		for ( int i = 0; i < N; i++ ) {
			board[i] = br.readLine().toCharArray();
		}
		
		// ���η� ������ �� ���� ��ȯ �� �ִ� ���� ���� ã�� ����ġ
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < N - 1; j++ ) {
				
				// ���η� ������ �� ���� ��ȯ
				char temp = board[i][j];
				board[i][j] = board[i][j + 1];
				board[i][j + 1] = temp;
				
				// ������ ����, ���� üũ
				arrCheck();
				
				// ������ ��ȯ�� ���� ���� (������ �� ĭ �ϳ��� ��ȯ�ؾ� �ϴϱ� �����ؾ��Ѵ�.)
				temp = board[i][j];
				board[i][j] = board[i][j + 1];
				board[i][j + 1] = temp;
			}
		}
		
		// ���η� ������ �� ���� ��ȯ �� �ִ� ���� ���� ã�� ����ġ
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < N - 1; j++ ) {
				
				// ���η� ������ �� ���� ��ȯ
				char temp = board[j][i];
				board[j][i] = board[j + 1][i];
				board[j + 1][i] = temp;
				
				// ������ ����, ���� üũ
				arrCheck();
				
				// ������ ��ȯ�� ���� ����
				temp = board[j][i];
				board[j][i] = board[j + 1][i];
				board[j + 1][i] = temp;
			}
		}
		System.out.println(max);
	}
	
	// ����, ���� ���ϸ鼭 ���� �� �ִ� ������ �ִ� ���� ã��
	public static void arrCheck() {
		
		// ���� üũ
		for ( int i = 0; i < N; i++ ) {
			/*
			 * ��� ���� 0��° ���� N-1��° ������ �ִ�.
			 * 0�� ���� �ִٰ� �ϸ� ���� 1�� �ϴ� �Ͱ� ��������
			 */
			int count = 1;
			for ( int j = 0; j < N - 1; j++ ) {
				
				// ���� ������ ������ ��� -> ��� �Դ´�.
				if ( board[i][j] == board[i][j + 1] ) {
					count++;
				}
				
				// ������ �ٸ� ������ ��� -> ���� �Ծ�� �ϹǷ� 1�� �ʱ�ȭ
				else {
					count = 1;
				}
				
				// ������ �ִ� ���� ����
				max = Math.max(max, count);
			}
		}
		
		// ���� üũ
		for ( int i = 0; i < N; i++ ) {
			int count = 1;
			for ( int j = 0; j < N - 1; j++ ) {
				if ( board[j][i] == board[j + 1][i] ) {
					count++;
				} else {
					count = 1;
				}
				
				max = Math.max(max, count);
			}
		}
	}
}
