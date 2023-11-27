package skt;

import java.io.*;

public class B_10844 {
	static int div = 1000000000;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1][10];
		for (int i=1;i<10;i++) {
			dp[1][i]++;
		}
		
		for (int i=2;i<=n;i++) {
			solution(i);
		}
		
		int answer = 0;
		for (int i=0;i<10;i++) {
			answer = (answer + dp[n][i]) % div;
		}
		
		System.out.println(answer);
	}
	
	static void solution(int n) {
		for (int i=0;i<10;i++) {
			if (i != 0) {
				dp[n][i - 1] = (dp[n][i - 1] + dp[n - 1][i]) % div;
			}
			if (i != 9) {
				dp[n][i + 1] = (dp[n][i + 1] + dp[n - 1][i]) % div;
			}
		}
	}

}
