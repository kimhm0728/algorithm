package java.bfs;

import java.util.*;
import java.io.*;

public class B_16397 { // 31m
	static int N, T, G;
	static boolean[] visit;
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());

		visit = new boolean[100000];

		BFS();
		if(answer == -1)
			System.out.println("ANG");
		else
			System.out.println(answer);
	}

	static void BFS() {
		Queue<int[]> q = new LinkedList<>();

		visit[N] = true;
		q.offer(new int[] {N, 0});

		while(!q.isEmpty()) {
			int[] now = q.poll();

			if(now[0] == G) {
				answer = now[1];
				return;
			}

			if(now[1] + 1 > T)
				continue;

			if(now[0] + 1 <= 99999 && !visit[now[0] + 1]) { // ��ư a
				visit[now[0] + 1] = true;
				q.offer(new int[] {now[0] + 1, now[1] + 1}); 
			}

			if(now[0] != 0 && now[0] * 2 < 100000) { // ��ư b
				StringBuilder sb = new StringBuilder();
				sb.append(now[0] * 2);
				int first = sb.charAt(0) - '0';
				int len = sb.length();
				int next;

				if(first == 1) {
					if(len == 1)
						next = 0;
					else
						next = Integer.parseInt(sb.substring(1, len));
				}
				else {
					next = Integer.parseInt(String.valueOf(first - 1) + sb.substring(1, len));
				}

				if(visit[next])
					continue;

				visit[next] = true;
				q.offer(new int[] {next, now[1] + 1});
			}
		}

	} 
}
