package dynamicProgramming;

import java.io.*;

public class B_9655 {
	static boolean[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp = new boolean[N + 1];
		dp[2] = false;
		
		for(int i=4;i<=N;i++)
			dp[i] = !dp[i - 1];
		
		System.out.println(dp[N] ? "CY" : "SK");
	}
}
