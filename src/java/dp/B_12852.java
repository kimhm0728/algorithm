package java.dp;

import java.io.*;

public class B_12852 {
	static int[] dp;
	static int[] str;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n + 1];
		str = new int[n + 1];
		
		System.out.println(getMinOper(n));
		
		StringBuilder sb = new StringBuilder();
		
		while(n != 0) {
			sb.append(n).append(' ');
			n = str[n];
		}
		
		System.out.println(sb);
	}
	
	static int getMinOper(int n) {
		if (dp[n] != 0 || n == 1) {
			return dp[n];
		}
		
		str[n] = n - 1;
		int temp = getMinOper(n - 1);
		
		if (n % 3 == 0) {
			int result = getMinOper(n / 3);
			if (temp > result) {
				temp = result;
				str[n] = n / 3;
			}
		}
		if (n % 2 == 0) {
			int result = getMinOper(n / 2);
			if (temp > result) {
				temp = result;
				str[n] = n / 2;
			}
		}

		return dp[n] = temp + 1;
	}

}
