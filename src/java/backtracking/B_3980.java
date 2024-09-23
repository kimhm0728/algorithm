package java.backtracking;

import java.util.*;
import java.io.*;

public class B_3980 {
	static int answer;
	static int[][] ability;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int C = Integer.parseInt(br.readLine());
		ability = new int[11][11];
		
		for(int i=0;i<C;i++) {
			visit = new boolean[11];
			answer = 0;
			
			for(int j=0;j<11;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<11;k++)
					ability[j][k] = Integer.parseInt(st.nextToken());
			}
			
			DFS(0, 0);
			sb.append(answer).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void DFS(int depth, int sum) {
		if(depth == 11) {
			answer = Math.max(sum, answer);
			return;
		}
		
		for(int i=0;i<11;i++) {
			if(visit[i] || ability[i][depth] == 0)
				continue;
			visit[i] = true;
			DFS(depth + 1, sum + ability[i][depth]);
			visit[i] = false;
		}
	}

}
