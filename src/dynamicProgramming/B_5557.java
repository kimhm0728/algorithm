package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_5557 {
	static int N;
	static int[] num;
	static Long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		num = new int[N];
		dp = new Long[N][21];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) 
			num[i] = Integer.parseInt(st.nextToken());

		System.out.println(countEquation(0, num[0]));
	}

	static long countEquation(int n, int result) {
		if(result < 0 || result > 20)
			return 0;

		if(n == N - 2) 
			return result == num[N - 1] ? 1 : 0;

		if(dp[n][result] != null) 
			return dp[n][result];

		dp[n][result] = (long)0;
		return dp[n][result] += countEquation(n + 1, result - num[n + 1]) + countEquation(n + 1, result + num[n + 1]);
	}

}
