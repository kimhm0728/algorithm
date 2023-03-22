package binarySearch;

import java.util.*;
import java.io.*;

public class B_22871 {
	static int N;
	static long[] a;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		a = new long[N];
		dp = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) 
			a[i] = Long.parseLong(st.nextToken());

		System.out.println(isCross(0));
	}

	static long isCross(int n) {
		if(n == N - 1)
			return 0;

		if(dp[n] == 0) {
			dp[n] = Long.MAX_VALUE;
			for(int i=n+1;i<N;i++) 
				dp[n] = Math.min(dp[n], Math.max((i - n) * (Math.abs(a[i] - a[n]) + 1), isCross(i)));
		}
		
		return dp[n];
	}

}
