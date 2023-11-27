package skt;

import java.util.*;
import java.io.*;

public class B_9465 {
	static int n;
	static int[][] sticker;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int i=0;i<t;i++) {
			n = Integer.parseInt(br.readLine());
			sticker = new int[2][n];
			dp = new int[2][n];
			
			for (int j=0;j<2;j++) {
				st = new StringTokenizer(br.readLine());
				for (int k=0;k<n;k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
					if (k == n - 1) dp[j][k] = sticker[j][k];
					else dp[j][k] = -1;
				}
			}
			
			int answer = Math.max(solution(0, 0), solution(1, 0));
			sb.append(answer).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int solution(int r, int c) {
		if (dp[r][c] != -1) return dp[r][c];
		
		int nextR = r == 0 ? 1 : 0;
		if (c < n - 2) dp[r][c] = Math.max(solution(nextR, c + 1), solution(nextR, c + 2)) + sticker[r][c];
		else dp[r][c] = solution(nextR, c + 1) + sticker[r][c];
		return dp[r][c];
	}

}
