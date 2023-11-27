package binarySearch;

import java.util.*;
import java.io.*;

public class B_10816 {
	static int[] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for(int i=0;i<M;i++) {
			int key = Integer.parseInt(st.nextToken());
			int lo = lowerBound(key);
			int hi = upperBound(key);
			sb.append(hi - lo).append(' ');
		}

		System.out.println(sb);
	}

	static int lowerBound(int key) {
		int lo = 0;
		int hi = N;

		while(lo < hi) {
			int mid = (lo + hi) / 2;
			if(arr[mid] >= key)
				hi = mid;
			else
				lo = mid + 1;
		}

		return lo;
	}

	static int upperBound(int key) {
		int lo = 0;
		int hi = N;

		while(lo < hi) {
			int mid = (lo + hi) / 2;
			if(arr[mid] <= key)
				lo = mid + 1;
			else
				hi = mid;
		}

		return lo;
	}

}
