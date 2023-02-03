package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 외판원 순회2(Traveling Salesman Problem(TSP)
/*
 * 1번 부터 N번 까지 번호가 매겨져있는 도시가 있다.
 * 한 도시에서 시작해 N개의 모든 도시를 거쳐 다시 원래 도시로 돌아오려고 한다.(한 번 갔던 도시는 다시 갈 수 없다.)
 * 이 때, 가장 적은 비용을 구하는 문제
 * 
 * 이차원 배열이 주어지는데, 갈 수 없으면 0 갈 수 있으면 비용이 들어간다.
 * 
 * 모든 도시를 거치며, 한 번 갔던 도시로는 다시 갈 수 없다라는 조건이 있기 때문에 순열로 풀 수 있다.
 * 하지만 팩토리얼으로 풀기 때문에 작을 때만 풀 수 있는데, 이 경우 N제한이 10이라 가능하다.
 * 
 * 모든 순서를 만들고 문제에 나와있는대로 비용을 계산
 */

public class Main10971 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 도시의 수 N이 주어진다.
		int N = Integer.parseInt(br.readLine());
		
		// 비용의 행렬이 주어진다.
		// W[i][j]는 도시 i에서 도시 j로 가기 위한 비용을 나타낸다.
		int[][] cost = new int[N][N];
		for ( int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for ( int j = 0; j < N; j++ ) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방문 순서를 저장할 배열, 0 ~ N-1까지 들어가있다.
		int[] order = new int[N];
		for ( int i = 0; i < N; i++ ) {
			order[i] = i;
		}
		int ans = Integer.MAX_VALUE;
		
		// 값을 계산하는 부분
		// order[0] -> order[1] -> ... -> order[N - 1] 연속하는 모든 값을 더함
		do {
			if ( order[0] != 0 ) break;
			boolean check = true;
			int sum = 0;
			
			for ( int i = 0; i < N - 1; i++ ) {
				// 0인 경우에는 갈 수 없다
				if ( cost[order[i]][order[i + 1]] == 0 ) {
					check = false;
				} else {
					sum += cost[order[i]][order[i + 1]];
				}
			}
			
			// 마지막 도시에서 첫 도시로 돌아오는 부분을 처리
			// 먼저 갈 수 있는지 없는지 확인
			if ( check && cost[order[N - 1]][order[0]] != 0 ) {
				// 올바른 경로이니 경로를 더해주고
				sum += cost[order[N - 1]][order[0]];
				// 최솟값을 구해준다.
				if ( ans > sum ) {
					ans = sum;
				}
			}
		} while( next_purmutation(order) );
		System.out.println(ans);
	}

	public static boolean next_purmutation(int[] order) {
		int standard = order.length - 1;
		
		while ( standard > 0 && order[standard - 1] >= order[standard] ) {
			standard -= 1;
		}
		
		if ( standard <= 0 ) {
			return false;
		}
		
		int next = order.length - 1;
		while ( order[next] <= order[standard - 1] ) {
			next -= 1;
		}
		
		int temp = order[standard - 1];
		order[standard - 1] = order[next];
		order[next] = temp;
		
		next = order.length - 1;
		while ( standard < next ) {
			temp = order[standard];
			order[standard] = order[next];
			order[next] = temp;
			
			standard += 1;
			next -= 1;
		}
		return true;
	}
}
