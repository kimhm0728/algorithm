package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2839 {
	static int INF = 5000;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		dp[0] = 1;
		
		int answer = deliver(n);
		System.out.println(answer >= INF ? -1 : answer);
	}

	static int deliver(int i) { 
		if (dp[i] != 0) return i;
		
		if (i >= 5) dp[i] = Math.min(deliver(i - 5) + 1, deliver(i - 3) + 1);
		else if (i >= 3) dp[i] = deliver(i - 3) + 1;
		else dp[i] = INF;
		
		return dp[i];
	}
}
