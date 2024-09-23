package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_16439 {
	static int N, M;
	static int answer = 0;
	static int[][] chicken;
	static int[] order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		order = new int[3];
		chicken = new int[N][M];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				chicken[i][j] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0);
		System.out.println(answer);
	}

	static void DFS(int depth, int start) {
		if(depth == 3) {
			answer = Math.max(answer, calcute());
			return;
		}

		for(int i=start;i<M;i++) {
			order[depth] = i;
			DFS(depth + 1, i + 1);
		}
	}

	static int calcute() {
		int ret = 0;
		
		for(int i=0;i<N;i++) {
			int max = 0;
			for(int j=0;j<3;j++) {
				if(max < chicken[i][order[j]])
					max = chicken[i][order[j]];
			}
			ret += max;
		}
		
		return ret;
	}

}
