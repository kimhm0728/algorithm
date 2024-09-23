package java.graph;

import java.util.*;
import java.io.*;

public class B_22868 {
	static int N, M;
	static ArrayList<Integer>[] list;
	static int S, E;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		for (int i=0;i<N;i++) {
			list[i] = new ArrayList<>();
		}

		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			list[s].add(e);
			list[e].add(s);
		}

		for (int i=0;i<N;i++) {
			list[i].sort((o1, o2) -> o1 - o2);
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()) - 1;
		E = Integer.parseInt(st.nextToken()) - 1;

		BFS(S, E, new StringBuilder(), 0);
		System.out.println(answer);
	}

	static void BFS(int start, int end, StringBuilder sb, int len) {
		boolean[] visit = new boolean[N];
		StringTokenizer st = new StringTokenizer(sb.toString());
		
		while(st.hasMoreTokens()) {
			visit[Integer.parseInt(st.nextToken())] = true;
		}
		
		Queue<Walk> q = new LinkedList<>();

		q.offer(new Walk(start, len, new StringBuilder()));
		
		while (!q.isEmpty()) {
			Walk now = q.poll();

			if (now.idx == end) {
				if (len == 0) {
					BFS(end, start, now.sb, now.len);
					return;
				} else {
					answer = Math.min(answer, now.len);
					continue;
				}
			}

			for (int next : list[now.idx]) {
				if (visit[next]) continue;

				visit[next] = true;
				q.offer(new Walk(next, now.len + 1, new StringBuilder(now.sb).append(next).append(' ')));
			}
		}
	}

	static class Walk {
		int idx;
		int len;
		StringBuilder sb;

		Walk(int idx, int len, StringBuilder sb) {
			this.idx = idx;
			this.len = len;
			this.sb = sb;
		}
	}
}
