package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B_2407 {
	static BigInteger[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dp = new BigInteger[n + 1][m + 1];
		
		System.out.println(combi(n, m));
	}
	
	static BigInteger combi(int n, int r) {
		if (r == 0 || n == r) return BigInteger.valueOf(1);
		if (dp[n][r] != null) return dp[n][r];
		
		return dp[n][r] = combi(n - 1, r - 1).add(combi(n - 1, r));
	}

}
