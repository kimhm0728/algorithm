package dynamicProgramming;

import java.io.*;

public class B_17626 {
	static Integer[] dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1];
		dp[0] = 0;
		
		System.out.println(getCount(N));
	}
	
	static int getCount(int n) {
		if(dp[n] == null) {
			dp[n] = 5;
			for(int i=(int)Math.sqrt(n);i>=1;i--) {
				dp[n] = Math.min(dp[n], getCount(n - i * i) + 1);
			}
			
			return dp[n];
		}
		
		return dp[n];
	}

}
