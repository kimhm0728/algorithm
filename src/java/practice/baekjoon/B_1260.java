package java.practice.baekjoon;
import java.util.*;
import java.io.*;

public class B_1260 {
	static int[][] graph;
	static int[] visited;
	static int N, M, V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // ������ ����
		M = Integer.parseInt(st.nextToken()); // ������ ����
		V = Integer.parseInt(st.nextToken()) - 1; // ���� ����
		graph = new int[N][N];
		visited = new int[N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1; // �迭�� �ε����� 0 ~ N-1�̹Ƿ�
			int b = Integer.parseInt(st.nextToken()) - 1;
			graph[a][b] = graph[b][a] = 1;
		}
		DFS(V);
		System.out.println();
		Arrays.fill(visited, 0);
		BFS(V);
	}
	static void DFS(int start) {
		System.out.print(start+1+" ");
		visited[start] = 1;
		for(int i=0;i<N;i++)
			if(visited[i] == 0 && graph[start][i] == 1)
				DFS(i);
	}
	static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = 1;
		while(!q.isEmpty()) {
			int t = q.poll();
			System.out.print(t+1+" ");
			for(int i=0;i<N;i++)
				if(visited[i] == 0 && graph[t][i] == 1) {
					q.add(i);
					visited[i] = 1;
				}
		}
	}
}
