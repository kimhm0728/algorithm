package graph;

import java.util.*;
import java.io.*;

public class B_9466 {
	static int n;
	static ArrayList<Integer>[] list;
	static int[] indegree;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i=0;i<T;i++) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList[n];
			indegree = new int[n];
			answer = 0;

			for (int j=0;j<n;j++) {
				list[j] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				int dest = Integer.parseInt(st.nextToken()) - 1;
				list[j].add(dest);
				indegree[dest]++;
			}

			
			sb.append(topologySort()).append('\n');
		}
		
		System.out.println(sb);
	}

	static int topologySort() {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i=0;i<n;i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		int cnt = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			cnt++;
			
			for (int next : list[now]) {
				if (--indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		return cnt;
	}

}
