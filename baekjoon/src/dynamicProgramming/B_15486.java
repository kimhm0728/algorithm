package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_15486 {
	static int N;
	static int[][] consult;
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		consult = new int[N][2];
		dp = new Integer[N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			consult[i][0] = Integer.parseInt(st.nextToken());
			consult[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(maxProfit(0));
	}
	
	static int maxProfit(int n) {
		if(n >= N)
			return 0;
		
		if(dp[n] == null) {
			dp[n] = 0;
			for(int i=0;i<consult[n][0];i++) {
				if(n + i >= N || n + i + consult[n + i][0] > N) // 배열의 인덱스를 넘었거나 상담을 할 수 없는 경우
					break;
				dp[n] = Math.max(dp[n], consult[n + i][1] + maxProfit(n + i + consult[n + i][0]));
			}
		}
		
		return dp[n];
	}

}
