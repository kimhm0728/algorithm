package java.practice.week11_3;

import java.util.*;
import java.io.*;

public class B_1238 {
	static int N, M, X;
	static int INF = 100001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> list[] = new ArrayList[N + 1];
		ArrayList<int[]> reverse[] = new ArrayList[N + 1];
		
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
			reverse[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[start].add(new int[] {end, cost});
			reverse[end].add(new int[] {start, cost});
		}
		
		int result1[] = dijkstra(list);
		int result2[] = dijkstra(reverse);
		
		int max = result1[1] + result2[1];
		for(int i=2;i<=N;i++)
			max = Math.max(max, result1[i] + result2[i]);
		
		System.out.println(max);
	}
	
	static int[] dijkstra(ArrayList<int[]> list[]) {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		boolean visit[] = new boolean[N + 1];
		int result[] = new int[N + 1];
		Arrays.fill(result, INF);
		
		q.offer(new int[] {X, 0});
		result[X] = 0;
		
		while(!q.isEmpty()) {
			int idx = q.poll()[0];

			if(!visit[idx]) {
				visit[idx] = true;
				for(int[] temp : list[idx]) {
					if(!visit[temp[0]] && result[temp[0]] > result[idx] + temp[1]) {
						result[temp[0]] = result[idx] + temp[1];
						q.offer(new int[] {temp[0], result[temp[0]]});
					}
				}
			}
		}
		
		return result;
	}

}
