package java.bfs;

import java.util.*;
import java.io.*;

public class B_13549 {
	static int[] visit;
	static int INF = 100001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		visit = new int[INF];
		Arrays.fill(visit, INF);
		System.out.println(bfs(N, K));
	}
	
	static int bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		visit[n] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == k)
				return visit[now];
			
			for(int i=0;i<3;i++) {
				int next;
				
				if(i == 0) 
					next = now * 2;
				else if(i == 1) 
					next = now + 1;
				else 
					next = now - 1;
				
				int nextSec = i == 0 ? visit[now] : visit[now] + 1;
				if(next < 0 || next >= INF || visit[next] <= nextSec)
					continue;
				
				visit[next] = nextSec;
				q.offer(next);
			}
		}
		
		return -1;
	}

}
