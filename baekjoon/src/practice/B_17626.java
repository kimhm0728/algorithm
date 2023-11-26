package skt;

import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_17626 {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n + 1];
		Arrays.fill(dp, 5);
		dp[0] = 0; 
		dp[1] = 1;

		System.out.println(solution(n));
	}
	
	static int solution(int n) {
		if (dp[n] != 5) return dp[n];

		for(int i=(int)Math.sqrt(n);i>0;i--) {
			dp[n] = Math.min(dp[n], solution(n - i * i) + 1);
		}
		
		return dp[n];
	}

}
