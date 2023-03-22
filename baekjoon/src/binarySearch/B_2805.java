package binarySearch;

import java.util.*;
import java.io.*;

public class B_2805 {
	static int N, M;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tree = new long[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++)
			tree[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(tree);
		System.out.println(upperBound());
	}
	
	static long upperBound() {
		long lo = 0;
		long hi = tree[N - 1];
		
		while(lo < hi) {
			long mid = (lo + hi) / 2;
			
			if(getTree(mid) >= M)
				lo = mid + 1;
			else 
				hi = mid;
		}
		
		return lo - 1;
	}
	
	static long getTree(long m) {
		long sum = 0;
		
		for(int i=N-1;i>=0;i--) {
			if(tree[i] > m)
				sum += tree[i] - m;
			else 
				break;
		}
		
		return sum;
	}

}
