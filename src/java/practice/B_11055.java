package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11055 {
	static int[] dp;
	static int[] num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		dp = new int[n];
		num = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = num[0];
		int answer = 0;
		for (int i=n-1;i>=0;i--) {
			answer = Math.max(answer, solution(i));
		}
		
		System.out.println(answer);
	}
	
	static int solution(int n) {
		if (dp[n] != 0) return dp[n];
		
		dp[n] = num[n];
		for(int i=n-1;i>=0;i--) {
			if (num[n] > num[i]) {
				dp[n] = Math.max(solution(i) + num[n], dp[n]);
			}
		}
		
		return dp[n];
	}

}
