package java.dp;

import java.util.*;
import java.io.*;

public class B_1695 {
	static int N;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		dp = new int[N][N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			Arrays.fill(dp[i], -1);
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(palindrome(0, N - 1));
	}

	static int palindrome(int l, int r) {
		if(l >= r)
			return 0;

		if(dp[l][r] != -1)
			return dp[l][r];

		if(arr[l] == arr[r])
			dp[l][r] = palindrome(l + 1, r - 1);
		else
			dp[l][r] = Math.min(palindrome(l + 1, r), palindrome(l, r - 1)) + 1;

		return dp[l][r];
	}
}
