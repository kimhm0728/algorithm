package java.dp;

import java.util.*;
import java.io.*;

public class B_2056 {
	static int N;
	static ArrayList<Integer>[] list;
	static int[] indegree;
	static int[] time;
	static int[] result;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		indegree = new int[N];
		time = new int[N];
		result = new int[N];
		list = new ArrayList[N];

		for(int i=0;i<N;i++)
			list[i] = new ArrayList<>();

		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());

			int cnt = Integer.parseInt(st.nextToken());
			indegree[i] = cnt;

			for(int j=0;j<cnt;j++) {
				int pre = Integer.parseInt(st.nextToken()) - 1;
				list[pre].add(i);
			}
		}

		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			if(indegree[i] == 0) {
				q.offer(i);
				result[i] = time[i];
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : list[now]) {
				result[next] = Math.max(result[next], result[now] + time[next]);
				
				if(--indegree[next] == 0)
					q.offer(next);
			}
		}
		
		int answer = 0;
		for(int i=0;i<N;i++)
			answer = Math.max(answer, result[i]);
		System.out.println(answer);
	}

}