package skt;

import java.util.*;
import java.io.*;

public class B_1238 {
	static int INF = 1000000;
	static ArrayList<int[]>[] list;
	static int[][] path;
	static int n, m, x;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken()) - 1;
		
		list = new ArrayList[n];
		path = new int[n][n];
		
		for (int i=0;i<n;i++) {
			list[i] = new ArrayList<>();
			Arrays.fill(path[i], INF);
			path[i][i] = 0;
		}
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int dis = Integer.parseInt(st.nextToken());
			
			list[start].add(new int[] {end, dis});
		}

		for (int i=0;i<n;i++) dijkstra(i);
		
		int answer = 0;
		for (int i=0;i<n;i++) {
			answer = Math.max(answer, path[i][x] + path[x][i]);
		}
		
		System.out.println(answer);
	}
	
	static void dijkstra(int idx) {
		PriorityQueue<Party> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
		
		pq.offer(new Party(idx, 0));
		
		while(!pq.isEmpty()) {
			Party now = pq.poll();
			
			for (int[] next : list[now.idx]) {
				if (path[idx][next[0]] > now.cnt + next[1]) {
					path[idx][next[0]] = now.cnt + next[1];
					pq.offer(new Party(next[0], path[idx][next[0]]));
				}
			}
		}
	}
	
	static class Party {
		int idx, cnt;
		
		Party(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

}
