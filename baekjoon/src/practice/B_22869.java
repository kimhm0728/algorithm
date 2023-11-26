package skt;

import java.util.*;
import java.io.*;

public class B_22869 {
	static int n, k;
	static int[] a;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n];
		dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		solution(0);
		System.out.println("NO");
	}
	
	static int solution(int i) {
		if (i >= n) return -1;
		if (i == n - 1) {
			System.out.println("YES");
			System.exit(0);
		}
		if (dp[i] != 0) return dp[i];
		
		for (int j=i+1;j<n;j++) {
			int s = (j - i) * (1 + Math.abs(a[i] - a[j]));
			if (s > k) continue;
			solution(j);
		}
		
		return dp[i] = -1;
	}
}
