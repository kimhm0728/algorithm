package java.bfs;

import java.util.*;
import java.io.*;

public class B_2583 {
	static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	static int M, N, K;
	static boolean[][] visit;
	static ArrayList<Integer> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean[M][N];
		answer = new ArrayList<>();
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			for(int j=M-c2;j<M-c1;j++) {
				for(int k=r1;k<r2;k++) {
					visit[j][k] = true;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j])
					answer.add(BFS(i, j));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer.size()).append('\n');
		
		Collections.sort(answer);
		for(int i : answer)
			sb.append(i).append(' ');
		
		System.out.println(sb);
	}
	
	static int BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		int area = 0;
		
		q.offer(new int[] {r, c});
		visit[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			area++;
			
			for(int i=0;i<4;i++) {
				int nextR = now[0] + dir[i][0];
				int nextC = now[1] + dir[i][1];
				
				if(check(nextR, nextC)) {
					visit[nextR][nextC] = true;
					q.offer(new int[] {nextR, nextC});
				}
			}
		}
		
		return area;
	}
	
	static boolean check(int r, int c) {
		if(r < 0 || r >= M || c < 0 || c >= N || visit[r][c])
			return false;
		
		return true;
	}

}
