package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M 2 선택의 관점 풀이 
/*
 * M개의 수를 출력할 때 어떤 수가 들어갈지 결정하는 방법 
 * 모든 수열은 오름차순 
 * 오름차순으로 이루어진 수열은 하나 
 * ex) 4 1 7 의 오름차순은 1 4 7 
 * 
 * 1 ~ N 까지의 수가 있다고 하면, M개를 고른 수열에 
 * 각각의 수는 포함될 수도, 포함되지 않을 수도 있다.
 * 수를 포함하겠다고 결정한 수로 수열을 만들어준다면, N까지의 자연수 중에서 
 * 중복없이 M개를 고른 것과 같다.
 * 
 * 각각의 수를 선택한 경우, 선택하지 않은 경우로 나누어서 해결 
 * 총 N개의 수에 대해서 각각의 수를 포함할 것인지 포함하지 않을것인지 결정 
 * 각각은 두 가지 선택(포함, 미포함)이 총 N번 
 */
public class Main15650_1 {

	// 결과를 저장할 배열 
	public static int[] num = new int[10];
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 자연수 1을 선택할지 말지 결정해야 하니까 1 
		// 선택한 수는 아무 것도 없으니 selected는 0 
		go(1, 0, N, M);
		System.out.println(sb);
		
	}
	
	// index = 자연수, index라는 수를 결과에 포함할 것인지 말 것인지의 역할 
	// selected = 지금까지 선택한 수의 갯수 
	public static void go(int index, int selected, int n, int m) {
	
		// m개를 선택했으면 문제의 정답을 구한 것이기 때문에 수열을 출력 
		if ( selected == m ) {
			for ( int i = 0; i < m; i++ ) {
				sb.append(num[i]);
				
				if ( i != m - 1 ) {
					sb.append(" ");
				}
			}
			sb.append('\n');
			return;
		}
		
		// 모든 수를 선택하지 않으며 N까지 갔을 때, N을 선택한 것도 아니니까 이 경우 더 이상 선택할 것이 없으니 종료 
		if ( index > n ) return;
		
		// index를 결과에 추가 
		// index를 결과에 추가하니까 selected가 0부터 시작한다면, 0번째에 index를 추가  
		num[selected] = index;
		// index를 selected에 추가한다고 결정했으니, 다음 index+1을 결정 
		// 수를 추가했으니까 selected+1 
		go(index + 1, selected + 1, n, m);
		
		// index를 결과에 추가 안 함 
		// 추가하지 않으니 0 
		num[selected] = 0;
		// 추가하지 않으니까 selected 변화없음 
		go(index + 1, selected, n, m);
		
		// 순서가 변경되면 안 된다. 사전순으로 구하라고 했으니까 (1부터 시작해야 하기 때문에)
	}
}
