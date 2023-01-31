package dynamicProgramming;

import java.io.*;

public class B_2839 {
	static int dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp = new int[5001];

		dp[0] = dp[1] = dp[2] = dp[4] = -1;
		dp[3] = dp[5] = 1;

		for(int i=6;i<=N;i++) {
			if(dp[i - 3] != -1 && dp[i - 5] != -1)
				dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
			else {
				dp[i] = Math.max(dp[i - 3], dp[i - 5]) + 1;
				if(dp[i] == 0) 
					dp[i] = -1;
			}
		}

		System.out.println(dp[N]);
	}

}
