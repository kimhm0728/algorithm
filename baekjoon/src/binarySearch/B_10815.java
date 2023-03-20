package binarySearch;

import java.util.*;
import java.io.*;

public class B_10815 {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++)
			sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append(' ');
		
		System.out.println(sb);
	}

	static int binarySearch(int key) {
		int lo = 0;
		int hi = N - 1;
		
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			if(arr[mid] < key) 
				lo = mid + 1;
			else if(arr[mid] > key)
				hi = mid - 1;
			else 
				return 1;
		}
		
		return 0;
	}
}
