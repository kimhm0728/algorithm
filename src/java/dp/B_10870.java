package java.dp;

import java.io.*;

public class B_10870 {
	static int[] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		d = new int[N + 1];
		System.out.println(dp(N));
	}
	
	static int dp(int n) {
		if(d[n] != 0)
			return d[n];
		
		if(n == 0)
			return 0;
		
		if(n == 1)
			return d[n] = 1;
		
		return d[n] = dp(n - 1) + dp(n - 2);
	}

}
