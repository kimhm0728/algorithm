package java.binarysearch;

import java.util.*;
import java.io.*;

public class B_2512 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		
		System.out.println(upperBound());
	}
	
	static int upperBound() {
		int lo = 0;
		int hi = arr[N - 1] + 1;
		
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			if(getSumBudget(mid) <= M)
				lo = mid + 1;
			else
				hi = mid;
		}
		
		return lo - 1;
	}
	
	static int getSumBudget(int budget) {
		int sum = 0;
		int i;
		for(i=0;i<N;i++) {
			if(budget > arr[i])
				sum += arr[i];
			else
				break;
		}
		
		sum += (N - i) * budget;
		return sum;
	}

}
