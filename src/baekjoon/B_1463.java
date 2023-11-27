package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class B_1463 {
	static int[] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new int[N + 1];
		if(N == 1) System.out.println(0);
		else BFS();
	}
	static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		visited[N] = 1;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=0;i<3;i++) {
				int next;
				if(i == 0 && temp % 3 == 0)
					next = temp / 3;
				else if(i == 1 && temp % 2 == 0)
					next = temp / 2;
				else
					next = temp - 1;
				
				if(next == 1) {
					System.out.println(visited[temp]);
					return;
				}
				if(next > 0 && next < visited.length && visited[next] == 0) {
					q.offer(next);
					visited[next] = visited[temp] + 1;
				}
			}
		}
	}
}
