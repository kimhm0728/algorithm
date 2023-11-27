package week11_3;

import java.io.*;
import java.util.*;

public class B_11404 {
	static int INF = 10000001;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n + 1][n + 1];
		
		for(int i=1;i<=n;i++)
			Arrays.fill(arr[i], INF);
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			arr[start][end] = arr[start][end] > cost ? cost : arr[start][end];
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i != j && arr[i][j] > arr[i][k] + arr[k][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				sb.append(arr[i][j] == INF ? 0 : arr[i][j]).append(' ');
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
