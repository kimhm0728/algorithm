package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1463 {
	static int INF = 1000001;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		
		System.out.println(solution(n));
	}
	
	static int solution(int n) {
		if (n == 1) return 0;
		if (dp[n] != 0) return dp[n];
		
		dp[n] = INF;
		if (n % 3 == 0) dp[n] = Math.min(dp[n], solution(n / 3) + 1);
		if (n % 2 == 0) dp[n] = Math.min(dp[n], solution(n / 2) + 1);
		dp[n] = Math.min(dp[n], solution(n - 1) + 1);
		
		return dp[n];
	}

}
