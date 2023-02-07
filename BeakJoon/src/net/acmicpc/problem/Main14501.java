package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사
/*
 * N+1일이 되는 날 퇴사하려고한다.(1<=N<=15)
 * 남은 N일 동안 최대한 많은 상담을 하려고 한다.
 * 하루에 하나의 상담을 할 수 있고, i일에 상담을 하면 T[i]일이 걸리고 P[i]원을 번다.
 * 
 * ex) N = 5 일 경우
 * 		1	2	3	4	5	6(퇴사)
 * T	3	1	2	2	100
 * P	2	5	3	3	10억
 * 
 * 가장 많은 돈을 벌려면 5인 10억을 벌면 되지만 이 돈을 벌기 위해선 100일을 더 일해야한다.
 * 문제 조건에서 N+1일 이 되는 날 퇴사를 한다고 했으니 해당 돈은 벌 수 없다.
 * 
 * 문제의 조건
 * - 하루에 하나의 상담을 할 수 있다 : 각각의 날짜마다 어떠한 상담을 할지 말지 결정한다.
 * 
 * 각각의 날짜에 있는 상담을 하는 경우와 하지 않는 경우로 나눈다.
 * go(day, sum)
 * day : day일이 되었다. day일에 있는 상담을 할지 말지 결정해야 한다.
 * sum : 지금까지 얻은 수익
 * 
 * 정답을 찾은 경우 : day == N+1 -> 지금까지 상담을 한 총 수익과  지금까지 구한 정답의 최댓값을 비교 후 최댓값을 구한다.
 * 불가능한 경우 : day > N+1 날짜가 넘어간 경우
 * 다음 경우 호출
 * - 상담을 하는 경우 : go(day + T[day], sum+P[day])
 * -> N = 1인 경우 상담을 하게 되면 3일을 그 상담만 해야하니 2,3일의 상담은 할 수 없다. 1일에 상담을 했다면 4일로 넘어가야 한다.
 * - 상담을 하지 않는 경우  : go(day+1, sum)
 * -> 해당일에 상담을 하지 않았다면, 다음 날로 넘어가고 상담을 하지 않았으니 수익은 변함이 없다.
 */
public class Main14501 {

	public static int N;
	public static int[] term;
	public static int[] price;
	public static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄에 N이 주어진다.
		N = Integer.parseInt(br.readLine());
		
		// T(기간), P(금액)이 주어진다.
		term = new int[N + 1];
		price = new int[N + 1];
		for ( int i = 1; i <= N; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			term[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		// 첫째 날 부터 할지 말지 결정해야하니까 1, 합계된 금액이 아직 없으니 0
		go(1, 0);
		System.out.println(ans);
	}
	
	public static void go(int day, int sum)	{
		
		// 정답을 찾은 경우
		if ( day == N + 1 ) {
			if ( ans < sum ) {
				ans = sum;
			}
			return;
		}
		
		// 불가능한 경우
		if ( day > N + 1 ) {
			return;
		}
		
		// 상담을 하지 않는 경우
		go(day + 1, sum);
		// 상담을 하는 경우
		go(day + term[day], sum + price[day]);
	}
}
