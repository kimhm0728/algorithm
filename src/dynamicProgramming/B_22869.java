package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_22869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] a = new int[N + 1];
		int[] dp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
			a[i] = Integer.parseInt(st.nextToken());

		for(int i=1;i<N;i++) {
			if(dp[i] == -1)
				continue;

			for(int j=i+1;j<=N;j++) {
				if(dp[j] == 1) 
					continue;

				if((j - i) * (1 + Math.abs(a[i] - a[j])) > K)
					dp[j] = -1;
				else
					dp[j] = 1;
			}
		}

		System.out.println(dp[N] == 1 ? "YES" : "NO");
	}

}
