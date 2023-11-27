package skt;

import java.util.*;
import java.io.*;

public class B_15486 {
	static int n;
	static int[] t;
	static int[] p;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		t = new int[n + 1];
		p = new int[n + 1];
		dp = new int[n + 1];
		
		StringTokenizer st;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i=0;i<=n;i++) {
			max = Math.max(dp[i], max);

			int next = i + t[i];
			if (next > n) continue;
			
			dp[next] = Math.max(dp[next], max + p[i]);
		}
		
		System.out.println(max);
	}

}
