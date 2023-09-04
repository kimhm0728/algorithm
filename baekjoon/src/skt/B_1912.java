package skt;

import java.util.*;
import java.io.*;

public class B_1912 {
	static int[] num;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		num = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			dp[i] = num[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = dp[0];
		for (int i=1;i<n;i++) {
			if (dp[i - 1] > 0) {
				dp[i] += dp[i - 1];
			}
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}

}
