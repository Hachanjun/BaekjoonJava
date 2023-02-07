package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ��ȣ�����
/*
 * ���� �ٸ� L���� ���ĺ� �ҹ��ڵ�� �����Ǹ� �ּ� �� ���� ������ �ּ� �� ���� �������� ����
 * ��ȣ�� �̷�� ���ĺ��� ��ȣ���� �����ϴ� ������ �迭
 * ��ȣ�� ����� �� �ִ� ������ ������ C����
 * ���ɼ��ִ� ��ȣ�� ��� ���ϴ� ����
 * 
 * ������ ���� : 3<=L<=C<=15
 * ��ȣ�� ���� �ٸ� L���� ���ĺ� �ҹ��ڷ� �����Ǹ�, C���� �߿��� � ���ĺ��� �����ϰų� �������� �ʰų� �� �� �ϳ� 
 * 
 * ����
 * - �����ϴ� ������ �迭(���ĺ��� ���� - ���ĵ� ������ �����ϸ鼭 ��ȣ�� ���Խ�ų�� ���� ����)
 * - �ּ� �� ���� ������ �ּ� �� ���� �������� ����
 * 
 * go(n, alpha, password, i)
 * - n : �Է¹޴� ��, ������ �ϴ� ��ȣ�� ����
 * - alpha : �Է¹޴� ��, ����� �� �ִ� ���ĺ�(�迭)
 * - password : ������� ���� ��ȣ
 * - i : ������� ���� �����ؾ��ϴ� ���ĺ��� �ε���
 * 
 * ������ ã�� ��� : password�� ���� == n
 * �Ұ����� ���(�� �̻� ������ �� �ִ� ���ĺ��� ���� ���) : i >= alpha
 * ���� ���(index i��°�� ���ĺ��� ����� ����, ������� ���� ���� �ִ�.)
 * - i��° ���ĺ��� ����ϴ� ��� : go(n, alpha, password+alpha[i], i+1)
 * - i��° ���ĺ��� ������� �ʴ� ��� : go(n, alpha, password, i+1)
 * 
 * �ּ� �� ���� ������ �ּ� �� ���� �������� ���� ���� ó��
 * 
 */
public class Main1759 {

	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ù° �ٿ� �� �� L,C�� �־�����.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		// �־����� ���ĺ��� ������ �迭
		String[] alpha = new String[C];
		st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < C; i++ ) {
			alpha[i] = st.nextToken();
		}
		
		// �����ϴ� ������ �迭�ϱ� ������ ������ ���ش�.
		Arrays.sort(alpha);
		
		go(L, alpha, "", 0);
	}
	
	public static void go(int L, String[] alpha, String password, int index) {
		
		StringBuilder sb = new StringBuilder();
		
		// ������ ã�� ���
		if ( password.length() == L ) {
			if ( check(password) ) {
				sb.append(password).append('\n');
			}
			System.out.print(sb);
			return;
		}
		
		// �Ұ����� ���
		if ( index >= alpha.length ) {
			return;
		}
		
		// ���� ���(index i��°�� ���ĺ��� ����� ����, ������� ���� ���� �ִ�.)
		// i��° ���ĺ��� ����ϴ� ���
		go(L, alpha, password + alpha[index], index + 1);
		// i��° ���ĺ��� ������� �ʴ� ���
		go(L, alpha, password, index + 1);
		
	}
	
	// �ּ� �� ���� ������ �� ���� ���� ���� ó�� 
	public static boolean check(String password) {
		
		int ja = 0;
		int mo = 0;
		for ( char x : password.toCharArray() ) {
			if ( x =='a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' ) {
				mo += 1;
			} else {
				ja += 1;
			}
		}
		// �ּ� �� ���� ������ �ּ� �� ���� �������� ����
		return ja >= 2 && mo >= 1;
	}
}
