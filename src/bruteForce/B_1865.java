package bruteForce;

import java.util.*;
import java.io.*;

public class B_1865 {
	static int INF = 100000000;
	static int N, M, W;
	static int[][] path;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		L: for (int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			path = new int[N][N];
			for (int i=0;i<N;i++) {
				Arrays.fill(path[i], INF);
				path[i][i] = 0;
			}
			
			for (int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken());
			
				path[s][e] = Math.min(path[s][e], d);
				path[e][s] = Math.min(path[e][s], d);
			}
			
			for (int i=0;i<W;i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken());
			
				path[s][e] = Math.min(path[s][e], -d);
			}
			
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					for (int k=0;k<N;k++) {
						if (path[j][k] > path[j][i] + path[i][k]) {
							path[j][k] = path[j][i] + path[i][k];
						}
					}
				}
			}
			
			for (int i=0;i<N;i++) {
				if (path[i][i]  < 0) {
					sb.append("YES").append('\n');
					continue L;
				}
			}
			
			sb.append("NO").append('\n');
		}
		
		System.out.println(sb);
	}
	
}
