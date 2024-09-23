package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_21278 {
	static int N, M;
	static int[][] time;
	static int first, second, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		time = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i == j)
					continue;
				time[i][j] = 10000;
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			time[start][end] = 1;
			time[end][start] = 1;
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) 
					// i���� j�� �ٷ� ���� �ͺ��� i���� k�� ���ļ� j���� ���� ���� �� ȿ�����̶�� ����
					if(time[i][j] > time[i][k] + time[k][j])
						time[i][j] = time[i][k] + time[k][j];
			}
		}
		
		// �ǹ� �ΰ� �̱� (i , j)
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				int sum = 0;
				for(int k=0;k<N;k++)
					sum += Math.min(time[k][i], time[k][j]);
				if(sum < min) {
					min = sum;
					first = i;
					second = j;
				}
			}
		}
		
		System.out.println((first + 1) + " " + (second + 1) + " " + (min * 2));
	}

}
