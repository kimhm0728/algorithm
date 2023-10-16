package dynamicProgramming;

import java.io.*;

public class B_1509 {
	static char[] arr;
	static int n;
	static boolean isPalin[][];
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		arr = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		n = arr.length;
		
		isPalin = new boolean[n][n];
		dp = new int[n];
		palindrome();
		
		System.out.println(countMin(0));
	}
	
	static void palindrome() {
		for (int i=0;i<n;i++) {
			isPalin[i][i] = true;
		
			if (i != n - 1 && arr[i] == arr[i + 1]) {
				isPalin[i][i + 1] = true;
			}
		}
		
		for (int i=3;i<=n;i++) {
			for (int j=0;j<=n-i;j++) {
				if (arr[j] == arr[j + i - 1] && isPalin[j + 1][j + i - 2]) {
					isPalin[j][j + i - 1] = true;
				}
			}
		}
	}
	
	static int countMin(int start) {
		if (start == n) return 0;
		if (dp[start] != 0 ) return dp[start];
		
		int temp = 2500;
		for (int i=start;i<n;i++) {
			if (isPalin[start][i]) {
				temp = Math.min(temp, 1 + countMin(i + 1));
			}
		}
		
		return dp[start] = temp;
	}

}
