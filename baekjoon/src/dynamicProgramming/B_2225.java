package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_2225 {
	static final int div = 1000000000;
	static int N, K;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		dp = new int[K + 1][N + 1];
		
        Arrays.fill(dp[1], 1);
        for(int i=1;i<=K;i++)
            dp[i][0] = 1;
        
        for(int i=2;i<=K;i++) {
            for(int j=1;j<=N;j++)
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % div;
        }
        
		System.out.println(dp[K][N]);
	}
    
}