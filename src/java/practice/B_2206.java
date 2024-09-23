package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2206 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int n, m;
	static int[][] board;
	static int[][][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visit = new int[2][n][m];
		
		for (int i=0;i<n;i++) {
			String s = br.readLine();
			for (int j=0;j<m;j++) {
				board[i][j] = s.charAt(j) - '0';
				visit[0][i][j] = 10000;
				visit[1][i][j] = 10000;
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Break> q = new LinkedList<>();
		
		visit[0][0][0] = 1;
		visit[1][0][0] = 1;
		q.offer(new Break(0, 0, 1, false));
		
		while(!q.isEmpty()) {
			Break now = q.poll();
			
			if (now.r == n - 1 && now.c == m - 1) {
				return now.cnt;
			}
			
			for (int i=0;i<4;i++) {
				int nextR = now.r + dir[i][0];
				int nextC = now.c + dir[i][1];
				
				if (!check(nextR, nextC)) continue;
				
				if (board[nextR][nextC] == 1 && !now.isBroken) {
					if (visit[0][nextR][nextC] <= now.cnt + 1) {
						continue;
					}
					
					q.offer(new Break(nextR, nextC, now.cnt + 1, true));
					visit[0][nextR][nextC] = now.cnt + 1;
				} else if (board[nextR][nextC] == 0) {
					if (visit[now.isBroken ? 0 : 1][nextR][nextC] <= now.cnt + 1) {
						continue;
					}
					
					q.offer(new Break(nextR, nextC, now.cnt + 1, now.isBroken));
					visit[now.isBroken ? 0 : 1][nextR][nextC] = now.cnt + 1;
				}
			}
		}
		
		return -1;
	}
	
	static boolean check(int r, int c) {
		if (r < 0 || r >= n || c < 0 || c >= m) return false;
		return true;
	}
	
	static class Break {
		int r, c, cnt;
		boolean isBroken;
		
		Break(int r, int c, int cnt, boolean isBroken) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.isBroken = isBroken;
		}
	}

}
