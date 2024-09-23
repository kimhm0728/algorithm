package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_4485 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] arr;
	static int[][] visit;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int idx = 1;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			arr = new int[n][n];
			visit = new int[n][n];
			
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					visit[i][j] = 987654321;
				}
			}
			
			sb.append("Problem " + idx++ + ": ").append(dijkstra()).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int dijkstra() {
		PriorityQueue<Jelda> pq = new PriorityQueue<>((o1, o2) -> o1.fee - o2.fee);
		
		pq.offer(new Jelda(0, 0, arr[0][0]));
		visit[0][0] = arr[0][0];
		
		while (!pq.isEmpty()) {
			Jelda now = pq.poll();
			
			if (now.r == n - 1 && now.c == n - 1) {
				return now.fee;
			} 
			
			for (int i=0;i<4;i++) {
				int nextR = now.r + dir[i][0];
				int nextC = now.c + dir[i][1];
				
				if (!check(nextR, nextC) || visit[nextR][nextC] <= now.fee + arr[nextR][nextC]) {
					continue;
				}
				
				pq.offer(new Jelda(nextR, nextC, now.fee + arr[nextR][nextC]));
				visit[nextR][nextC] = now.fee + arr[nextR][nextC];
			}
		}
		
		return -1;
	}
	
	static boolean check(int r, int c) {
		if (r < 0 || r >= n || c < 0 || c >= n) return false;
		return true;
	}
	
	static class Jelda {
		int r, c, fee;
		
		Jelda(int r, int c, int fee) {
			this.r = r;
			this.c = c;
			this.fee = fee;
		}
	}

}
