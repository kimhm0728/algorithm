package bfs;

import java.util.*;
import java.io.*;

public class B_5427 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static StringBuilder sb = new StringBuilder();
	static Queue<int[]> fire;
	static char[][] building;
	static boolean[][] visit;
	static int T, w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			fire = new LinkedList<>();
			building = new char[h][w];
			visit = new boolean[h][w];
			
			int startR = 0, startC = 0;
			for(int j=0;j<h;j++) {
				String str = br.readLine();
				for(int k=0;k<w;k++) {
					building[j][k] = str.charAt(k);
					if(building[j][k] == '@') {
						startR = j;
						startC = k;
					}
					else if(building[j][k] == '*') 
						fire.offer(new int[] {j, k});
				}
			}
			
			BFS(startR, startC);
		}
		
		System.out.println(sb);
	}
	
	static void BFS(int startR, int startC) {
		Queue<Escape> q = new LinkedList<>();
		ArrayList<int[]> temp = new ArrayList<>();
		int preTime = 0;
		
		visit[startR][startC] = true;
		q.offer(new Escape(startR, startC, 0));
		
		while(!q.isEmpty()) {
			Escape now = q.poll();
			
			if(now.time != preTime) { // 같은 시간의 위치를 모두 탐색한 경우 불을 붙이기 위해 fire에 추가
				fire.addAll(temp);
				temp.clear();
			}
			
			while(!fire.isEmpty()) { // 불이 붙으려는 칸으로 이동할 수 없으므로 미리 불 붙을 곳을 체크
				int[] f = fire.poll();
				for(int i=0;i<4;i++) {
					int fR = f[0] + dir[i][0];
					int fC = f[1] + dir[i][1];
					
					if(checkFire(fR, fC)) {
						building[fR][fC] = '*';
						temp.add(new int[] {fR, fC}); // 다음 시간에 불을 옮기기 위해 미리 저장해둠
					}
				}
			}
			
			if(checkEscape(now.r, now.c)) {
				sb.append(now.time + 1).append('\n');
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nextR = now.r + dir[i][0];
				int nextC = now.c + dir[i][1];
				
				if(checkNext(nextR, nextC)) {
					visit[nextR][nextC] = true;
					q.offer(new Escape(nextR, nextC, now.time + 1));
				}
			}
			
			preTime = now.time;
		}
		
		sb.append("IMPOSSIBLE").append('\n');
	}
	
	static boolean checkFire(int r, int c) {
		if(r < 0 || r >= h || c < 0 || c >= w || building[r][c] != '.')
			return false;
		
		return true;
	}
	
	static boolean checkNext(int r, int c) {
		if(r < 0 || r >= h || c < 0 || c >= w || visit[r][c] || building[r][c] != '.')
			return false;
		
		return true;
	}
	
	static boolean checkEscape(int r, int c) {
		if(r == 0 || r == h - 1 || c == 0 || c == w - 1)
			return true;
		
		return false;
	}
	
	static class Escape {
		int r, c, time;
		Escape(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

}
