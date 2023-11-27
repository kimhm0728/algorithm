package binarySearch;

import java.util.*;
import java.io.*;

public class B_1654 {
	static int K, N;
	static long[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new long[K];
		
		for(int i=0;i<K;i++) 
			arr[i] = Long.parseLong(br.readLine());
		
		Arrays.sort(arr);
		System.out.println(upperBound() - 1);
	}

	static long upperBound() {
		long lo = 0;
		long hi = arr[K - 1] + 1;
		
		while(lo < hi) {
			long mid = (lo + hi) / 2;
			if(check(mid))
				lo = mid + 1;
			else 
				hi = mid;
		}
		
		return lo;
	}
	
	static boolean check(long len) {
		int cnt = 0;
		for(int i=0;i<K;i++)
			cnt += arr[i] / len;
		
		return cnt >= N ? true : false;
	}
}
