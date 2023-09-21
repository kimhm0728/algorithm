package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_1495 {
	static int N, S, M;
	static int[] dp;
	static int[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		v = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] visit = new boolean[M + 1];
		visit[S] = true;
		
		for (int i=0;i<N;i++) {
			boolean[] temp = new boolean[M + 1];
			for (int j=0;j<=M;j++) {
				if (visit[j]) {
					if (j + v[i] >= 0 && j + v[i] <= M) temp[j + v[i]] = true;
					if (j - v[i] >= 0 && j - v[i] <= M) temp[j - v[i]] = true;
				}
			}
			
			visit = temp;
		}
		
		int answer = -1;
		for (int i=0;i<=M;i++) {
			if (visit[i]) answer = Math.max(answer, i);
		}
		
		System.out.println(answer);
	}

}
