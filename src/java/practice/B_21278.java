package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_21278 {
	static int n, m;
	static int[][] distance;
	static boolean[] visit;
	static int answer = 1000;
	static int first, second;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		distance = new int[n][n];
		
		for (int i=0;i<n;i++) {
			Arrays.fill(distance[i], 1000);
			distance[i][i] = 0;
		}
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
		
			distance[start][end] = 1;
			distance[end][start] = 1;
		}
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				for (int k=0;k<n;k++) {
					if (distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		for (int i=0;i<n;i++) {
			for (int j=i+1;j<n;j++) {
				int sum = 0;		
				for (int k=0;k<n;k++) {
					sum += Math.min(distance[k][i], distance[k][j]) * 2;
				} 
				
				if (answer > sum) {
					answer = sum;
					first = i + 1;
					second = j + 1;
				}
			}
		}
		
		System.out.println(first + " " + second + " " + answer);
	}
	
}
