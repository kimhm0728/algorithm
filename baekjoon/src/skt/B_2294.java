package skt;

import java.util.*;
import java.io.*;

public class B_2294 {
	static int INF = 1000000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		for (int i=0;i<n;i++) {
			int w = Integer.parseInt(br.readLine());
			
			for (int j=w;j<=k;j++) {
				dp[j] = Math.min(dp[j - w] + 1, dp[j]);
			}
		}
		
		System.out.println(dp[k] == INF ? -1 : dp[k]);
	}

}
