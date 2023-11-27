package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_13910 {
	static int INF = 10001;
	static int n, m;
	static int[] dp;
	static int[] wok;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dp = new int[n + 1];
		wok = new int[m];
		st = new StringTokenizer(br.readLine());
		
		for (int i=0;i<m;i++) wok[i] = Integer.parseInt(st.nextToken());
		
		int ans = cook(n);
		System.out.println(ans == INF ? -1 : ans);
	}
	
	static int cook(int x) {
		if (x == 0) return 0;
		if (dp[x] != 0) return dp[x];
		
		int temp = INF;
		for (int i=0;i<m;i++) {
			if (x - wok[i] >= 0) {
				temp = Math.min(temp, cook(x - wok[i]) + 1);
			}
			for (int j=1;j<m;j++) {
				if (i == j) continue;
				if (x - wok[i] - wok[j] >= 0) {
					temp = Math.min(temp, cook(x - wok[i] - wok[j]) + 1);
				}
			}
		}
		
		return dp[x] = temp;
	}

}
