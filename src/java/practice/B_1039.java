package java.practice;

import java.util.*;
import java.io.*;

public class B_1039 {
	static HashSet<String>[] visit;
	static int answer = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String n = st.nextToken();
		int len = n.length();
		int k = Integer.parseInt(st.nextToken());
		
		visit = new HashSet[2];
		for (int i=0;i<2;i++) {
			visit[i] = new HashSet<>();
		}
		
		bfs(n, k, len);
		System.out.println(answer);
	}

	static void bfs(String n, int k, int len) {
		Queue<Swap> q = new LinkedList<>();
		q.offer(new Swap(n, 0));
		
		while (!q.isEmpty()) {
			Swap now = q.poll();
			
			if (now.cnt != 0 && now.cnt % 2 == k % 2) {
				answer = Math.max(answer, Integer.parseInt(now.n));
				if (now.cnt == k) continue;
			}
			
			for (int i=0;i<len;i++) {
				for (int j=i+1;j<len;j++) {
					if (i == 0 && now.n.charAt(j) == '0') continue;
					
					String next = now.n.substring(0, i) + now.n.charAt(j) + now.n.substring(i + 1, j)
						+ now.n.charAt(i) + now.n.substring(j + 1, len); 
					if (visit[(now.cnt + 1) % 2].add(next)) {
						q.offer(new Swap(next, now.cnt + 1));
					}
				}
			}
		}
	}
	
	static class Swap {
		String n;
		int cnt;
		
		Swap(String n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
}
