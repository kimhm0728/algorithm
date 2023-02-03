package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_15486 {
	static int N;
	static int[][] consult;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		consult = new int[N + 1][2];
		dp = new int[N + 1];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			consult[i][0] = Integer.parseInt(st.nextToken());
			consult[i][1] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for(int i=0;i<=N;i++) {
			max = Math.max(dp[i], max);
			
			int next = i + consult[i][0];
			if(next > N)
				continue;
			
			dp[next] = Math.max(dp[next], max + consult[i][1]);
		}
		
		System.out.println(max);
	}

}
