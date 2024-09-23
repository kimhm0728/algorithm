package java.practice.week11_3;

import java.util.*;
import java.io.*;

public class B_10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int key = Integer.parseInt(st.nextToken());
		
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		
		System.out.println(sb);
		br.close();
	}
	
	// ���Ѽ� ���ϱ�
	static int lowerBound(int[] arr, int key) {
		int start = 0;
		int end = arr.length;
		int mid;
		
		while(start < end) { // ������ ������
			mid = (start + end) / 2;
			
			if(arr[mid] >= key)
				end = mid;
			else 
				start = mid + 1;
		}
		
		return start;
	}
	
	// ���Ѽ� ���ϱ�
	static int upperBound(int[]arr, int key) {
		int start = 0;
		int end = arr.length;
		int mid;
		
		while(start < end) { // ������ ������
			mid = (start + end) / 2;
			
			if(arr[mid] > key)
				end = mid;
			else
				start = mid + 1;
		}
		
		return start;
	}

}
