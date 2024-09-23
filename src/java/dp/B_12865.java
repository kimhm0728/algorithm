package java.dp;

import java.util.*;
import java.io.*;

public class B_12865 {
	static int N, K;
	static int[] w;
	static int[] v;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		w = new int[N + 1];
		v = new int[N + 1];

		dp = new int[N + 1][K + 1];

		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());

			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1;i<=K;i++) {
			for(int j=1;j<=N;j++) {
				if(i - w[j] < 0)
					dp[j][i] = dp[j - 1][i];
				else
					dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - w[j]] + v[j]);
			}
		}

		System.out.println(dp[N][K]);
	}

}
