package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_2294 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k + 1];
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		
		for(int i=0;i<n;i++) {
			int coin = Integer.parseInt(br.readLine());
			
			for(int j=coin;j<=k;j++) {
				dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
			}
		}
		
		if(dp[k] == 987654321)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
		
	}

}
