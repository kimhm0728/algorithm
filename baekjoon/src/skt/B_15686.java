package skt;

import java.util.*;
import java.io.*;

public class B_15686 {
	static int n, m;
	static int[][] arr;
	static int[][] chicken;
	static int[][] home;
	static int c, h;
	static int answer = 987654321;
	static int[][] dis;
	static boolean[] select;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		chicken = new int[n * n][2];
		home = new int[n * n][2];
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					home[h][0] = i;
					home[h][1] = j;
					h++;
				}
				if (arr[i][j] == 2) {
					chicken[c][0] = i;
					chicken[c][1] = j;
					c++;
				}
			}
		}
		
		dis = new int[c][h];
		select = new boolean[c];
		for (int i=0;i<c;i++) {
			for (int j=0;j<h;j++) {
				dis[i][j] = Math.abs(chicken[i][0] - home[j][0]) + Math.abs(chicken[i][1] - home[j][1]);
			}
		}

		DFS(0, 0);
		System.out.println(answer);
	}

	static void DFS(int idx, int cnt) {
		if (cnt == m) {
			answer = Math.min(answer, calculate());
			return;
		}

		for (int i=idx;i<c;i++) {
			select[i] = true;
			DFS(i + 1, cnt + 1);
			select[i] = false;
		}
	}
	
	static int calculate() {
		int ret = 0;
		for (int i=0;i<h;i++) {
			int min = 50;
			for (int j=0;j<c;j++) {
				if (!select[j]) continue;
				min = Math.min(min, dis[j][i]);
			}
			ret += min;
		}
		
		return ret;
	}

}
