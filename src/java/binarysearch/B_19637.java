package java.binarysearch;

import java.util.*;
import java.io.*;

public class B_19637 {
	static int N, M;
	static String[] title;
	static int[] power;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		title = new String[N];
		power = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			title[i] = st.nextToken();
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) 
			sb.append(lowerBound(Integer.parseInt(br.readLine()))).append('\n');
		
		System.out.println(sb);
	}
	
	static String lowerBound(int key) {
		int lo = 0;
		int hi = N;
		
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			
			if(power[mid] >= key)
				hi = mid;
			else
				lo = mid + 1;
		}
		
		return title[lo];
	}

}
