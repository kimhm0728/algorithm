package java.backtracking;

import java.util.*;
import java.io.*;

public class B_15655 {
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static boolean[] visit;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N];
		arr = new int[M];
		
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);
		
		DFS(num, 0, 0);
		System.out.println(sb);
	}
	
	static void DFS(int[] num, int depth, int start) {
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
			arr[depth] = num[i];
			DFS(num, depth + 1, i + 1);
			visit[i] = false;
		}
	}

}