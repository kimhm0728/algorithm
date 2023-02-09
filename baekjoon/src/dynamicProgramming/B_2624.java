package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_2624 {
	static int T, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		int[] dp = new int[T + 1];
		dp[0] = 1;
		
		StringTokenizer st;
		for(int i=1;i<=K;i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			
			for(int j=T;j>=p;j--) {
				for(int k=1;k<=n;k++) {
					if(j - p * k < 0)
						continue;
					
					dp[j] += dp[j - p * k];
				}
			}
		}
		
		System.out.println(dp[T]);
	}

}
