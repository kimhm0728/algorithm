package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_18808 {
	static int N, M, K;
	static int[][] board;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for (int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[n][m];
			
			for (int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				for (int k=0;k<m;k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			Loop: for (int j=0;j<4;j++) {
				for (int k=0;k<=N-n;k++) {
					for (int l=0;l<=M-m;l++) {
						int result = attach(k, l, sticker, n, m);
						if (result > 0) {
							answer += result;
							break Loop;
						}
					}
				}
				
				if (j == 3) continue;
				sticker = rotate(sticker, n, m);
				int temp = m;
				m = n;
				n = temp;
			}
		}
		
		System.out.println(answer);
	}
	
	static int attach(int r, int c, int[][] sticker, int n, int m) {
		int cnt = 0;
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if (sticker[i][j] == 0) continue;
				if (board[r + i][c + j] == 1) {
					Rollback: for (int k=0;k<n;k++) {
						for (int l=0;l<m;l++) {
							if (k == i && l == j) break Rollback;
							if (sticker[k][l] == 1) {
								board[r + k][c + l] = 0;
							}
						}
					}
					return 0;
				}
				board[r + i][c + j] = 1;
				cnt++;
			}
		}
		
		return cnt;
	}

	static int[][] rotate(int[][] arr, int n, int m) {
		int[][] ret = new int[m][n];
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				ret[j][n - i - 1] = arr[i][j];
			}
		}
		
		return ret;
	}
}
