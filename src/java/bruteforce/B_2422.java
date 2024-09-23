package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_2422 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		boolean[][] combi = new boolean[N][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			combi[a][b] = true;
			combi[b][a] = true;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				for(int k=j+1;k<N;k++) {
					if(!combi[i][j] && !combi[i][k] && !combi[j][k])
						answer++;
				}
			}
		}

		System.out.println(answer);
		
	}

}
