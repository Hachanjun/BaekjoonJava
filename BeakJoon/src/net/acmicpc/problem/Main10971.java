package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���ǿ� ��ȸ2(Traveling Salesman Problem(TSP)
/*
 * 1�� ���� N�� ���� ��ȣ�� �Ű����ִ� ���ð� �ִ�.
 * �� ���ÿ��� ������ N���� ��� ���ø� ���� �ٽ� ���� ���÷� ���ƿ����� �Ѵ�.(�� �� ���� ���ô� �ٽ� �� �� ����.)
 * �� ��, ���� ���� ����� ���ϴ� ����
 * 
 * ������ �迭�� �־����µ�, �� �� ������ 0 �� �� ������ ����� ����.
 * 
 * ��� ���ø� ��ġ��, �� �� ���� ���÷δ� �ٽ� �� �� ���ٶ�� ������ �ֱ� ������ ������ Ǯ �� �ִ�.
 * ������ ���丮������ Ǯ�� ������ ���� ���� Ǯ �� �ִµ�, �� ��� N������ 10�̶� �����ϴ�.
 * 
 * ��� ������ ����� ������ �����ִ´�� ����� ���
 */

public class Main10971 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ������ �� N�� �־�����.
		int N = Integer.parseInt(br.readLine());
		
		// ����� ����� �־�����.
		// W[i][j]�� ���� i���� ���� j�� ���� ���� ����� ��Ÿ����.
		int[][] cost = new int[N][N];
		for ( int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for ( int j = 0; j < N; j++ ) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �湮 ������ ������ �迭, 0 ~ N-1���� ���ִ�.
		int[] order = new int[N];
		for ( int i = 0; i < N; i++ ) {
			order[i] = i;
		}
		int ans = Integer.MAX_VALUE;
		
		// ���� ����ϴ� �κ�
		// order[0] -> order[1] -> ... -> order[N - 1] �����ϴ� ��� ���� ����
		do {
			if ( order[0] != 0 ) break;
			boolean check = true;
			int sum = 0;
			
			for ( int i = 0; i < N - 1; i++ ) {
				// 0�� ��쿡�� �� �� ����
				if ( cost[order[i]][order[i + 1]] == 0 ) {
					check = false;
				} else {
					sum += cost[order[i]][order[i + 1]];
				}
			}
			
			// ������ ���ÿ��� ù ���÷� ���ƿ��� �κ��� ó��
			// ���� �� �� �ִ��� ������ Ȯ��
			if ( check && cost[order[N - 1]][order[0]] != 0 ) {
				// �ùٸ� ����̴� ��θ� �����ְ�
				sum += cost[order[N - 1]][order[0]];
				// �ּڰ��� �����ش�.
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
