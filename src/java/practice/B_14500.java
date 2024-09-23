package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14500 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[] reverse = {1, 0, 3, 2};
	static int answer;
	static int n, m;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				DFS(i, j, arr[i][j], 1, -1);
			}
		}
		System.out.println(answer);
	}
	
	static void DFS(int r, int c, int num, int cnt, int d) {
		if (cnt == 4) {
			answer = Math.max(answer, num);
			return;
		}
		
		if (cnt == 2) {
			if (d == 3) {
				if (check(r - 1, c) && check(r, c + 1)) {
					DFS(0, 0, num + arr[r - 1][c] + arr[r][c + 1], 4, d);
				}
				if (check(r, c + 1) && check(r + 1, c)) {
					DFS(0, 0, num + arr[r][c + 1] + arr[r + 1][c], 4, d);
				}
			} else if (d == 1) {
				if (check(r, c - 1) && check(r + 1, c)) {
					DFS(0, 0, num + arr[r][c - 1] + arr[r + 1][c], 4, d);
				}
				if (check(r, c + 1) && check(r + 1, c)) {
					DFS(0, 0, num + arr[r][c + 1] + arr[r + 1][c], 4, d);
				}
			}
		}
		
		for (int i=0;i<4;i++) {
			if (d != -1 && reverse[d] == i) continue;
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];
			
			if (check(nextR, nextC)) {
				DFS(nextR, nextC, num + arr[nextR][nextC], cnt + 1, i);
			}
		}
		
	}
	
	static boolean check(int r, int c) {
		if (r < 0 || r >= n || c < 0 || c >= m) return false;
		return true;
	}

}
