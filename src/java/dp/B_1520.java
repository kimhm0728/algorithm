package java.dp;

import java.util.*;
import java.io.*;

public class B_1520 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int M, N;
	static int[][] h;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		h = new int[M][N];
		dp = new int[M][N];

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				h[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		dp[0][0] = 1;
		System.out.println(countPath(M - 1, N - 1, h[M - 1][N - 1], -1));
	}

	static int countPath(int r, int c, int pre, int d) {
		if(dp[r][c] == -1) {
			int cnt = 0;
			for(int i=0;i<4;i++) {
				if(!checkD(d, i))
					continue;
				int nextR = r + dir[i][0];
				int nextC = c + dir[i][1];

				if(check(nextR, nextC) && pre < h[nextR][nextC]) 
					cnt += countPath(nextR, nextC, h[nextR][nextC], i);
			}
			dp[r][c] = cnt;
		}
		return dp[r][c];
	}

	static boolean check(int r, int c) {
		if(r < 0 || r >= M || c < 0 || c >= N)
			return false;
		return true;
	}

	static boolean checkD(int d, int nextD) {
		if((d == 0 && nextD == 1) || (d == 1 && nextD == 0)
				|| (d == 2 && nextD == 3) || (d == 3 && nextD == 2))
			return false;
		return true;
	}

}
