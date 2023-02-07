package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ���
/*
 * N+1���� �Ǵ� �� ����Ϸ����Ѵ�.(1<=N<=15)
 * ���� N�� ���� �ִ��� ���� ����� �Ϸ��� �Ѵ�.
 * �Ϸ翡 �ϳ��� ����� �� �� �ְ�, i�Ͽ� ����� �ϸ� T[i]���� �ɸ��� P[i]���� ����.
 * 
 * ex) N = 5 �� ���
 * 		1	2	3	4	5	6(���)
 * T	3	1	2	2	100
 * P	2	5	3	3	10��
 * 
 * ���� ���� ���� ������ 5�� 10���� ���� ������ �� ���� ���� ���ؼ� 100���� �� ���ؾ��Ѵ�.
 * ���� ���ǿ��� N+1�� �� �Ǵ� �� ��縦 �Ѵٰ� ������ �ش� ���� �� �� ����.
 * 
 * ������ ����
 * - �Ϸ翡 �ϳ��� ����� �� �� �ִ� : ������ ��¥���� ��� ����� ���� ���� �����Ѵ�.
 * 
 * ������ ��¥�� �ִ� ����� �ϴ� ���� ���� �ʴ� ���� ������.
 * go(day, sum)
 * day : day���� �Ǿ���. day�Ͽ� �ִ� ����� ���� ���� �����ؾ� �Ѵ�.
 * sum : ���ݱ��� ���� ����
 * 
 * ������ ã�� ��� : day == N+1 -> ���ݱ��� ����� �� �� ���Ͱ�  ���ݱ��� ���� ������ �ִ��� �� �� �ִ��� ���Ѵ�.
 * �Ұ����� ��� : day > N+1 ��¥�� �Ѿ ���
 * ���� ��� ȣ��
 * - ����� �ϴ� ��� : go(day + T[day], sum+P[day])
 * -> N = 1�� ��� ����� �ϰ� �Ǹ� 3���� �� ��㸸 �ؾ��ϴ� 2,3���� ����� �� �� ����. 1�Ͽ� ����� �ߴٸ� 4�Ϸ� �Ѿ�� �Ѵ�.
 * - ����� ���� �ʴ� ���  : go(day+1, sum)
 * -> �ش��Ͽ� ����� ���� �ʾҴٸ�, ���� ���� �Ѿ�� ����� ���� �ʾ����� ������ ������ ����.
 */
public class Main14501 {

	public static int N;
	public static int[] term;
	public static int[] price;
	public static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ù° �ٿ� N�� �־�����.
		N = Integer.parseInt(br.readLine());
		
		// T(�Ⱓ), P(�ݾ�)�� �־�����.
		term = new int[N + 1];
		price = new int[N + 1];
		for ( int i = 1; i <= N; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			term[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		// ù° �� ���� ���� ���� �����ؾ��ϴϱ� 1, �հ�� �ݾ��� ���� ������ 0
		go(1, 0);
		System.out.println(ans);
	}
	
	public static void go(int day, int sum)	{
		
		// ������ ã�� ���
		if ( day == N + 1 ) {
			if ( ans < sum ) {
				ans = sum;
			}
			return;
		}
		
		// �Ұ����� ���
		if ( day > N + 1 ) {
			return;
		}
		
		// ����� ���� �ʴ� ���
		go(day + 1, sum);
		// ����� �ϴ� ���
		go(day + term[day], sum + price[day]);
	}
}
