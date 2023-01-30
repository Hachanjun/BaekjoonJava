package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// �ϰ�������
/*
 * ��ȩ ���� ������ �� �ϰ� ���� �����̸� ã�� ����
 * ����� �� : ��ȩ �� �߿��� �����̰� �ƴ� �� ���� ã���� �ȴ�.
 * ��� ��ȩ ���� ������ �߿��� �����̰� �ƴ� �� ���� ã�� Ű�� ���� ���ϸ� �ȴ�.
 */
public class Main2309 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���
		StringBuilder sb = new StringBuilder();
		
		// �������� Ű�� ������ �迭
		int[] height = new int[9];
		
		// ������ Ű�� ���� ����
		int sum = 0;
		
		// 9���� �ٿ� ���� ������ Ű�� �־����� �� Ű���� ���Ѵ�.
		for ( int i = 0; i < 9; i++ ) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		
		// Ű ������ ����
		Arrays.sort(height);
		
		// ���Ե��� ���� ������ 2���� ��� �� ���
		for ( int i = 0; i < 9; i++ ) {
			for ( int j = i + 1; j < 9; j++ ) {
				// �� �κ��� ���Ե��� ���� 2��
				if ( sum - height[i] - height[j] == 100 ) {
					
					// Ű�� ���
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
