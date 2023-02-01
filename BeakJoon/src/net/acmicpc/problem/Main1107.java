package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ������
/*
 * tv ä���� �ι����� �̿��� �ٲٴ� ����
 * ���� ���� �ִ� ä�� : 100
 * �̵��Ϸ��� �ϴ� ä���� N�϶� ������ ��ư�� ������ Ƚ���� �ּҷ� �ϴ� ����
 * 
 * �������, 5457�� �̵��Ϸ��� 5, 4, 5, 7�� ���� 4������ �̵��� �� �ִ�.
 * ����, ���� ��ư 7�� ���峵�ٰ� �ϸ�, 5, 4, 5, 6, + �Ǵ� 5, 4, 5, 8, -�� ���� 5������ �̵��� �� �ִ�.
 * 
 * ����, 6, 7, 8�� ���峵�� 5457�� �̵��ϰ� ���� ��찡 �ִٰ� �ϸ�
 * 5,4,3,5,+,+,+,5...
 * +�� -�� �����ٰ� ���� ��ư�� ������ ���� �� ������ �Է��� ���� ��� �ǹ� ��������.
 * 
 * �ּڰ��� ���ϴ� �������� �ߺ��� �߻��ϸ� �ּڰ��� ���� �� ����.
 * 
 * ����, ���� ��ư�� ������, �� ���� +�� - �� �ϳ��� �����ؼ� �������Ѵ�.
 */
public class Main1107 {

	public static boolean[] broken = new boolean[10];
	
	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �̵��Ϸ��� �ϴ� ä�� N
		int N = Integer.parseInt(br.readLine());
		
		// ���峭 ��ư�� ����
		int cnt = Integer.parseInt(br.readLine());
		
		// ���峭 ��ư�� �ִ� ��� ���峭 ��ư�� �Է�
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for ( int i = 0; i < cnt; i ++ ) {
			int[] err = new int[cnt];
			err[i] = Integer.parseInt(st.nextToken());
			// ���峭 ��ư�� true�� ���� ����
			broken[err[i]] = true;
		}
		
		// ���� ��ư�� ������ �ʴ� ���� ��� ��쿡 �� �����ϴ�. �׷��� ������ �ʱ갪���� ó�� 
		int ans = N - 100;
		if ( ans < 0 ) {
			ans = -ans;
		}
		
		// �̵��� ä���� ���Ѵ�. ( 0 ~ 1000000 ���� �� �̵��� �غ���. )
		for ( int i = 0; i <= 1000000; i++ ) { 
			// �̵��� �Ѵٴ� ���� ���� ��ư�� �̿��ؼ� �̵��� ä���� ch�̰�, ch�� ����
			int ch = i;
			int len = possible(ch);
			
			// �Ұ����ϸ� 0�� �����ϱ� ������ 0�� �ƴϸ� 
			if ( len > 0 ) {
				// +�� �� �� ������ �ϴ��� ��� 
				int press = ch - N;
				if ( press < 0 ) {
					// - �� �� �� ������ �ϴ��� ��� 
					press = -press;
				}
				
				if ( ans > len + press ) {
					ans = len + press;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static int possible(int ch) {
		
		if ( ch == 0 ) {
			if ( broken[0] ) {
				return 0;
			} else {
				return 1;
			}
		}
		
		int len = 0;
		/*
		 * �� ä��(ch)�� �̵��� �� �ִ����� �˻��ؾ� �Ѵ�.
		 * ���� 10���� ����ؼ� �����鼭 �ϳ��� �˻��ϴ� ��� 
		 */
		while ( ch > 0 ) {
			if ( broken[ ch % 10 ] ) {
				return 0;
			}
			len += 1;
			ch /= 10;
		}
		
		return len;
	}
}