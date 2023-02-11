package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_10942 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		boolean[][] dp = new boolean[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			dp[i][i] = true;
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i == j)
					dp[i][j] = true;
				else {
					
				}
			}
		}
		int M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			
		}
	}

}
