package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11660 {
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		board = new int[n + 1][n + 1];
		
		for (int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1;j<=n;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				board[i][j] += board[i][j - 1];
			}
		}
		
		for (int i=2;i<=n;i++) {
			for (int j=1;j<=n;j++) {
				board[i][j] += board[i - 1][j];
			}
		}
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
		
			sb.append(solution(x1, y1, x2, y2)).append('\n');
		}
		
		System.out.println(sb);
	}

	static int solution(int x1, int y1, int x2, int y2) {
		return board[x2][y2] - board[x2][y1 - 1] - board[x1 - 1][y2] + board[x1 - 1][y1 - 1];
	}
}
