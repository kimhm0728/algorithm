package backTracking;

import java.util.*;
import java.io.*;

public class B_15650 {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static int[] arr;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N];
		arr = new int[M];
		
		DFS(0, 0);
		System.out.println(sb);
	}
	
	static void DFS(int depth, int start) {
		if(depth == M) {
			for(int i : arr)
				sb.append(i).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			arr[depth] = i + 1;
			
			DFS(depth + 1, i + 1);
			visit[i] = false;
		}
	}

}