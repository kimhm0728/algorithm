package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_2758 {
	static int N, M;
	static Long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			dp = new Long[N + 1][M + 1];

			long answer = 0;
			for(int j=M;j>0;j--)
				answer += lotto(N - 1, j);
			
			sb.append(answer).append('\n');
		}

		System.out.println(sb);
	}

	static long lotto(int n, int num) {
		if(n == 0)
			return 1;

		if(dp[n][num] == null) {
			dp[n][num] = (long) 0;
			for(int i=num/2;i>0;i--) 
				dp[n][num] += lotto(n - 1, i);
		}

		return dp[n][num];
	}

}
