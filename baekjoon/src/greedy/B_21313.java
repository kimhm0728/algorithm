package greedy;

import java.io.*;

public class B_21313 {
	static int N;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N][8];
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<N;i++) {
			for (int j=0;j<8;j++) {
				int next = (i + 1 == N) ? 0 : i + 1;
				if (visit[i][j] || visit[next][j]) continue;
				
				visit[i][j] = visit[next][j] = true;
				sb.append(j + 1).append(' ');
				break;
			}
		}
		
		System.out.println(sb);
	}
	
}
