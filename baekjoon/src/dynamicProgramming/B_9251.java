package dynamicProgramming;

import java.io.*;

public class B_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split("");
		String s2 = br.readLine();
		
		int n = s1.length;
		int[][] dp = new int[n][2]; // 0: ±Ê¿Ã, 1: ¿Œµ¶Ω∫
		
		int idx = s2.indexOf(s1[0]);
		dp[0][0] = idx == -1 ? 0 : 1;
		dp[0][1] = idx;
		
		int answer = dp[0][0];
		for(int i=1;i<n;i++) {
			idx = s2.indexOf(s1[i]);
			if(idx != -1) {
				dp[i][0] = 1;
				dp[i][1] = idx;
				
				for(int j=i-1;j>=0;j--) {
					if(dp[i][0] == 0)
						continue;
					idx = s2.indexOf(s1[i], dp[j][1] + 1);
					if(idx != -1 && dp[i][0] < dp[j][0] + 1) {
						dp[i][0] = dp[j][0] + 1;
						dp[i][1] = idx;
					}
				}
				answer = Math.max(answer, dp[i][0]);
			}
		}
		
		System.out.println(answer);
	}

}
