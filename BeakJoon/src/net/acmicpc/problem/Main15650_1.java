package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N�� M 2 ������ ���� Ǯ�� 
/*
 * M���� ���� ����� �� � ���� ���� �����ϴ� ��� 
 * ��� ������ �������� 
 * ������������ �̷���� ������ �ϳ� 
 * ex) 4 1 7 �� ���������� 1 4 7 
 * 
 * 1 ~ N ������ ���� �ִٰ� �ϸ�, M���� �� ������ 
 * ������ ���� ���Ե� ����, ���Ե��� ���� ���� �ִ�.
 * ���� �����ϰڴٰ� ������ ���� ������ ������شٸ�, N������ �ڿ��� �߿��� 
 * �ߺ����� M���� �� �Ͱ� ����.
 * 
 * ������ ���� ������ ���, �������� ���� ���� ����� �ذ� 
 * �� N���� ���� ���ؼ� ������ ���� ������ ������ �������� ���������� ���� 
 * ������ �� ���� ����(����, ������)�� �� N�� 
 */
public class Main15650_1 {

	// ����� ������ �迭 
	public static int[] num = new int[10];
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// �ڿ��� 1�� �������� ���� �����ؾ� �ϴϱ� 1 
		// ������ ���� �ƹ� �͵� ������ selected�� 0 
		go(1, 0, N, M);
		System.out.println(sb);
		
	}
	
	// index = �ڿ���, index��� ���� ����� ������ ������ �� �������� ���� 
	// selected = ���ݱ��� ������ ���� ���� 
	public static void go(int index, int selected, int n, int m) {
	
		// m���� ���������� ������ ������ ���� ���̱� ������ ������ ��� 
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
		
		// ��� ���� �������� ������ N���� ���� ��, N�� ������ �͵� �ƴϴϱ� �� ��� �� �̻� ������ ���� ������ ���� 
		if ( index > n ) return;
		
		// index�� ����� �߰� 
		// index�� ����� �߰��ϴϱ� selected�� 0���� �����Ѵٸ�, 0��°�� index�� �߰�  
		num[selected] = index;
		// index�� selected�� �߰��Ѵٰ� ����������, ���� index+1�� ���� 
		// ���� �߰������ϱ� selected+1 
		go(index + 1, selected + 1, n, m);
		
		// index�� ����� �߰� �� �� 
		// �߰����� ������ 0 
		num[selected] = 0;
		// �߰����� �����ϱ� selected ��ȭ���� 
		go(index + 1, selected, n, m);
		
		// ������ ����Ǹ� �� �ȴ�. ���������� ���϶�� �����ϱ� (1���� �����ؾ� �ϱ� ������)
	}
}
