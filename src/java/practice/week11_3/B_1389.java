package java.practice.week11_3;

import java.util.*;
import java.io.*;

public class B_1389 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];

		for(int i=1;i<=N;i++)
			Arrays.fill(arr[i], 101);

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());

			arr[f1][f2] = 1;
			arr[f2][f1] = 1;
		}

		for(int k=1;k<=N;k++)
			for(int i=1;i<=N;i++)
				for(int j=1;j<=N;j++) {
					if(i != j && arr[i][j] > arr[i][k] + arr[k][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}

		int idx = 0;
		int sum = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			int tempSum = 0;
			for(int j=1;j<=N;j++) {
				if(i == j) continue;
				tempSum += arr[i][j];
			}
			
			if(sum > tempSum) {
				idx = i;
				sum = tempSum;
			}
		}
		
		System.out.println(idx);
	}

}
