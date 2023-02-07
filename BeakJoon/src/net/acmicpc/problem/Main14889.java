package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 스타트와 링크
/*
 * N명을 N/2명씩 두 팀으로 나누려고 한다.(4<=N<=20, N은 짝수)
 * 두 팀의 능력치를 구한 다음, 차이의 최솟값을 구하는 문제 
 * S[i][j] = i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치
 * 팀의 능력치 : 팀에 속한 모든 쌍의 S[i][j]의 합
 * 
 * 각각의 사람이 1번 팀에 들어가는 경우, 2번 팀에 들어가는 경우 -> 전체 방법의 수 2N제곱 
 * 방법을 다 만들고 능력치의 합을 구하면 된다.
 * 
 * go(index, first, second)
 * index : index번째 사람을 어떤 팀에 넣을지 결정해야함
 * 1번 팀과 2번 팀에 속한 사람이 각각 first, second에 들어 있음
 * 
 * 정답을 찾은 경우
 * index == n
 * 
 * 불가능한 경우
 * first의 크기 > n/2
 * second의 크기 > n/2
 * 
 * 다음 경우
 * 1번팀 : go(index, first, second)
 * 2번팀 : go(index, first, second)
 * 두 경우 모두 호출 전에 first 또는 second에 index를 넣고 호출 후에 빼는 과정이 필요
 */
public class Main14889 {

	public static int N;
	public static int[][] point;
	
	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄에 N이 주어진다.
		N = Integer.parseInt(br.readLine());
		
		// N개의 줄에 S가 주어진다.
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
			// n/2명이 맞는 지 확인(문제 조건)
			if ( link.size() == 0 ) return -1;
			if ( start.size() == 0 ) return -1;
			// 1번 팀의 능력치
			int linkTeam = 0;
			// 2번 팀의 능력치
			int startTeam = 0;
			
			// 모든 쌍에 대해서 팀의 능력치를 다 구해본다.
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
			// 차이를 구한 후 리턴
			int diff = Math.abs(linkTeam - startTeam);
			return diff;
		}
		
		// 다음 경우 호출
		int ans = -1;
		// index 번째 사람을 1번 팀에 넣는 경우
		link.add(index);
		// 재귀함수 호출
		int linkTeam = go(index + 1, link, start);
		// 최솟값인 경우 값 갱싱
		if ( ans == -1 || (linkTeam != -1 && ans > linkTeam) ) {
			ans = linkTeam;
		}
		// index가 2번 팀에 들어가야 하니까 빼준다.
		link.remove(link.size() - 1);
		
		// index 번째 사람을 2번 팀에 넣는 경우
		start.add(index);
		int startTeam = go(index + 1, link, start);
		if ( ans == -1 || (startTeam != -1 && ans > startTeam) ) {
			ans = startTeam;
		}
		start.remove(start.size() - 1);
		
		return ans;
	} 
}
