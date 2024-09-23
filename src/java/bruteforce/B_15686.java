package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_15686 {
	static int N, M, C = 0, P = 0;
	static int[][] city;
	static int[][] chicken;
	static int[][] person;
	static boolean[] visit;
	static int[][][] distance;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		city = new int[N][N];
		chicken = new int[14][2];
		person = new int[2 * N + 1][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				
				if(city[i][j] == 2) {
					chicken[C][0] = i;
					chicken[C][1] = j;
					C++;
				}
				else if(city[i][j] == 1) {
					person[P][0] = i;
					person[P][1] = j;
					P++;
				}
			}
		}
		
		visit = new boolean[C];
		distance = new int[C][N][N];
		for(int i=0;i<C;i++) {
			int x = chicken[i][0];
			int y = chicken[i][1];
			
			for(int j=0;j<P;j++) {
				int r = person[j][0];
				int c = person[j][1];
				distance[i][r][c] = Math.abs(x - r) + Math.abs(y - c);
			}
		}
		
		DFS(0, 0);
		System.out.println(answer);
		
	}
	
	static void DFS(int depth, int start) {
		if(depth == M) {
			answer = Math.min(calcute(), answer);
			return;
		}
		
		for(int i=start;i<C;i++) {
			visit[i] = true;
			DFS(depth + 1, i + 1);
			visit[i] = false;
		}
	}
	
	static int calcute() {
		int dis = 0;
		
		for(int i=0;i<P;i++) {
			int r = person[i][0];
			int c = person[i][1];
			int min = 10000;
			
			for(int j=0;j<C;j++) {
				if(visit[j])
					min = Math.min(min, Math.abs(chicken[j][0] - r) + Math.abs(chicken[j][1] - c));
			}
			dis += min;
		}
		
		return dis;
	}

}
