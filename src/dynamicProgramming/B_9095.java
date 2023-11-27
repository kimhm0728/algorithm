package dynamicProgramming;

import java.io.*;

public class B_9095 {
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		dp = new Integer[11];
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(makeSum(N)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int makeSum(int n) {
		if(dp[n] == null) {
			return dp[n] = makeSum(n - 3) + makeSum(n - 2) + makeSum(n - 1);
		}
		
		return dp[n];
	}

}
