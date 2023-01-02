package net.acmicpc.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 골드바흐 파티션
public class Main17103 {

	public static boolean[] isPrime;
	
//	public static void main(String[] args) throws Exception {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		
//		int T = Integer.parseInt(br.readLine());
//		isPrime = new boolean[1000001];
//		get_prime();
//		
//		while ( T-- > 0 ) {
//			int N = Integer.parseInt(br.readLine());
//			
//			int ans = 0;
//			for ( int i = 2; i <= N; i++ ) {
//				if ( !isPrime[i] && !isPrime[N - i] ) {
//					ans++;
//				}
//				sb.append(ans).append('\n');					
//				break;
//			}
//		}
//		System.out.println(sb);
//	}
//	
//	public static void get_prime() {
//		
//		isPrime[0] = isPrime[1]	= true;
//		
//		for ( int i = 2; i * i < 1000000; i++ ) {
//			if ( isPrime[i] == true ) {
//				continue;
//			}
//			for ( int j = i + i; j < 1000000; j += i ) {
//				isPrime[j] = true;
//			}
//		}
//	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 소수 구하기 = 소수 false
        boolean[] num = new boolean[1000001];
        num[0] = num[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!num[i]) {
                for (int j = i + i; j <= 1000000; j += i) {
                    num[j] = true;
                }
            }
        }

        while (t-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int j = 2; j <= temp / 2; j++) {
                if (!num[j] && !num[temp - j]) ans++;
            }
            System.out.println(ans);
        }
    }
}
