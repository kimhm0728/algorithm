package skt;

import java.util.*;
import java.io.*;

public class B_1548 {
	static int[] arr;
	static int answer = 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		if (n < 3) {
			System.out.println(n);
			return;
		}
		
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int l = 0;
		int r = 2;
		while (r < n) {
			if (arr[l] + arr[l + 1] > arr[r]) {
				answer = Math.max(answer, r - l + 1);
			} else {
				l++;
			}
			r++;	
		}
		
		System.out.println(answer);
	}

}
