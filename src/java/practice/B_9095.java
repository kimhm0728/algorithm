package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9095 {
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		dp = new int[11];
		
		for (int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(solution(n)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int solution(int n) {
		if (n == 0) return 1;
		if (dp[n] != 0) return dp[n];
		
		if (n >= 3) dp[n] += solution(n - 3);
		if (n >= 2) dp[n] += solution(n - 2);
		dp[n] += solution(n - 1);
		
		return dp[n];
	}

}
