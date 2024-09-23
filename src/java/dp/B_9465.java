package java.dp;

import java.util.*;
import java.io.*;

public class B_9465 {
	static int N;
	static int[][] score;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			N = Integer.parseInt(br.readLine());
			
			score = new int[2][N];
			dp = new Integer[2][N];
			
			for(int j=0;j<2;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) 
					score[j][k] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][N - 1] = score[0][N - 1];
			dp[1][N - 1] = score[1][N - 1];
			
			sb.append(Math.max(attachSticker(0, 0), attachSticker(1, 0)));
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int attachSticker(int r, int c) {
		if(dp[r][c] == null) {
			if(c < N - 2) {
				dp[r][c] = score[r][c] + Math.max(attachSticker(r == 0 ? 1 : 0, c + 2), 
						attachSticker(r == 0 ? 1 : 0, c + 1));
			}
			else
				dp[r][c] = score[r][c] + attachSticker(r == 0 ? 1 : 0, c + 1);
		}
		
		return dp[r][c];
	}

}
