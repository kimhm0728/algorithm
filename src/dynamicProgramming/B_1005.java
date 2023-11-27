package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_1005 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		Loop: for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] time = new int[N];
			int[] indegree = new int[N];
			int[] dp = new int[N];
			ArrayList<Integer>[] list = new ArrayList[N];

			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				list[j] = new ArrayList<>();
				time[j] = Integer.parseInt(st.nextToken());
			}

			for(int j=0;j<K;j++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;

				indegree[end]++;
				list[start].add(end);
			}

			int W = Integer.parseInt(br.readLine()) - 1;

			Queue<Integer> q = new LinkedList<>();
			for(int j=0;j<N;j++) {
				if(indegree[j] == 0) {
					q.offer(j);
					dp[j] = time[j];

					if(j == W) {
						sb.append(dp[j]).append('\n');
						continue Loop;
					}
				}
			}
			while(!q.isEmpty()) {
				int now = q.poll();

				for(int next : list[now]) {
					dp[next] = Math.max(dp[next], dp[now] + time[next]);
					if(--indegree[next] == 0) {
						if(next == W) {
							sb.append(dp[next]).append('\n');
							continue Loop;
						}
						q.offer(next);
					}
				}
			}
		}

		System.out.println(sb);

	}

}
