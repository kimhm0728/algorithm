package dynamicProgramming;

import java.io.*;

public class B_10844 {
	static final int div = 1000000000;
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N + 1];
		
		dp[1] = 9;
		System.out.println(getStairsNum(N));
	}
	
	static int getStairsNum(int n) {
		if(dp[n] == null) 
			dp[n] = ((getStairsNum(n - 1) % div * 2) % div - (n - 1) % div) % div;
		
		return dp[n];
	}
}
