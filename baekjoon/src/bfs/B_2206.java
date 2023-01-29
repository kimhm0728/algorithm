package bfs;

import java.util.*;
import java.io.*;

public class B_2206 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N, M;
	static int[][] board;
	static boolean[][][] visit; // 벽을 부신 적이 없다면 첫 번째 인덱스 0, 벽을 부신 적이 있으면 첫 번째 인덱스 1
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visit = new boolean[2][N][M];

		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++)
				board[i][j] = str.charAt(j) - '0';
		}

		BFS();
		System.out.println(answer);
	}

	static void BFS() {
		Queue<Move> q = new LinkedList<>();

		visit[0][0][0] = true;
		q.offer(new Move(0, 0, 0, false));

		while(!q.isEmpty()) {
			Move now = q.poll();

			if(now.r == N - 1 && now.c == M - 1) {
				answer = now.dis + 1;
				return;
			}

			for(int i=0;i<4;i++) {
				int nextR = now.r + dir[i][0];
				int nextC = now.c + dir[i][1];

				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M || visit[now.flag ? 1 : 0][nextR][nextC])
					continue;

				if(!now.flag && board[nextR][nextC] == 1) {
					visit[1][nextR][nextC] = true;
					q.offer(new Move(nextR, nextC, now.dis + 1, true));
				}
				else if(board[nextR][nextC] == 0) {
					visit[now.flag ? 1 : 0][nextR][nextC] = true;
					q.offer(new Move(nextR, nextC, now.dis + 1, now.flag));
				}
			}
		}
	}

	static class Move {
		int r, c, dis;
		boolean flag;

		Move(int r, int c, int dis, boolean flag) {
			this.r = r;
			this.c = c;
			this.dis = dis;
			this.flag = flag;
		}
	}

}
