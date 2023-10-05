package bfs;

import java.util.*;
import java.io.*;

public class B_1600 {
	// 0 ~ 3 : 상하좌우
	// 4 ~ 11 : 말의 이동
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},
			{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
			{1, -2}, {1, 2}, {2, -1}, {2, 1}};
	static int K, W, H;
	static int[][] arr;
	static int[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		visit = new int[H][W];
		
		for (int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<W;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				visit[i][j] = -1;
			}
		}
		
		System.out.println(BFS());
	}
	
	static int BFS() {
		Queue<Monkey> q = new LinkedList<>();
		
		visit[0][0] = K;
		q.offer(new Monkey(0, 0, K, 0));
		
		while (!q.isEmpty()) {
			Monkey now = q.poll();
			
			if (now.r == H - 1 && now.c == W - 1) {
				return now.cnt;
			}
			
			for (int i=0;i<12;i++) {
				int nextR = now.r + dir[i][0];
				int nextC = now.c + dir[i][1];
				
				int nextK = now.k;
				if (i > 3) nextK--;
				
				if (!check(nextR, nextC) || nextK < 0
						|| visit[nextR][nextC] >= nextK || arr[nextR][nextC] == 1) continue;
				
				visit[nextR][nextC] = nextK;
				q.offer(new Monkey(nextR, nextC, nextK, now.cnt + 1));
			}
		}
		
		return -1;
	}
	
	static boolean check(int r, int c) {
		if (r < 0 || r >= H || c < 0 || c >= W) return false;
		return true;
	}
	
	static class Monkey {
		int r, c, k, cnt;
		
		Monkey(int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}

}
