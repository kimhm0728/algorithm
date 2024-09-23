package java.practice.week1_2;

import java.util.*;
import java.io.*;

public class B_24956 {
	static int mod = 1_000_000_007;
	static int[][] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N][N];
		
		String str = br.readLine();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		
		for(int i=0;i<N;i++) 
			if(str.charAt(i) == 'E')
				list.add(i);
		
		Integer[] arr = list.toArray(new Integer[0]);
		
		long answer = 0;
		int w_start = 0;
		while(true) {
			// w ��ġ ã��
			int w_idx = str.indexOf("W", w_start);
			if(w_idx == -1)
				break;
			
			w_start = w_idx + 1;
			int h_start = w_idx;
			while(true) {
				// h ��ġ ã��
				int h_idx = str.indexOf("H", h_start);
				if(h_idx == -1)
					break;
				
				h_start = h_idx + 1;
				int cnt = binarySearch(arr, h_idx); // ã�� w, h �ε��� ���� e ���� ã��
				for(int i=cnt;i>=2;i--)
					answer += combination(cnt, i) % mod;
			}
		}
		
		System.out.println(answer % mod);
	}
	
	// ���Ѽ� �̺�Ž��
	static int binarySearch(Integer[] arr, int key) {
		int n = arr.length;
		int left = 0;
		int right = n;
		int mid = 0;
		
		while(left < right) {
			mid = left + (right - left) / 2;
			if(key <= arr[mid]) 
				right = mid;
			else 
				left = mid + 1;
		}
		
		return n - left;
	} 
	
	static int combination(int n, int r) {
		if(memo[n][r] != 0)
			return memo[n][r];
		
		if(n == r || r == 0)
			return memo[n][r] = 1;
		
		return memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}

}
