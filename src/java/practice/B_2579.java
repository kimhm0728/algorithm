package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2579 {
	static int[] score;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		score = new int[n];
		dp = new int[n][2];
		
		for (int i=0;i<n;i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(solution(n - 1, 0));
	}

	static int solution(int n, int cnt) {
		if (n < 0) return 0;
		if (dp[n][cnt] != 0) return dp[n][cnt];
		
		dp[n][cnt] = score[n];
		if (cnt == 1) {
			dp[n][cnt] += solution(n - 2, 0);
		} else {
			dp[n][cnt] += Math.max(solution(n - 2, 0), solution(n - 1, 1));
		}
	
		return dp[n][cnt];
	}
}
