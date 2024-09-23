package java.practice.baekjoon;

import java.util.*;
import java.io.*;

public class B_12865 {
	static int N, K;
	static int[] W;
	static int[] V;
	static int[][] dp;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		W = new int[N];
		V = new int[N];
		dp = new int[N][K + 1];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(N - 1, K));
	}

	static int solution(int i, int w) {
		if (i < 0) return 0;
		if (dp[i][w] != 0) return dp[i][w];
		
		if (w - W[i] >= 0) {
			dp[i][w] = Math.max(solution(i - 1, w - W[i]) + V[i], solution(i - 1, w));
		} else {
			dp[i][w] = solution(i - 1, w);
		}
		return dp[i][w];
	}
}
