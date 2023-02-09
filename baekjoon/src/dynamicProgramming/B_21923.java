package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_21923 {
	static int N, M;
	static int[][] score;
	static Integer[][][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		score = new int[N][M];
		dp = new Integer[2][N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				score[i][j] = Integer.parseInt(st.nextToken());
		}
		
		if(M == 1) {
			int answer = Integer.MIN_VALUE;
			int sum = 0;
			for(int i=0;i<N;i++) {
				sum += i == 0 ? score[i][0] : score[i][0] * 2;
				answer = Math.max(sum + score[i][0], answer);
			}
			
			System.out.println(answer);
			return;
		}
		
		// (N-1, M-1) -> (N-1, 0)
		dp[0][N - 1][0] = dp[1][N - 1][0] = score[N - 1][0];
		System.out.println(plane(N - 1, M - 1, 1));
	}
	
	static int plane(int r, int c, int flag) {
		if(dp[flag][r][c] == null) {
			if(flag == 1) {
				if(r == 0 && c == 0) // 방향 바꾸기
					dp[flag][r][c] = score[r][c] + plane(r, c, 0);
				else if(r == 0) // 위로 못감
					dp[flag][r][c] = score[r][c] + Math.max(plane(r, c - 1, 1), plane(r, c, 0));
				else if(c == 0) // 옆으로 못감
					dp[flag][r][c] = score[r][c] + Math.max(plane(r - 1, c, 1), plane(r, c, 0));
				else 
					dp[flag][r][c] = score[r][c] + Math.max(plane(r - 1, c, 1), Math.max(plane(r, c - 1, 1), plane(r, c, 0)));
			}
			else {
				if(r == N - 1) // 아래로 못감
					dp[flag][r][c] = score[r][c] + plane(r, c - 1, 0);
				else if(c == 0) // 옆으로 못감
					dp[flag][r][c] = score[r][c] + plane(r + 1, c, 0);
				else
					dp[flag][r][c] = score[r][c] + Math.max(plane(r + 1, c, 0), plane(r, c - 1, 0));
			}
		}
		
		return dp[flag][r][c];
	}

}
