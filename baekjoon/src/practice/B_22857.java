package skt;

import java.util.*;
import java.io.*;

public class B_22857 {
	static int[] num;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		num = new int[n];
		dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		int len = 0;
		int l = 0;
		int r = 0;
		int cnt = 0;
		
		while (r < n) {
			if (num[r] % 2 == 1) {
				if (cnt == k) {
					for (;;l++) {
						if (num[l] % 2 == 1) {
							cnt--;
							l++;
							break;
						} else {
							len--;
						}
					}
				}
				cnt++;
			} else {
				len++;
				answer = Math.max(answer, len);
			}
			r++;
		}
		
		System.out.println(answer);
	}

}
