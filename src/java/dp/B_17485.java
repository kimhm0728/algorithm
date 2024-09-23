package java.dp;

import java.util.*;
import java.io.*;

public class B_17485 {
	static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}};
	static int N, M;
	static int[][] space;
	static Integer[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		space = new int[N][M];
		dp = new Integer[3][N][M];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) 
				space[i][j] = Integer.parseInt(st.nextToken());
		}

		int answer = 987654321;
		for(int i=0;i<M;i++) {
			for(int j=0;j<3;j++) {
				if((i == 0 && j == 0) || (i == M - 1 && j == 2))
					continue;

				answer = Math.min(space[N - 1][i] + minFuel(j, N - 2, i + dir[j][1]), answer);
			}
		}
		System.out.println(answer);
	}

	static int minFuel(int i, int r, int c) {
		if(r == 0) 
			return space[r][c];
		
		if(dp[i][r][c] == null) {
			dp[i][r][c] = 987654321;
			
			for(int j=0;j<3;j++) {
				if((i == j) || (c == 0 && j == 0) || (c == M - 1 && j == 2))
					continue;

				dp[i][r][c] = Math.min(dp[i][r][c], space[r][c] + minFuel(j, r + dir[j][0], c + dir[j][1]));
			}
		}

		return dp[i][r][c];
	}

	static boolean check(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= M)
			return false;
		return true;
	}

}
