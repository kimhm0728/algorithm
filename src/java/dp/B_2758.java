package java.dp;

import java.util.*;
import java.io.*;

public class B_2758 {
	static int N, M;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			dp = new long[N + 1][M + 1];
			Arrays.fill(dp[0], (long)1);
			
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=M;k++)
					dp[j][k] = dp[j - 1][k / 2] + dp[j][k - 1];
			}
			
			sb.append(dp[N][M]).append('\n');
		}

		System.out.println(sb);
	}
	
}

