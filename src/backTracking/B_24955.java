package backTracking;

import java.util.*;
import java.io.*;

public class B_24955 {
	static final int mod = 1000000007;
	static StringBuilder sb = new StringBuilder();
	static long[] num;
	static ArrayList<Integer>[] path;
	//static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		num = new long[N];
		path = new ArrayList[N];
		//visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Long.parseLong(st.nextToken());
			path[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			path[start].add(end);
			path[end].add(start);
		}
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			BFS(start, end, N);
		}
		
		System.out.println(sb);
	}
	
	static void BFS(int start, int end, int n) {
		Queue<long[]> q = new LinkedList<>();
		boolean[] visit = new boolean[n];
		visit[start] = true;
		q.offer(new long[] {start, num[start]});
		
		while(!q.isEmpty()) {
			long[] now = q.poll();
			
			if(now[0] == end) {
				sb.append(now[1]).append('\n');
				return;
			}
			
			for(int i : path[(int)now[0]]) {
				if(visit[i])
					continue;
				visit[i] = true;
				q.offer(new long[] {i, concat(now[1], num[i])});
			}
		}
	}
	
	/*
	static void DFS(int start, int end, long answer) {
		visit[start] = true;
		long temp = answer;
		answer = concat(answer, num[start]);
		
		if(start == end) {
			sb.append(answer);
			sb.append('\n');
			return;
		}

		for(int idx : path[start]) 
			if(!visit[idx])
				DFS(idx, end, answer);

		visit[start] = false;
		answer = temp;
	}
	*/

	static long concat(long x, long y) {
		long ret = x;
		
		for(long i=y;i>0;i/=10)
			ret = (ret * 10) % mod;

		return (ret + y) % mod;
	}

}
