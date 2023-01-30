package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 일곱난쟁이
/*
 * 아홉 명의 난쟁이 중 일곱 명의 난쟁이를 찾는 문제
 * 경우의 수 : 아홉 명 중에서 난쟁이가 아닌 두 명을 찾으면 된다.
 * 모든 아홉 명의 난쟁이 중에서 난쟁이가 아닌 두 명을 찾고 키의 합을 구하면 된다.
 */
public class Main2309 {

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 출력
		StringBuilder sb = new StringBuilder();
		
		// 난쟁이의 키를 저장할 배열
		int[] height = new int[9];
		
		// 난쟁이 키의 합을 저장
		int sum = 0;
		
		// 9개의 줄에 걸쳐 난쟁이 키가 주어지고 그 키들을 합한다.
		for ( int i = 0; i < 9; i++ ) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		
		// 키 순으로 정렬
		Arrays.sort(height);
		
		// 포함되지 않은 난쟁이 2명을 모두 다 출력
		for ( int i = 0; i < 9; i++ ) {
			for ( int j = i + 1; j < 9; j++ ) {
				// 이 부분이 포함되지 않은 2명
				if ( sum - height[i] - height[j] == 100 ) {
					
					// 키를 출력
					for ( int k = 0; k < 9; k++ ) {
						if ( k == i || k == j ) continue;
						
						sb.append(height[k]).append('\n');
					}
				}
			}
		}
		
		System.out.println(sb);
	}
}
