package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_2624 {
	static int T, K;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		arr = new int[K][2];
		
		int[] dp = new int[10001];
		dp[0] = 1;
		
		StringTokenizer st;
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		
		for(int i=0;i<K;i++) {
			int p = arr[i][0];
			int n = arr[i][1];
			
			for(int j=p;j<=p*n;j++)
				dp[j] += dp[j - p];
		}
		
		System.out.println(dp[T]);
	}

}
