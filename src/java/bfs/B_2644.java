package java.bfs;

import java.util.*;
import java.io.*;

public class B_2644 {
	static int N, M;
	static int start, end;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int answer = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visit = new boolean[N];
		list = new ArrayList[N];
		for(int i=0;i<N;i++)
			list[i] = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()) - 1;
		end = Integer.parseInt(st.nextToken()) - 1;
		
		M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			
			list[s].add(e);
			list[e].add(s);
		}
		
		BFS();
		System.out.println(answer);
	}
	
	static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start, 0});
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			
			int p = arr[0];
			int cnt = arr[1];
			
			if(p == end) {
				answer = cnt;
				return;
			}
			
			for(int i : list[p]) {
				if(visit[i])
					continue;
				
				visit[i] = true;
				q.offer(new int[] {i, cnt + 1});
			}
		}
	}

}
