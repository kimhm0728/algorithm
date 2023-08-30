package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_2565 {
	static int answer = 1;
	static int n;
	static int[] dp;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new int[n];
		num = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		for (int i=1;i<n;i++) {
			dp[i] = 1;
			for (int j=0;j<i;j++) {
				if (num[j] > num[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}

}
