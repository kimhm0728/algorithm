package java.dp;

import java.util.*;
import java.io.*;

public class B_7579 {
	static int INF = 1000000001;
	static int[][] dp;
	static int[] m;
	static int[] c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dp = new int[N][M + 1];
		m = new int[N];
		c = new int[N];
		for (int i=0;i<N;i++) Arrays.fill(dp[i], INF);
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) m[i] = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) c[i] = Integer.parseInt(st.nextToken());

		System.out.println(solution(N - 1, M));
	}
	
	static int solution(int n, int w) {
		if (w <= 0) return 0;
		if (n < 0) return INF;
		if(dp[n][w] != INF) return dp[n][w];
		
		return dp[n][w] = Math.min(solution(n - 1, w - m[n]) + c[n], solution(n - 1, w));
	}

}
