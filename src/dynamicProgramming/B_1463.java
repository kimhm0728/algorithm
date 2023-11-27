package dynamicProgramming;

import java.io.*;

public class B_1463 {
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[1000001];
		dp[1] = 0;
		System.out.println(makeOne(N));
	}
	
	static int makeOne(int n) {
		if(dp[n] == null) {
			if(n % 3 == 0 && n % 2 == 0) 
				return dp[n] = Math.min(makeOne(n / 3), Math.min(makeOne(n / 2), makeOne(n - 1))) + 1;
			if(n % 3 == 0)
				return dp[n] = Math.min(makeOne(n / 3), makeOne(n - 1)) + 1;
			if(n % 2 == 0)
				return dp[n] = Math.min(makeOne(n / 2), makeOne(n - 1)) + 1;
			return dp[n] = makeOne(n - 1) + 1;
		}
		
		return dp[n];
	}

}