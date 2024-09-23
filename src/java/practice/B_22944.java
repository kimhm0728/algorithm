package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_22944 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N, H, D;
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		board = new char[N][N];
		
		int startR = 0;
		int startC = 0;
		for (int i=0;i<N;i++) {
			String s = br.readLine();
			for (int j=0;j<N;j++) {
				board[i][j] = s.charAt(j);
				if (board[i][j] == 'S') {
					startR = i;
					startC = j;
				}
			}
		}
		
		System.out.println(BFS(startR, startC));
	}
	
	static int BFS(int startR, int startC) {
		Queue<Rain> q = new LinkedList<>();
		int[][] visit = new int[N][N];
		
		q.offer(new Rain(startR, startC, H, 0, 0));
		visit[startR][startC] = H;
		
		while (!q.isEmpty()) {
			Rain now = q.poll();
			
			for (int i=0;i<4;i++) {
				int nextR = now.r + dir[i][0];
				int nextC = now.c + dir[i][1];
				
				if (!check(nextR, nextC)) continue;
				if (board[nextR][nextC] == 'E') return now.dis + 1;
				
				int nextH = now.h;
				int nextD = now.d;
				if (board[nextR][nextC] == 'U') {
					nextD = D - 1;
				} else {
					if (now.d > 0) nextD--;
					else if (now.h - 1 > 0) nextH--;
					else continue;
				}
				
				if(visit[nextR][nextC] >= nextD + nextH) continue;
				visit[nextR][nextC] = nextD + nextH;
				
				q.offer(new Rain(nextR, nextC, nextH, nextD, now.dis + 1));
			}
		}
		
		return -1;
	}
	
	static boolean check(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) return false;
		return true;
	}
	
	static class Rain {
		int r, c, h, d, dis;
		
		Rain(int r, int c, int h, int d, int dis) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.d = d;
			this.dis = dis;
		}
	}

}
