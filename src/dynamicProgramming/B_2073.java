package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_2073 {
	static int max = (int)Math.pow(2, 23) + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int D = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[] dp = new int[D + 1];
		dp[0] = max;

		for(int i=1;i<=P;i++) {
			st = new StringTokenizer(br.readLine());

			int l = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			for(int j=D;j>=l;j--) 
				dp[j] = Math.max(dp[j], Math.min(c, dp[j - l]));
		}

		System.out.println(dp[D]);
	}

}
