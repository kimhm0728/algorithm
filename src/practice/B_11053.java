package skt;

import java.util.*;
import java.io.*;

public class B_11053 {
	static int[] num;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		num = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for (int i=0;i<n;i++) {
			dp[i] = 1;
			for (int j=0;j<i;j++) {
				if (num[i] > num[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}

}
