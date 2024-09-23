package java.practice.week11_3;

import java.io.*;
import java.util.*;

public class B_1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int find = Integer.parseInt(st.nextToken());
			
			int start = 0;
			int end = N - 1;
			int mid;
			boolean flag = false;
			
			while(start <= end) {
				mid = (start + end) / 2;
				if(arr[mid] > find) 
					end = mid - 1;
				else if(arr[mid] < find)
					start = mid + 1;
				else {
					flag = true;
					break;
				}
			}
			
			sb.append(flag ? '1' : '0').append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
