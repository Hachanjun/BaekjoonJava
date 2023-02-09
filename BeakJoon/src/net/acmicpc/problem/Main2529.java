package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// �ε�ȣ
/*
 * �ε�ȣ ��ȣ  < �� >�� ������ ���� A�� �ִ�.
 * ��ȣ�� �� �ڿ� �� �ڸ� ���ڸ� �־ ��� �ε�ȣ ���踦 ������Ű���� �Ѵ�.
 * �� ��, ���õ� ���� ��� �޶�� �Ѵ�.
 * k���� �ε�ȣ ���踦 ��� ������Ű�� (k+1)�� �ڸ��� ���� �߿��� �ִ񰪰� �ּڰ��� ���ϴ� ����
 * 
 * ex) A = [>, <, <, >] -> 9 > 2 < 3 < 5 > 1
 * 
 */
public class Main2529 {

	public static int k;
	public static char[] sign;
	public static ArrayList<String> ans = new ArrayList<>();
	public static boolean[] check = new boolean[10]; // 0 ~ 9
	
	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �ε�ȣ ������ ������ ��Ÿ���� ���� k
		k = Integer.parseInt(br.readLine());
		
		// k���� �ε�ȣ ��ȣ�� ������ �ΰ� ���ٿ� ���� 
		sign = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for ( int i = 0; i < k; i++ ) {	
			sign[i] = st.nextToken().charAt(0);
		}
		
		go(0 ,"");
		
		// �ִ�, �ּڰ��� ����ϱ� ���� ����
		Collections.sort(ans);
		int size = ans.size();
		
		// �ִ�
		System.out.println(ans.get(size - 1));
		// �ּڰ�
		System.out.println(ans.get(0));
	}
	
	// index : index ��°, num : ���� �� ���ļ� ���ڿ��� ����ؾ��ϴ� ���ڿ��� �ѱ�� ����
	public static void go(int index, String num) {
		
		// ��� ���� ������ ���
		if ( index > k ) {
			ans.add(num);
			return;
		}
		
		// index���� �� �� �ִ� ���� 0 ~ 9
		for ( int i = 0; i <= 9; i++ ) {
			// �տ��� �������� ���� ������ �Ѵ�.
			if ( check[i] ) continue;
			
			// index�� 0�̸� �տ��ִ� ���� ���� ���, ���� ���� ����. (�׻� ����)
			// ���� ��, ������ ��, �ε�ȣ�� ������ ��쿡�� �ش� ���� ����ߴٰ� ó��
			if ( index == 0 || reference(num.charAt(index - 1), (char)(i+'0'), sign[index - 1]) ) {
				check[i] = true;
				
				// ���� index��° ȣ��
				go(index + 1, num + Integer.toString(i));
				
				// �ٽ� ���� �ʾҴٰ� ó��
				check[i] = false;
			}
		}
	}
	
	public static boolean reference(char prev, char next, char x) {
		
		if ( x == '<' ) {
			if ( prev > next ) return false;
		}
		
		if ( x == '>' ) {
			if ( prev < next ) return false;
		}
		
		return true;
	}
}
