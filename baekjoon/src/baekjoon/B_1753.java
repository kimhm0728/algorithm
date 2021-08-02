package baekjoon;
import java.util.*;
import java.io.*;

public class B_1753 {
	// 인접 배열으로 구현한 그래프 (메모리 초과)
	static int V, E;
	static int[] d; // 각 정점의 최단 경로 저장
	static int[][] w; // 그래프의 가중치를 저장
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int first = Integer.parseInt(br.readLine()) - 1; // 시작 정점
		
		d = new int[V];
		Arrays.fill(d, -1);
		w = new int[V][V];
		visited = new boolean[V];
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			w[a][b] = c;
		}
		dijkstra(first);
		for(int i=0;i<V;i++) {
			if(d[i] == -1)
				System.out.println("INF");
			else
				System.out.println(d[i]);
		}
	}
	static void dijkstra(int r) {
		d[r] = 0; // 시작 정점
		int u = r;
		while(pathExists(u)) { // 경로가 존재하지 않을 때까지 반복
			u = extractMin(); 
			visited[u] = true;
			for(int i=0;i<V;i++) {
				if(w[u][i] != 0 && d[u] + w[u][i] < d[i]) 
					// u에서 i로 가는 간선이 있고 원래의 d 값보다 d[u]+가중치의 값이 더 작으면 그 값을 대입
					d[i] = d[u] + w[u][i];
				else if(w[u][i] != 0 && d[i] == -1) 
					// u에서 i로 가는 간선이 있고 d의 값이 아직 채워지지 않았으면 d[u]+가중치의 값을 대입
					d[i] = d[u] + w[u][i]; 
			}
		}
	}
	static boolean pathExists(int u) {
		// u에서 가는 경로가 하나라도 있으면 true 반환
		for(int i=0;i<V;i++)
			if(w[u][i] != 0 && visited[i] == false)
				return true;
		return false;
	}
	static int extractMin() {
		// visited가 false인 정점들 중 d 값이 가장 작은 index를 반환
		int m = Integer.MAX_VALUE; 
		for(int i=0;i<V;i++)
			if(visited[i] == false && d[i] != -1 && m > d[i])
				m = i;
		return m;
	}
}
