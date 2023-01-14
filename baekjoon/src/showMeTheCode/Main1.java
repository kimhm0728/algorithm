package showMeTheCode;

import java.util.*;
import java.io.*;

public class Main1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int[][] prefix = new int[N][2]; // 0: 왼쪽 개수, 1: 오른쪽 개수
		if(arr[0] == 1)
			prefix[0][0]++;
		else
			prefix[0][1]++;
		max = Math.max(Math.abs(prefix[0][0] - prefix[0][1]), max);
		
		// 누적합
		for(int i=1;i<N;i++) {
			prefix[i][0] = prefix[i - 1][0];
			prefix[i][1] = prefix[i - 1][1];
			
			if(arr[i] == 1)
				prefix[i][0]++;
			else
				prefix[i][1]++;
			
			max = Math.max(Math.abs(prefix[i][0] - prefix[i][1]), max);
		}
		
		int[] left = new int[3]; // 왼쪽이 더 많은 것 중 절대값이 가장 큰 것
		int[] right = new int[3]; // 오른쪽이 더 많은 것 중 절대값이 가장 큰 것
		
		for(int i=0;i<N;i++) {
			max = Math.max(Math.abs((prefix[i][0] - left[0]) - (prefix[i][1] - left[1])), max);
			max = Math.max(Math.abs((prefix[i][0] - right[0]) - (prefix[i][1] - right[1])), max);
			
			int abs = Math.abs(prefix[i][0] - prefix[i][1]);
			if(prefix[i][0] > prefix[i][1] && left[2] < abs) {
				left[0] = prefix[i][0];
				left[1] = prefix[i][1];
				left[2] = abs;
			} 
			else if(prefix[i][0] < prefix[i][1] && right[2] < abs) {
				right[0] = prefix[i][0];
				right[1] = prefix[i][1];
				right[2] = abs;
			} 
		}
		System.out.println(max);
	}

}
