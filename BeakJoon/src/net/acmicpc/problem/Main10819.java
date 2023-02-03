 package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 차이를 최대로
/*
 * 수 N개가 주어졌을 때, 식의 결과를 최대로 하는 결과 
 * 제한이 8밖에 안 되며, 수의 순서만 변경할 수 있다.
 * 제한이 8이기 때문에 8 * 8! = 32만 -> 모든 경우를 다 해봐도 된다.
 * 
 * 순서를 다 만들고 식의 값을 문제에 나와있는대로 계산
 */
public class Main10819 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 3 <= N <= 8 인 N이 주어진다.
		int N = Integer.parseInt(br.readLine());
		
		// 배열에 들어있는 정수가 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] permutation = new int[N];
		for ( int i = 0; i < N; i++ ) {
			permutation[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬은 필수 
		// 다음 순열을 이용해서 모든 순열을 구하려면 모든 순열은 첫 순열 부터 시작해야한다.
		// 첫 순열은 오름차순이니까 정렬을 해줘야한다.
		Arrays.sort(permutation);
		int ans = 0;
		do {
			int temp = calculator(permutation);
			ans = Math.max(ans, temp);
		} while( next_permutation(permutation) );
		
		System.out.println(ans);
	}
	
	// 문제에 나와있는 식, 계속 인접한 것의 차이를 구한 후 절댓값을 구해준다.
	public static int calculator(int[] permutation) {
		int sum = 0;
		for ( int i = 1; i < permutation.length; i++ ) {
			sum += Math.abs(permutation[i] - permutation[i - 1]);
		}
		return sum;
	}
	
	public static boolean next_permutation(int[] permutation) {
		int standard = permutation.length - 1;
		while ( standard > 0 && permutation[standard - 1] >= permutation[standard] ) {
			standard -= 1;
		}
		
		if ( standard <= 0 ) {
			return false;
		}
		
		int next = permutation.length - 1;
		while ( permutation[next] <= permutation[standard - 1] ) {
			next -= 1;
		}
		
		int temp = permutation[standard - 1];
		permutation[standard - 1] = permutation[next];
		permutation[next] = temp;
		
		next = permutation.length - 1;
		while ( standard < next ) {
			temp = permutation[standard];
			permutation[standard] = permutation[next];
			permutation[next] = temp;
			
			standard += 1;
			next -= 1;
		}
		return true;
	}
}
