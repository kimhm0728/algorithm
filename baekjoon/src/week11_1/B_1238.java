package week11_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_1238 {
	static int INF = 1000000000;
	static boolean visit[];
	static int N, M, X;
	static List<List<Node>> list = new ArrayList<>();
	static List<List<Node>> reverseList = new ArrayList<>();
	
	static class Node implements Comparable<Node> {
		int end, weight;
		
		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.weight - n.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;
		
		for(int i=0;i<N;i++) {
			list.add(new ArrayList<>());
			reverseList.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, w));
			reverseList.get(b).add(new Node(a, w));
		}
		
		int result1[] = dijkstra(list);
		int result2[] = dijkstra(reverseList);

		int time = -1;
		for(int i=0;i<N;i++) {
			time = Math.max(result1[i] + result2[i], time);
		}

		System.out.println(time);
	}

	static int[] dijkstra(List<List<Node>> list) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean visit[] = new boolean[N];
		int[] arr = new int[N];
		
		Arrays.fill(arr, INF);
		arr[X] = 0;
		
		q.offer(new Node(X, 0));
		
		while(!q.isEmpty()) {
			int idx = q.poll().end;
			
			if(!visit[idx]) {
				visit[idx] = true;
				
				for(Node node : list.get(idx)) {
					if(!visit[node.end] && arr[node.end] > arr[idx] + node.weight) {
						arr[node.end] = arr[idx] + node.weight;
						q.add(new Node(node.end, arr[node.end]));
					}
				}
			}
		}
		
		return arr;
	}

}
