package java.backtracking;

import java.util.*;
import java.io.*;

public class B_1976 {
	static int n, m;
	static boolean[] visit;
	static boolean flag;
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
			visit = new boolean[n];
			flag = false;
			
			int end = Integer.parseInt(st.nextToken()) - 1;
			dfs(start, end);
			if (!flag) {
				System.out.println("NO");
				return;
			}
			start = end;
		}
		
		System.out.println("YES");
	}

	static void dfs(int start, int end) {
		if (start == end) {
			flag = true;
			return;
		}
		
		for (int next : path[start]) {
			if (flag) return;
			if (!visit[next]) {
				visit[next] = true;
				dfs(next, end);
			}
		}
	}
}
