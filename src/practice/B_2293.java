package skt;

import java.util.*;
import java.io.*;

public class B_2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k + 1];
		dp[0] = 1;
		
		for (int i=0;i<n;i++) {
			int w = Integer.parseInt(br.readLine());
			
			for (int j=w;j<=k;j++) {
				dp[j] += dp[j - w];
			}
		}
		
		System.out.println(dp[k]);
	}

}
