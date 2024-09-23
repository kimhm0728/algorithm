package java.dp;

import java.io.*;

public class B_2631 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		dp[0] = 1;
		
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int answer = 1;
		for(int i=1;i<N;i++) {
			dp[i] = 1;
			for(int j=i-1;j>=0;j--)
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(N - answer);
	}

}
