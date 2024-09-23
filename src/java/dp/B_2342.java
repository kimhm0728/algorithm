package java.dp;

import java.util.*;
import java.io.*;

public class B_2342 {
	static int n = 0;
	static int[] arr = new int[100001];
	static int[][][] dp = new int[100001][5][5];
	static int[][] score = {
			{1, 2, 2, 2, 2}, 
			{2, 1, 3, 4, 3}, 
			{2, 3, 1, 3, 4},
			{2, 4, 3, 1, 3}, 
			{2, 3, 4, 3, 1}
		};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while (true) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == 0) break;
			arr[n++] = temp;
		}
		
		System.out.println(ddr(0, 0, 0));
	}
	
	static int ddr(int idx, int l, int r) {
		if (idx == n) return 0;
		if (dp[idx][l][r] != 0) return dp[idx][l][r];
		
		int next = arr[idx];
		dp[idx][l][r] = Math.min(score[l][next] + ddr(idx + 1, next, r), 
				score[r][next] + ddr(idx + 1, l, next));
	
		return dp[idx][l][r];
	}

}
