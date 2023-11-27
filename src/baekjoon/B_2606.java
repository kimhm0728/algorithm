package baekjoon;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B_2606 {
	static int[][] com;
	static int[] visited;
	static int count = 0;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int R = Integer.parseInt(br.readLine());
		com = new int[N][N];
		visited = new int[N];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			com[a][b] = 1;
			com[b][a] = 1;
		}
		DFS(0); // 1번 컴퓨터가 com배열의 0번 인덱스이므로
		System.out.println(count);
	}
	static void DFS(int n) {
		visited[n] = 1;
		for(int i=0;i<N;i++)
			if(com[n][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				count++;
				DFS(i);
			}
	}
}