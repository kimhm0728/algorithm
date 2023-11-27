package binarySearch;

import java.util.*;
import java.io.*;

public class B_11663 {
	static int N, M;
	static int[] dot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		dot = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) 
			dot[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(dot);
	
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = upperBound(Integer.parseInt(st.nextToken()), true);
			int end = upperBound(Integer.parseInt(st.nextToken()), false);
			
			sb.append(end - start + 1).append('\n');
		}
		
		System.out.println(sb);
	}

	static int upperBound(int key, boolean flag) {
		int lo = 0;
		int hi = N;
		
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			
			if(dot[mid] == key)
				return mid;
			if(dot[mid] < key)
				lo = mid + 1;
			else
				hi = mid;
		}
		
		return flag ? lo : lo - 1;
	}
	
}
