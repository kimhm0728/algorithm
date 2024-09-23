package java.dp;

import java.io.*;

public class B_1823 {
	static int N;
	static int[] v;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		v = new int[N];
		dp = new int[N][N];
		for(int i=0;i<N;i++) 
			v[i] = Integer.parseInt(br.readLine());
		
		System.out.println(harvest(0, N - 1, 1));
	}
	
	// �ݷ�: 5 2 2 1 2 
	// ����: 18
	// ����: 17 
	static int harvest(int l, int r, int n) {
		if(l > r)
			return 0;
		if(l == r)
			return v[l] * n;
		
		if(dp[l][r] != 0)
			return dp[l][r];
		
		int first = dp[l][r] = v[l] * n + harvest(l + 1, r, n + 1);
		int last = dp[l][r] = v[r] * n + harvest(l, r - 1, n + 1);
		
		return dp[l][r] = Math.max(first, last);
	}

}
