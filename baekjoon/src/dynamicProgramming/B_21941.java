package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_21941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());

		int len = str.length();
		int[] dp = new int[len + 1];
		Delete[] arr = new Delete[N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Delete(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0;i<len;i++) {
			dp[i + 1] = Math.max(dp[i + 1], dp[i] + 1);
			
			for(Delete d : arr) {
				if(str.startsWith(d.str, i)) {
					dp[i + d.length] = Math.max(dp[i + d.length], dp[i] + d.score);
				}
			}
		}
		
		System.out.println(dp[len]);
		
	}
	
	static class Delete {
		String str;
		int score;
		int length;
		
		Delete(String str, int score) {
			this.str = str;
			this.score = score;
			length = str.length();
		}
	}

}
