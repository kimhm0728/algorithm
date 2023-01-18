package backTracking;

import java.util.*;
import java.io.*;

public class B_22944 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N, H, D;
	static int answer = -1;
	static char[][] board;
	static int[][] visit; // 우산 내구도 + 체력을 저장. 만약 visit값이 next의 내구도 + 체력보다 크다면 가지 않기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		board = new char[N][N];
		visit = new int[N][N];

		int startR = 0, startC = 0;
		boolean flag = false;

		for(int i=0;i<N;i++) {
			board[i] = br.readLine().toCharArray();
			if(!flag)
				for(int j=0;j<N;j++) {
					if(board[i][j] == 'S') {
						startR = i;
						startC = j;
						flag = true;
					}
				}
		}
		
		BFS(startR, startC);
		System.out.println(answer);

	}

	static void BFS(int startR, int startC) {
		Queue<Rain> q = new LinkedList<>();
		q.offer(new Rain(startR, startC, H, 0, false, 0));
		visit[startR][startC] = H;

		while(!q.isEmpty()) {
			Rain now = q.poll();

			for(int i=0;i<4;i++) {
				int nextR = now.r + dir[i][0];
				int nextC = now.c + dir[i][1];

				if(nextR < 0 || nextR >= N || nextC < 0   || nextC >= N)
					continue;

				if(board[nextR][nextC] == 'U') { // 다음 위치에 우산이 있다면 우산을 듦
					if(visit[nextR][nextC] >= now.h + D - 1)
						continue;
					visit[nextR][nextC] = D - 1 + now.h;
					q.offer(new Rain(nextR, nextC, now.h, now.cnt + 1, true, D - 1));
				}
				else if(board[nextR][nextC] == '.') { // 죽음의 비
					if(now.umbrella) { // 우산을 가지고 있다면 우산 내구도 - 1
						if(visit[nextR][nextC] >= now.h + now.umbrellaH - 1) 
							continue;
						if(now.umbrellaH - 1 == 0) // 우산의 내구도가 0이라면 우산이 사라짐
							q.offer(new Rain(nextR, nextC, now.h, now.cnt + 1, false, 0));
						else 
							q.offer(new Rain(nextR, nextC, now.h, now.cnt + 1, true, now.umbrellaH - 1));
						visit[nextR][nextC] = now.h + now.umbrellaH - 1;
					}
					else { // 우산이 없다면 체력 - 1
						if(now.h - 1 == 0 || visit[nextR][nextC] >= now.h - 1) // 체력이 0이라면 죽음
							continue;
						visit[nextR][nextC] = now.h - 1;
						q.offer(new Rain(nextR, nextC, now.h - 1, now.cnt + 1, false, 0));
					}
				}
				else if(board[nextR][nextC] == 'E') {
					answer = now.cnt + 1;
					return;
				}
			}
		}
	}

	static class Rain {
		boolean umbrella = false; // 우산 여부
		int umbrellaH = 0; // 우산 내구도
		int r, c, h; // 행, 열, 체력
		int cnt; // 이동 횟수

		Rain(int r, int c, int h, int cnt, boolean umbrella, int umbrellaH) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.cnt = cnt;
			this.umbrella = umbrella;
			this.umbrellaH = umbrellaH;
		}
	}

}