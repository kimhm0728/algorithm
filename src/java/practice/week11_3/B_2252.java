package java.practice.week11_3;

import java.util.*;
import java.io.*;

public class B_2252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int indegree[] = new int[N + 1];
		ArrayList<Integer> list[] = new ArrayList[N + 1];
		
		for(int i=1;i<=N;i++)
			list[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			list[pre].add(next);
			indegree[next]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=N;i++)
			if(indegree[i] == 0)
				q.offer(i);
		
		while(!q.isEmpty()) {
			int idx = q.poll();
			sb.append(idx).append(' ');
			
			for(int i : list[idx])
				if(--indegree[i] == 0)
					q.offer(i);
		}
			
		System.out.println(sb);
		br.close();
	}

}
