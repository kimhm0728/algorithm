package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_1548 {
	static int N;
	static int[] arr;
	static int answer = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++)
				answer = Math.max(getDistance(i, j), answer);
		}
		
		System.out.println(answer);
	}
	
	static int getDistance(int start, int end) {
		int n = end - start + 1;
		if(n < 3)
			return n;
		
		if(arr[end] >= arr[start] + arr[start + 1])
			return -1;
		
		return n;
	}

}
