package dynamicProgramming;

import java.io.*;

public class B_11726 {
	static final int div = 10007;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3;i<=N;i++)
			dp[i] = (dp[i - 1] + dp[i - 2]) % div;
		
		System.out.println(dp[N]);
	}

}
