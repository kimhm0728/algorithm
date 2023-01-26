package bruteForce;

import java.util.*;
import java.io.*;

public class B_14500 {
	static int N, M;
	static int[][] arr;
	static int[][][] tetris = {{{0, 1}, {0, 2}, {0, 3}}, 
			{{0, 1}, {1, 0}, {1, 1}}, 
			{{1, 0}, {2, 0}, {2, 1}}, 
			{{1, 0}, {1, 1}, {2, 1}}, 
			{{0, 1}, {1, 1}, {0, 2}}};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int k=0;k<5;k++) {
					isTetromino(i, j, k);
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static void isTetromino(int r, int c, int type) {
		int temp[][] = new int[3][2]; // 행, 열 반대로 저장

		for(int i=0;i<3;i++) {
			temp[i][0] = tetris[type][i][1];
			temp[i][1] = tetris[type][i][0];
		}
		
		rotate(r, c, tetris[type]);
		rotate(r, c, temp);
	}
	
	static void rotate(int r, int c, int[][] a) {
		for(int i=0;i<4;i++) {
			int d = arr[r][c];
			for(int j=0;j<3;j++) {
				int nextR, nextC;
				if(i == 0) {
					nextR = r - a[j][0];
					nextC = c - a[j][1];
				}
				else if(i == 1) {
					nextR = r + a[j][0];
					nextC = c - a[j][1];
				}
				else if(i == 2) {
					nextR = r - a[j][0];
					nextC = c + a[j][1];
				}
				else {
					nextR = r + a[j][0];
					nextC = c + a[j][1];
				}
				
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
					d = -1;
					break;
				}
				d += arr[nextR][nextC];
			}
			answer = Math.max(d, answer);
		}
	}

}
