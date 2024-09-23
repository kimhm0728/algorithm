package java.dp;

import java.util.*;
import java.io.*;

public class B_1915 {
	static int N, M;
	static int[][] arr;
	static Integer[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		dp = new Integer[N][M];
		
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j] = input.charAt(j) - '0';
			
				if(i == N - 1 || j == M - 1)
					dp[i][j] = arr[i][j];
			}
		}
		
		int answer = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) 
				if(arr[i][j] == 1)
					answer = Math.max(answer, getRadius(i, j));
		}
		
		System.out.println(answer * answer);
	}
	
	static int getRadius(int r, int c) {
		if(r >= N || c >= M)
			return 0;
		
		if(dp[r][c] == null) {
			if(arr[r + 1][c] == 0 || arr[r][c + 1] == 0 || arr[r + 1][c + 1] == 0)
				dp[r][c] = 1;
			else 
				dp[r][c] = Math.min(Math.min(getRadius(r + 1, c), getRadius(r, c + 1)), getRadius(r + 1, c + 1)) + 1;
		}
		
		return dp[r][c];
	}

}
