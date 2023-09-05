package skt;

import java.util.*;
import java.io.*;

public class B_14391 {
	static int[][] dir = {{1, 0}, {0, 1}};
	static int n, m;
	static int[][] arr;
	static boolean[] visit;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new boolean[n * m];
		
		for (int i=0;i<n;i++) {
			String s = br.readLine();
			for (int j=0;j<m;j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		DFS(0, 0);
		System.out.println(answer);
	}
	
	static void DFS(int idx, int result) {
		if (idx == n * m) {
			answer = Math.max(answer, result);
			return;
		}
		
		if (visit[idx]) {
			DFS(idx + 1, result);
			return;
		}

		int r = idx / m;
		int c = idx % m;
		visit[idx] = true;
		DFS(idx + 1, result + arr[r][c]);
		
		for (int i=0;i<2;i++) {
			int nextR = r;
			int nextC = c;
			int temp = arr[r][c];
			ArrayList<Integer> remove_list = new ArrayList<>();
			
			while (true) {
				nextR += dir[i][0];
				nextC += dir[i][1];
				int nextIdx = nextR * m + nextC;
				
				if (!check(nextR, nextC) || visit[nextIdx]) break;
				
				temp = temp * 10 + arr[nextR][nextC];
				visit[nextIdx] = true;
				remove_list.add(nextIdx);
				DFS(idx + 1, result + temp);
			}
			
			for (int remove : remove_list) {
				visit[remove] = false;
			}
		}
		
		visit[idx] = false;
	}
	
	static boolean check(int r, int c) {
		if (r < 0 || r >= n || c < 0 || c >= m) return false;
		return true;
	}

}
