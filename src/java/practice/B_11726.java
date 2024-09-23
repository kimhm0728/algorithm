package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11726 {
	static int div = 10007;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		
		System.out.println(solution(n));
	}
	
	static int solution(int n) {
		if (dp[n] != 0) return dp[n];
		
		return dp[n] = (solution(n - 1) + solution(n - 2)) % div;
	}

}
