package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_1025 {
	static int N, M;
	static int[][] arr;
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());

			int div = (int)Math.pow(10, M - 1);
			for(int j=0;j<M;j++) {
				arr[i][j] = num / div;
				num %= div;
				div /= 10;

				if(check(arr[i][j]))
					answer = Math.max(answer, arr[i][j]);
			}
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(i == 0 && j == 0)
					continue;
				for(int k=0;k<N;k++) {
					for(int l=0;l<M;l++) {
						// �밢�� �� �������� �̵�
						DFS(k, l, i, j, -1);
						DFS(k, l, i, -j, -1);
						DFS(k, l, -i, j, -1);
						DFS(k, l, -i, -j, -1);
					}
				}
			}
		}

		System.out.println(answer);
	}
	
	// (startR, startC)�� �������� diffR, diffC��ŭ �̵��ϸ� ���� num�� ����
	static void DFS(int startR, int startC, int diffR, int diffC, int num) {
		if(num != -1) {
			if(check(num))
				answer = Math.max(answer, num);
		}

		if(startR < 0 || startR >= N || startC < 0 || startC >= M)
			return;

		num = num == -1 ? arr[startR][startC] : num * 10 + arr[startR][startC];
		DFS(startR + diffR, startC + diffC, diffR, diffC, num);
	}

	static boolean check(int num) {
		int sqrt = (int)Math.sqrt(num);
		if(sqrt * sqrt == num)
			return true;
		
		return false;
	}

}
