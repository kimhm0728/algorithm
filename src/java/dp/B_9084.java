package java.dp;

import java.util.*;
import java.io.*;

public class B_9084 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] coin = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) 
				coin[j] = Integer.parseInt(st.nextToken());
			
			int price = Integer.parseInt(br.readLine());
			int[] dp = new int[price + 1];
			dp[0] = 1;
			
			for(int j=0;j<N;j++) {
				for(int k=coin[j];k<=price;k++)
					dp[k] += dp[k - coin[j]];
			}
			
			sb.append(dp[price]).append('\n');
		}
		
		System.out.println(sb);
	}

}
