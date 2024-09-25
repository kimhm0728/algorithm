import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            answer = Math.max(answer, dp[i]);

            if (i + t > n) continue;
            dp[i + t] = Math.max(answer + p, dp[i + t]);
        }

        System.out.println(Math.max(answer, dp[n]));
    }
}

// package java.dp;

// import java.util.*;
// import java.io.*;

// public class B_15486 {
// 	static int N;
// 	static int[][] consult;
// 	static int[] dp;
	
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
// 		N = Integer.parseInt(br.readLine());
// 		consult = new int[N + 1][2];
// 		dp = new int[N + 1];
		
// 		StringTokenizer st;
// 		for(int i=0;i<N;i++) {
// 			st = new StringTokenizer(br.readLine());
			
// 			consult[i][0] = Integer.parseInt(st.nextToken());
// 			consult[i][1] = Integer.parseInt(st.nextToken());
// 		}

// 		int max = 0;
// 		for(int i=0;i<=N;i++) {
// 			max = Math.max(dp[i], max);
			
// 			int next = i + consult[i][0];
// 			if(next > N)
// 				continue;
			
// 			dp[next] = Math.max(dp[next], max + consult[i][1]);
// 		}
		
// 		System.out.println(max);
// 	}

// }
