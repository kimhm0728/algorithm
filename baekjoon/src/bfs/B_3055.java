package bfs;

import java.util.*;
import java.io.*;

public class B_3055 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Queue<int[]> water = new LinkedList<>();
	static int R, C;
	static char[][] forest;
	static boolean[][] visit;
	static int answer = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		forest = new char[R][C];
		visit = new boolean[R][C];
		
		int startR = 0, startC = 0;
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				forest[i][j] = str.charAt(j);
				if(forest[i][j] == 'S') {
					startR = i;
					startC = j;
				}
				else if(forest[i][j] == '*') {
					water.add(new int[] {i, j});
				}
			}
		}
		
		BFS(startR, startC);
		if(answer == -1)
			System.out.println("KAKTUS");
		else 
			System.out.println(answer);
	}
	
	static void BFS(int startR, int startC) {
		Queue<Cave> q = new LinkedList<>();
		ArrayList<int[]> temp = new ArrayList<>();
		
		int preTime = 0;
		visit[startR][startC] = true;
		q.offer(new Cave(startR, startC, 0));
		
		while(!q.isEmpty()) {
			Cave now = q.poll();
			
			if(preTime != now.time) {
				water.addAll(temp);
				temp.clear();
			}
			
			while(!water.isEmpty()) {
				int[] w = water.poll();
				
				for(int i=0;i<4;i++) {
					int wR = w[0] + dir[i][0];
					int wC = w[1] + dir[i][1];
					
					if(check(wR, wC) && forest[wR][wC] == '.') {
						forest[wR][wC] = '*';
						temp.add(new int[] {wR, wC});
					}
				}
			}
			
			if(forest[now.r][now.c] == 'D') {
				answer = now.time;
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nextR = now.r + dir[i][0];
				int nextC = now.c + dir[i][1];
				
				if(check(nextR, nextC) && forest[nextR][nextC] != '*' &&
						forest[nextR][nextC] != 'X' && !visit[nextR][nextC]) {
					visit[nextR][nextC] = true;
					q.offer(new Cave(nextR, nextC, now.time + 1));
				}
			}
			
			preTime = now.time;
		}
	}
	
	static boolean check(int r, int c) {
		if(r < 0 || r >= R || c < 0 || c >= C)
			return false;
		
		return true;
	}
	static class Cave {
		int r, c, time;
		Cave(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

}
