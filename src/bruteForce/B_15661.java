package bruteForce;

import java.util.*;
import java.io.*;

public class B_15661 {
	static int N;
	static int[][] ability;
	static boolean[] visit;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ability = new int[N][N];
		visit = new boolean[N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) 
				ability[i][j] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0);
		System.out.println(answer);
	}
	
	static void DFS(int depth, int start) {
		if(depth != 0)
			answer = Math.min(answer, calcute());
		
		if(depth == N - 1)
			return;
		
		for(int i=start;i<N;i++) {
			visit[i] = true;
			DFS(depth + 1, i + 1);
			visit[i] = false;
		}
	}
	
	static int calcute() {
		int start = 0; // DFS·Î »ÌÀº ÆÀ
		int link = 0; // link·Î »ÌÀº ÆÀ
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i == j || visit[i] != visit[j])
					continue;
				
				if(visit[i]) 
					start += ability[i][j];
				else
					link += ability[j][i];
			}
		}
		
		return Math.abs(start - link);
	}

}
