package java.dp;

import java.io.*;

public class B_11727 {
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[1001];
		dp[1] = 1;
		dp[2] = 3;
		
		System.out.println(solution(N));
	}
	
	static int solution(int n) {
		if(dp[n] == null) {
			return dp[n] = (solution(n - 1) + solution(n - 2) * 2) % 10007;
		}
		
		return dp[n];
	}

}
