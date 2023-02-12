package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_10942 {
	static int N;
	static int[] arr;
	static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		dp = new boolean[N][N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			dp[i][i] = true;
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0;i<N;i++) {
			dp[i][i] = true; // 팰린드롬 길이가 1인 경우

			if(i != N - 1 && arr[i] == arr[i + 1]) // 팰린드롬 길이가 2인 경우
				dp[i][i + 1] = true;
		}

		for(int i=3;i<=N;i++)
			solution(i);

		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) -1;

			sb.append(dp[start][end] ? "1" : "0").append('\n');
		}

		System.out.println(sb);
	}

	// 팰린드롬 길이가 len인 경우
	static void solution(int len) {
		for(int i=0;i<=N-len;i++) 
			if(arr[i] == arr[i + len - 1] && dp[i + 1][i + len - 2])
				dp[i][i + len - 1] = true;
	}

}
