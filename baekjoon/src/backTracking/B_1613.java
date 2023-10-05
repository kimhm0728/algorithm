package backTracking;

import java.util.*;
import java.io.*;

public class B_1613 {
	static int n;
	static boolean[][] path;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		path = new boolean[n][n];
		
		for (int i=0;i<n;i++) {
			path[i][i] = true;
		}
	
		for (int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			
			path[s][e] = true;
		}
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				for (int l=0;l<n;l++) {
					if (path[j][i] & path[i][l]) {
						path[j][l] = true;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int s =  Integer.parseInt(br.readLine());
		
		for (int i=0;i<s;i++) {
			st = new StringTokenizer(br.readLine());
			
			int o = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken()) - 1;
			
			if (path[o][t]) sb.append(-1).append('\n');
			else if (path[t][o]) sb.append(1).append('\n');
			else sb.append('0').append('\n');
		}
		
		System.out.println(sb);
	}

}
