package baekjoon;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1753_1 {
	static class Node implements Comparable<Node> {
		int number, weight;
		
		public Node(int number, int weight) {
			this.number = number; // 정점 번호
			this.weight = weight; // 가중치
		}
		public int compareTo(Node n) { // 가중치의 오름차순
			return this.weight - n.weight;
		}
	}
	static int V, E;
	static int[] d; // 각 정점의 최단 경로 저장
	static boolean[] visited;
	static LinkedList<Node>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int first = Integer.parseInt(br.readLine()) - 1; // 시작 정점
		
		d = new int[V];
		Arrays.fill(d, -1);
		visited = new boolean[V];
		graph = new LinkedList[V];

		for(int i=0;i<V;i++)
			graph[i] = new LinkedList<Node>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, c));
		}
		dijkstra(first);
		
		for(int i=0;i<V;i++) {
			if(d[i] == -1)
				System.out.println("INF");
			else
				System.out.println(d[i]);
		}
	}
	static void dijkstra(int start) { // 다익스트라 알고리즘
		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		// 우선순위 큐를 통해 값이 가장 작은 노드를 dequeue (자동으로 정렬)
		pq.offer(new Node(start, 0));
		d[start] = 0;
		while(!pq.isEmpty()) { 
			Node now = pq.poll();
			visited[now.number] = true;
			for(Node next : graph[now.number]) 
				if(d[now.number] + next.weight < d[next.number] || d[next.number] == -1) {
					d[next.number] = d[now.number] + next.weight;
					pq.offer(new Node(next.number, d[next.number]));
				}
		}
	}
}