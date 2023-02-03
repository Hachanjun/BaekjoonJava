package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다음 순열
public class Main10972 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// N이 주어진다.
		int N = Integer.parseInt(br.readLine());
		
		// 둘째 줄에 순열이 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] permutation = new int[N];
		for ( int i = 0; i < N; i++ ) {
			permutation[i] = Integer.parseInt(st.nextToken());
		}
		
		if ( next_permutation(permutation) ) {
			for ( int i = 0; i < N; i++ ) {
				sb.append(permutation[i]).append(" ");
			}
			sb.append('\n');
		} else {
			sb.append("-1");
		}
		System.out.println(sb);
	}
	
	public static boolean next_permutation(int[] permutation) {
		
		int standard = permutation.length - 1;
		
		/*
		 * 첫 순열은 오름차순이고 마지막 순열은 내림차순
		 * 어떤 순열이 앞에 어떠한 값으로 시작하는 마지막 순열인 것을 구했으면, 그 다음 순열은 앞에서 제일 마지막인 달라지는 첫 순열이 나와야한다.
		 * 
		 * 순열은 i번째에서 부터 시작하는 내림차순이 있으니 i-1번째 까지로 시작하는 마지막 순열
		 * 이것을 찾으려면 뒤에서 부터 수를 하나씩 비교하면서 대소관계가 어긋난 순간 탐색을 종료
		 */
		while ( standard > 0 && permutation[standard - 1] >= permutation[standard] ) {
			standard -= 1;
		}
		
		// 마지막 순열, 다음 순열이 없으니까 false
		// 예를들어 마지막 순열은 7654321 
		if ( standard <= 0 ) {
			return false;
		} 
		
		// standard-1번째가 마지막 순열이니까 다음 수를 찾아야한다.
		// 다음 수는 standard-1번째 수 보다 큰 수 중 가장 작은 수여야 한다.
		int next = permutation.length - 1;
		while ( permutation[next] <= permutation[standard - 1] ) {
			next -= 1;
		}
		
		// permutation[standard - 1]과 permutation[prev]를 교환한다.
		// 마지막 순열을 새로운 순열로 만드는 작업
		// ex) 7 2 3 6 5 4 1 -> 6은 standard 3은 standard-1, 4는 prev
		// -> 7 2 4 6 5 3 1
		int temp = permutation[standard - 1];
		permutation[standard - 1] = permutation[next];
		permutation[next] = temp;
		
		next = permutation.length - 1;

		// 마지막 순열을 뒤집어준다.(첫 순열을 만드는 작업)
		// 내림차순 -> 오름차순
		// 7 2 4 6 5 3 1 -> 7 2 4 1 3 5 6
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
