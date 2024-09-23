package java.bfs;

import java.util.*;
import java.io.*;

public class B_1976 {
	static int n, m;
	static ArrayList<Integer>[] path;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		path = new ArrayList[n];
		for (int i=0;i<n;i++) path[i] = new ArrayList<>();
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				if (st.nextToken().equals("1")) path[i].add(j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		for (int i=1;i<m;i++) {
			int end = Integer.parseInt(st.nextToken()) - 1;
			if (!bfs(start, end)) {
				System.out.println("NO");
				return;
			}
			start = end;
		}
		
		System.out.println("YES");
	}

	static boolean bfs(int start, int end) {
		boolean[] visit = new boolean[n];
		visit[start] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			if (now == end) return true;
			
			for (int next : path[now]) {
				if (!visit[next]) {
					visit[next] = true;
					q.offer(next);
				}
			}
		}
		
		return false;
	}
}
