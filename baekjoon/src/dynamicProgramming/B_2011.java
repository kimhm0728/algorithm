package dynamicProgramming;

import java.io.*;

public class B_2011 {
	static int div = 1000000;
	static int n;
	static int[] dp;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		n = s.length();
		num = new int[n];
		dp = new int[n];
		
		for (int i=0;i<n;i++) num[i] = s.charAt(i) - '0';
		dp[n - 1] = num[n - 1] == 0 ? 0 : 1;

		System.out.println(decode(0));
	}

	static int decode(int i) {
		if (i == n) return 1;
		if (dp[i] != 0) return dp[i];
		if (num[i] == 0) return 0;
		
		dp[i] = decode(i + 1) % div;
		if (num[i] * 10 + num[i + 1] <= 26) {
			dp[i] +=  decode(i + 2) % div;
		}
		
		return dp[i] % div;
	}
}
