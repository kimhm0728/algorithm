package bruteForce;

import java.util.*;
import java.io.*;

public class B_14620 {
	static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	static int N;
	static int[][] flower;
	static boolean[][] visit;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		flower = new int[N][N];
		visit = new boolean[N][N];

		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) 
				flower[i][j] = Integer.parseInt(st.nextToken());
		}

		DFS(0, N, 0);
		System.out.println(answer);
	}

	static void DFS(int depth, int start, int sum) {
		if(depth == 3) {
			answer = Math.min(answer, sum);
			return;
		}

		for(int i=start;i<N*(N-1);i++) {
			int r = i / N;
			int c = i % N;

			if(!check(r, c))
				continue;

			visit[r][c] = true;
			int price = flower[r][c];
			for(int j=0;j<4;j++) {
				int nextR = r + dir[j][0];
				int nextC = c + dir[j][1];
				
				price += flower[nextR][nextC];
				visit[nextR][nextC] = true;
			}
			
			DFS(depth + 1, i + 1, sum + price);

			visit[r][c] = false;
			for(int j=0;j<4;j++) 
				visit[r + dir[j][0]][c + dir[j][1]] = false;
		}
	}

	static boolean check(int r, int c) {
		if(visit[r][c])
			return false;
		
		for(int i=0;i<4;i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];
			
			if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || visit[nextR][nextC])
				return false;
		}
		
		return true;
	}

}
