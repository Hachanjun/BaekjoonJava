package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


// �ζ�
/*
 * �Է����� �־��� K���� �� �߿��� 6���� ���� ���� ����
 * 
 * K���� �� �߿��� 6���� ���� ���� ������ ������ �ƴ� ������ �����̴�.
 * ������ ���� ������ �̿��ؼ� ���� ������ �ذ��� �� �ִ�.
 * 
 * �� ������ ���� ���� �־ �������� ������ �����̴�.
 * K�� ���� 6�� ���� ����� ������, ���� ���� 1 �� �� ���� 0 
 * ��(1)�� * 6��, ���� ����(0) * K-6�� 
 * ���� �̿��� ��ü ������ �����.
 */
public class Main6603 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���
		StringBuilder sb = new StringBuilder();
		
		// �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ִ�.
		while ( true ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// �׽�Ʈ ���̽�
			int testCase = Integer.parseInt(st.nextToken());
			if ( testCase == 0 ) break;
			
			// �׽�Ʈ ���̽��� �� ��ŭ �迭�� ���� ����
			int[] arr = new int[testCase];
			for ( int i = 0; i < testCase; i++ ) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// ������ ���(��, �� ��)�� ������ �迭
			int[] select = new int[testCase];
			
			// �����ϴ� ���� 6�� �̴ϱ� ���� ���� ���� testCase - 6
			for ( int i = 0; i < testCase; i++ ) {
				if ( i < testCase - 6 )	{
					select[i] = 0;
				} else {
					select[i] = 1;
				}
			}
			
			ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
			do {
				ArrayList<Integer> current = new ArrayList<>();
				for ( int i = 0; i < testCase; i++ ) {
					if ( select[i] == 1 ) {
						current.add(arr[i]);
					}
				}
				ans.add(current);
			} while ( next_permutation(select) );
			Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
				public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
					int n = l1.size();
					int m = l2.size();
					int i = 0;

					while (i < n && i < m) {
						int t1 = l1.get(i);
						int t2 = l2.get(i);
						if (t1 < t2) {
							return -1;
						} else if ( t1 > t2 ) {
							return 1;
						} else {							
							i += 1;
						}
					}

					if (i == n && i != m) {
						return -1;
					} else if (i != n && i == m) {
						return 1;
					} else {
						return 0;
					}
				}
			});
			for (ArrayList<Integer> v : ans) {
				for (int x : v) {
					sb.append(x).append(" ");
				}
				sb.append('\n');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	public static boolean next_permutation(int[] select) {
		int standard = select.length - 1;
		while ( standard > 0 && select[standard - 1] >= select[standard] ) {
			standard -= 1;
		}
		
		if ( standard <= 0 ) {
			return false;
		}
		
		int next = select.length - 1;
		while ( select[next] <= select[standard - 1] ) {
			next -= 1;
		}
		
		int temp = select[standard - 1];
		select[standard - 1] = select[next];
		select[next] = temp;
		
		next = select.length - 1;
		while ( standard < next ) {
			temp = select[standard];
			select[standard] = select[next];
			select[next] = temp;
			
			standard += 1;
			next -= 1;
		}
		return true;
	}
}
