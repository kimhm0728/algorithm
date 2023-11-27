package dynamicProgramming;

import java.io.*;

public class B_2156 {
	static int N;
	static int[] wine;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		wine = new int[N];
		dp = new Integer[N][2];

		for(int i=0;i<N;i++) 
			wine[i] = Integer.parseInt(br.readLine());

		if(N == 1) {
			System.out.println(wine[0]);
			return;
		}
		if(N == 2) {
			System.out.println(wine[0] + wine[1]);
			return;
		}

		dp[N - 1][0] = dp[N - 1][1] = wine[N - 1];
		dp[N - 2][1] = wine[N - 1] + wine[N - 2];
		dp[N - 2][0] = wine[N - 2];

		System.out.println(Math.max(drinkWine(0, 1), Math.max(drinkWine(1, 1), drinkWine(2, 1))));
	}

	static int drinkWine(int n, int next) {
		if(dp[n][next] == null) {
			dp[n][next] = wine[n];

			if(n < N - 3) {
				if(next == 1)
					dp[n][next] += Math.max(drinkWine(n + 1, 0), Math.max(drinkWine(n + 2, 1), drinkWine(n + 3, 1)));
				else 
					dp[n][next] += Math.max(drinkWine(n + 2, 1), drinkWine(n + 3, 1));
			}
			else {
				if(next == 1)
					dp[n][next] += Math.max(drinkWine(n + 1, 0), drinkWine(n + 2, 1));
				else
					dp[n][next] += drinkWine(n + 2, 1);
			}
		}

		return dp[n][next];
	}

}
