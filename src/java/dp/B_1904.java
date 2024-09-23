package java.dp;

import java.io.*;

public class B_1904 {
	static int div = 15746;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		
		dp[1] = 1;
		if (n > 1) dp[2] = 2;
		
		System.out.println(solution(n));
	}
	
	static int solution(int i) {
		if (dp[i] != 0) return dp[i];
		return dp[i] = (solution(i - 1) + solution(i - 2)) % div;
	}

}
