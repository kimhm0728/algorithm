package skt;

import java.util.*;
import java.io.*;

public class B_15686 {
	static ArrayList<int[]> c_list = new ArrayList<>();
	static ArrayList<int[]> h_list = new ArrayList<>();
	static int n, m;
	static int[][] arr;
	static int[] chicken;
	static int c;
	static int answer = 987654321;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		chicken = new int[m];
		dp = new int[n * n][m];
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) h_list.add(new int[] {i, j});
				if (arr[i][j] == 2) c_list.add(new int[] {i, j});
			}
		}
		
		c = c_list.size();
		DFS(0, 0);
	}
	
	static void DFS(int idx, int cnt) {
		if (cnt == c) {
			//answer = Math.min(answer, BFS());
			return;
		}
		
		for (int i=idx;i<c;i++) {
			int[] temp = h_list.get(i);
			arr[temp[0]][temp[1]] = 3;
			DFS(i + 1, cnt + 1);
			arr[temp[0]][temp[1]] = 2;
		}
	}

}
