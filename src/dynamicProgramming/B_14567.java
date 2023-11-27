package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_14567 {
	static int N, M;
	static ArrayList<Integer>[] list;
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		dp = new Integer[N];
		
		for(int i=0;i<N;i++)
			list[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int pre = Integer.parseInt(st.nextToken()) - 1;
			int sub = Integer.parseInt(st.nextToken()) - 1;
			
			list[sub].add(pre);
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++)
			sb.append(getSemester(i)).append(' ');
		
		System.out.println(sb);
	}
	
	static int getSemester(int n) {
		if(dp[n] == null) {
			dp[n] = 1;
			for(int i : list[n])
				dp[n] = Math.max(getSemester(i) + 1, dp[n]);
		}
		
		return dp[n];
	}

}
