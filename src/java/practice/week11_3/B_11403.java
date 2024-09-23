package java.practice.week11_3;

import java.util.*;
import java.io.*;

public class B_11403 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		boolean visit[][] = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) 
				visit[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
		}
		
		for(int k=0;k<N;k++)
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					visit[i][j] = visit[i][j] || (visit[i][k] && visit[k][j]);

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				sb.append(visit[i][j] ? 1 : 0).append(' ');
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
