package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_14501 {
	static int N;
	static int[][] arr;
	static int[] visit; // 0: �湮x 1: ����� �� x 2: �湮o
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		visit = new int[N];
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			if(i + arr[i][0] > N)
				visit[i] = 1;
		}
		
		DFS(0, 0);
		System.out.println(answer);
	}

	static void DFS(int profit, int start) {
		answer = Math.max(answer, profit);
		
		for(int i=start;i<N;i++) {
			if(visit[i] != 0)
				continue;
			
			for(int j=i;j<i+arr[i][0];j++) 
				visit[j] = visit[j] == 1 ? 1 : 2;
			
			DFS(profit + arr[i][1], i + 1);
			
			for(int j=i;j<i+arr[i][0];j++)
				visit[j] = visit[j] == 1 ? 1 : 0;
		}
	}
}
