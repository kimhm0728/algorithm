package dynamicProgramming;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class B_2407 {
	static BigInteger[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dp = new BigInteger[101][101];
		System.out.println(combi(N, M));
	}
	
	static BigInteger combi(int n, int r) {
		if(dp[n][r] == null) {
			if(n == r || r == 0)
				return dp[n][r] = BigInteger.valueOf(1);
			
			return dp[n][r] = combi(n - 1, r - 1).add(combi(n - 1, r));
		}
		
		return dp[n][r];
	}

}
