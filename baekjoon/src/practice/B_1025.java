package skt;

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
			String s = br.readLine();
            
            for (int j=0;j<M;j++) {
				arr[i][j] = s.charAt(j) - '0';
            }
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(i == 0 && j == 0)
					continue;
				for(int k=0;k<N;k++) {
					for(int l=0;l<M;l++) {
						DFS(k, l, i, j, arr[k][l]);
						DFS(k, l, i, -j, arr[k][l]);
						DFS(k, l, -i, j, arr[k][l]);
						DFS(k, l, -i, -j, arr[k][l]);
					}
				}
			}
		}

		System.out.println(answer);
	}
	
	// (startR, startC)을 시작으로 diffR, diffC만큼 이동하며 정수 num을 생성
	static void DFS(int startR, int startC, int diffR, int diffC, int num) {
		if(isSquare(num)) {
			answer = Math.max(answer, num);
		}
		
		int nextR = startR + diffR;
		int nextC = startC + diffC;
		if (!check(nextR, nextC)) return;

		DFS(nextR, nextC, diffR, diffC, num * 10 + arr[nextR][nextC]);
	}

	static boolean isSquare(int num) {
		int sqrt = (int)Math.sqrt(num);
		return sqrt * sqrt == num ? true : false;
	}
	
	static boolean check(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) return false;
		return true;
	}
}
