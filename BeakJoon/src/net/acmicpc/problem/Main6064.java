package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ī�� �޷�
/*
 * �ǳʶٸ� �غ��� : ��� ����� ���� ����� �ʿ䰡 ���ٰ� ��������, �ǳʶٸ鼭 ���
 * M,N <= 40000 -> 16�� / 1�ʿ� 1�� ���� -> 16�� (��� ��츦 ������� ���)
 * M,N�� �־����� �� �ش� �� ��ŭ(M,N) �ݺ��ȴ�. x,y�� �־����� �� �� ��° ������ ���ϴ� ����
 * 
 * ������ ������ ���� ��� -> ������ ������ �ϱ� ���ؼ��� ��� ������ -1�� ���ش�.
 * -> ������ x = 5, N = 5�� ��� �������� �� ��� �������� 5�� �ƴ� 0�� �Ǳ� ������ 
 * �� 0 ~ N-1�� ����� ����
 * 
 * M�� ������ ���� �Ѵٸ�, N���� ������ָ� �ȴ�. -> ���δٸ� N�� ������ ���� N���� �ۿ� ����.
 */
public class Main6064 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// �׽�Ʈ ���̽� T
		int T = Integer.parseInt(br.readLine());
		
		// M, N, x, y �Է�
		for ( int i = 0; i < T; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			// �������� ��ȿ���� ���� ǥ���̸� -1�� ����϶�� �߱� ������ boolean���� �ذ�
			boolean ok = false;
			
			// j+=M -> M��ŭ�� �ǳʶٸ� x�� ������ų �� �ִ�.
			for ( int j = x; j < M * N; j += M ) {
				if ( j % N == y ) {
					// ������ ������ ���� -1 �߱� ������ +1
					sb.append(j + 1).append('\n');
					ok = true;
					break;
				} 
			}
			if ( !ok ) {
				sb.append("-1").append('\n');
			}
		}
		System.out.println(sb);
	}
}
