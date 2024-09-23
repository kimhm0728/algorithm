package java.practice.baekjoon;
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
			this.number = number; // ���� ��ȣ
			this.weight = weight; // ����ġ
		}
		public int compareTo(Node n) { // ����ġ�� ��������
			return this.weight - n.weight;
		}
	}
	static int V, E;
	static int[] d; // �� ������ �ִ� ��� ����
	static boolean[] visited;
	static LinkedList<Node>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // ������ ����
		E = Integer.parseInt(st.nextToken()); // ������ ����
		int first = Integer.parseInt(br.readLine()) - 1; // ���� ����
		
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
	static void dijkstra(int start) { // ���ͽ�Ʈ�� �˰���
		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		// �켱���� ť�� ���� ���� ���� ���� ��带 dequeue (�ڵ����� ����)
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