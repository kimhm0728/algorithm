package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B_1463 {
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		dp[0] = dp[1] = 0;
		System.out.print(recur(N));
	}
	static int recur(int n) {
		if(n == 0) return 0;
		if(n == 1) return 0;
		if(dp[n] != 0) return dp[n];

		if(n % 6 == 0) dp[n] = Math.min(Math.min(recur(n / 3), recur(n / 2)), recur(n - 1)) + 1;
		else if(n % 3 == 0) dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
		else if(n % 2 == 0) dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
		else dp[n] = recur(n - 1) + 1;

		return dp[n];
	}
}
