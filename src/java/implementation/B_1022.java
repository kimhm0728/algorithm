package java.implementation;

import java.util.*;
import java.io.*;

public class B_1022 {
	static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		int max = Math.max(Math.max(Math.abs(r1), Math.abs(c1)),
				Math.max(Math.abs(r2), Math.abs(c2)));
		int n = r2 - r1 + 1;
		int m = c2 - c1 + 1;
		int[][] arr = new int[n][m];
		
		int r = max;
		int c = max;
		int num = 1;
		
		if (r < n && c < m) arr[r][c] = num;
		
		int cnt = 1;
		
		int s = 0;
		W: while (true) {
			s = s == 4 ? 0 : s;
			for (;s<4;s++) {
				for (int j=0;j<cnt;j++) {
					r += dir[s][0];
					c += dir[s][1];
					
					if (num > (int) Math.pow(max * 2 + 1, 2)) break W;
					
					int newR = r - max - r1;
					int newC = c - max - c1;
					if (newR < 0 || newR >= n || newC < 0 || newC >= m) {
						++num;
						continue;
					}

					arr[newR][newC] = ++num;
				}
				
				if (s == 1 || s == 3) cnt++;
			}
		}
		
		max = 0;
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				max = Math.max(max, arr[i][j]);
			}
		}
		
		int len = String.valueOf(max).length();
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				int diff = len - String.valueOf(arr[i][j]).length();
				
				for (int k=0;k<diff;k++) {
					sb.append(' ');
				}
				
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
