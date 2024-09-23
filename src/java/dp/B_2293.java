package java.dp;

import java.util.*;
import java.io.*;

public class B_2293 {
	static int N, K;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[K + 1];
		dp[0] = 1;
		
		for(int i=0;i<N;i++) { 
			int c = Integer.parseInt(br.readLine());
		
			for(int j=c;j<=K;j++)
				dp[j] += dp[j - c];
		}

		System.out.println(dp[K]);
	}

}
