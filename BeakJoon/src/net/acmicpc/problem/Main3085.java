package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 사탕게임
public class Main3085 {

	// 보드 크기
	public static char[][] board;
	
	// 입력받은 보드 크기 N
	public static int N;
	
	// 먹을 수 있는 최대 사탕 갯수
	public static int max = 0;
	
	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new char[N][N];
		
		// 사탕 입력받기
		for ( int i = 0; i < N; i++ ) {
			board[i] = br.readLine().toCharArray();
		}
		
		// 가로로 인접한 두 사탕 교환 및 최대 사탕 갯수 찾고 원위치
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < N - 1; j++ ) {
				
				// 가로로 인접한 두 문자 교환
				char temp = board[i][j];
				board[i][j] = board[i][j + 1];
				board[i][j + 1] = temp;
				
				// 인접한 가로, 세로 체크
				arrCheck();
				
				// 이전에 교환한 문자 복구 (인접한 두 칸 하나만 교환해야 하니까 복구해야한다.)
				temp = board[i][j];
				board[i][j] = board[i][j + 1];
				board[i][j + 1] = temp;
			}
		}
		
		// 세로로 인접한 두 사탕 교환 및 최대 사탕 갯수 찾고 원위치
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < N - 1; j++ ) {
				
				// 세로로 인접한 두 문자 교환
				char temp = board[j][i];
				board[j][i] = board[j + 1][i];
				board[j + 1][i] = temp;
				
				// 인접한 가로, 세로 체크
				arrCheck();
				
				// 이전에 교환한 문자 복구
				temp = board[j][i];
				board[j][i] = board[j + 1][i];
				board[j + 1][i] = temp;
			}
		}
		System.out.println(max);
	}
	
	// 가로, 세로 비교하면서 먹을 수 있는 사탕의 최대 갯수 찾기
	public static void arrCheck() {
		
		// 가로 체크
		for ( int i = 0; i < N; i++ ) {
			/*
			 * 모든 행은 0번째 부터 N-1번째 열까지 있다.
			 * 0번 열만 있다고 하면 연속 1만 하는 것과 마찬가지
			 */
			int count = 1;
			for ( int j = 0; j < N - 1; j++ ) {
				
				// 이전 사탕과 동일한 경우 -> 계속 먹는다.
				if ( board[i][j] == board[i][j + 1] ) {
					count++;
				}
				
				// 이전과 다른 사탕인 경우 -> 새로 먹어야 하므로 1로 초기화
				else {
					count = 1;
				}
				
				// 사탕의 최대 갯수 저장
				max = Math.max(max, count);
			}
		}
		
		// 세로 체크
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
