package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_1912 {
	static int[] arr;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		dp[0] = arr[0];
		prefixSum(N - 1);
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++)
			max = Math.max(max, dp[i]);
		
		System.out.println(max);
	}

	static int prefixSum(int n) {
		if(dp[n] == null) 
			return dp[n] = Math.max(arr[n] + prefixSum(n - 1), arr[n]);
		
		return dp[n];
	}
}
