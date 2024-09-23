package java.practice.baekjoon;
import java.util.*;
import java.io.*;

public class B_1753 {
	// ���� �迭���� ������ �׷��� (�޸� �ʰ�)
	static int V, E;
	static int[] d; // �� ������ �ִ� ��� ����
	static int[][] w; // �׷����� ����ġ�� ����
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // ������ ����
		E = Integer.parseInt(st.nextToken()); // ������ ����
		int first = Integer.parseInt(br.readLine()) - 1; // ���� ����
		
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
		d[r] = 0; // ���� ����
		int u = r;
		while(pathExists(u)) { // ��ΰ� �������� ���� ������ �ݺ�
			u = extractMin(); 
			visited[u] = true;
			for(int i=0;i<V;i++) {
				if(w[u][i] != 0 && d[u] + w[u][i] < d[i]) 
					// u���� i�� ���� ������ �ְ� ������ d ������ d[u]+����ġ�� ���� �� ������ �� ���� ����
					d[i] = d[u] + w[u][i];
				else if(w[u][i] != 0 && d[i] == -1) 
					// u���� i�� ���� ������ �ְ� d�� ���� ���� ä������ �ʾ����� d[u]+����ġ�� ���� ����
					d[i] = d[u] + w[u][i]; 
			}
		}
	}
	static boolean pathExists(int u) {
		// u���� ���� ��ΰ� �ϳ��� ������ true ��ȯ
		for(int i=0;i<V;i++)
			if(w[u][i] != 0 && visited[i] == false)
				return true;
		return false;
	}
	static int extractMin() {
		// visited�� false�� ������ �� d ���� ���� ���� index�� ��ȯ
		int m = Integer.MAX_VALUE; 
		for(int i=0;i<V;i++)
			if(visited[i] == false && d[i] != -1 && m > d[i])
				m = i;
		return m;
	}
}
