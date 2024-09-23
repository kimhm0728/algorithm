package java.practice;

import java.util.*;
import java.io.*;

public class B_1106 {
	static int INF = 987654321;
	static int c, n;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		dp = new int[c + 101];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
		
			for(int j=p;j<c+101;j++) {
				dp[j] = Math.min(dp[j], dp[j - p] + w);
			}
		}
		
		int answer = INF;
		for (int i=c;i<c+101;i++) {
			answer = Math.min(dp[i], answer);
		}
		
		System.out.println(answer);
	}

}
