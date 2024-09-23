package java.practice.baekjoon;
import java.util.*;
import java.io.*;

public class B_1697 {
	static int[] visited = new int[100001];
	static int N;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if(N == K) System.out.println(0);
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
				if(i == 0) 
					next = temp - 1;
				else if(i == 1)
					next = temp +1;
				else
					next = temp * 2;

				if(next == K) {
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