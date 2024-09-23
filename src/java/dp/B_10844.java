package java.dp;

import java.io.*;
import java.util.*;

public class B_10844 {
	static final int div = 1000000000;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp = new long[N + 1][10];

		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;

		for(int i=2;i<=N;i++) {
			for(int j=0;j<=9;j++) {
				if(j != 9)
					dp[i][j + 1] = (dp[i][j + 1] + dp[i - 1][j]) % div;
				if(j != 0)
					dp[i][j - 1] = (dp[i][j - 1] + dp[i - 1][j]) % div;
			}
		}
		
		long max = 0;
		for(int i=0;i<=9;i++)
			max = (max + dp[N][i]) % div;

		System.out.println(max);
	}
	
}
