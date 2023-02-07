package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

// ��ŸƮ�� ��ũ
/*
 * N���� N/2�� �� ������ �������� �Ѵ�.(4<=N<=20, N�� ¦��)
 * �� ���� �ɷ�ġ�� ���� ����, ������ �ּڰ��� ���ϴ� ���� 
 * S[i][j] = i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ
 * ���� �ɷ�ġ : ���� ���� ��� ���� S[i][j]�� ��
 * 
 * ������ ����� 1�� ���� ���� ���, 2�� ���� ���� ��� -> ��ü ����� �� 2N���� 
 * ����� �� ����� �ɷ�ġ�� ���� ���ϸ� �ȴ�.
 * 
 * go(index, first, second)
 * index : index��° ����� � ���� ������ �����ؾ���
 * 1�� ���� 2�� ���� ���� ����� ���� first, second�� ��� ����
 * 
 * ������ ã�� ���
 * index == n
 * 
 * �Ұ����� ���
 * first�� ũ�� > n/2
 * second�� ũ�� > n/2
 * 
 * ���� ���
 * 1���� : go(index, first, second)
 * 2���� : go(index, first, second)
 * �� ��� ��� ȣ�� ���� first �Ǵ� second�� index�� �ְ� ȣ�� �Ŀ� ���� ������ �ʿ�
 */
public class Main14889 {

	public static int N;
	public static int[][] point;
	
	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ù° �ٿ� N�� �־�����.
		N = Integer.parseInt(br.readLine());
		
		// N���� �ٿ� S�� �־�����.
		point = new int[N][N];
		for ( int i = 0; i < N; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for ( int j = 0; j < N; j++ ) {				
				point[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Integer> link = new ArrayList<>(); 
		ArrayList<Integer> start = new ArrayList<>();
		System.out.println(go(0, link, start));
	}
	
	public static int go(int index, ArrayList<Integer> link, ArrayList<Integer> start) {
		
		if ( index == N ) {
			// n/2���� �´� �� Ȯ��(���� ����)
			if ( link.size() == 0 ) return -1;
			if ( start.size() == 0 ) return -1;
			// 1�� ���� �ɷ�ġ
			int linkTeam = 0;
			// 2�� ���� �ɷ�ġ
			int startTeam = 0;
			
			// ��� �ֿ� ���ؼ� ���� �ɷ�ġ�� �� ���غ���.
			for ( int i = 0; i < link.size(); i++ ) {
				for ( int j = 0; j < link.size(); j++ ) {
					if ( i == j ) continue;
					linkTeam += point[link.get(i)][link.get(j)];
				}
			}
			for ( int i = 0; i < start.size(); i++ ) {
				for ( int j = 0; j < start.size(); j++ ) {
					if ( i == j ) continue;
					startTeam += point[start.get(i)][start.get(j)];
				}
			}
			// ���̸� ���� �� ����
			int diff = Math.abs(linkTeam - startTeam);
			return diff;
		}
		
		// ���� ��� ȣ��
		int ans = -1;
		// index ��° ����� 1�� ���� �ִ� ���
		link.add(index);
		// ����Լ� ȣ��
		int linkTeam = go(index + 1, link, start);
		// �ּڰ��� ��� �� ����
		if ( ans == -1 || (linkTeam != -1 && ans > linkTeam) ) {
			ans = linkTeam;
		}
		// index�� 2�� ���� ���� �ϴϱ� ���ش�.
		link.remove(link.size() - 1);
		
		// index ��° ����� 2�� ���� �ִ� ���
		start.add(index);
		int startTeam = go(index + 1, link, start);
		if ( ans == -1 || (startTeam != -1 && ans > startTeam) ) {
			ans = startTeam;
		}
		start.remove(start.size() - 1);
		
		return ans;
	} 
}
