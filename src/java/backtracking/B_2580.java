package java.backtracking;

import java.util.*;
import java.io.*;

public class B_2580 {
	static int[][] board = new int[9][9];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) 
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		DFS(0);
	}

	static void DFS(int depth) {
		if(depth == 9*9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++)
					sb.append(board[i][j]).append(' ');
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}

		int r = depth / 9;
		int c = depth % 9;
		if(board[r][c] != 0)
			DFS(depth + 1);
		else {
			for(int i=1;i<10;i++) {
				if(check(r, c, i)) {
					board[r][c] = i;
					DFS(depth + 1);
				}
			}
			board[r][c] = 0;
		}
	}

	static boolean check(int x, int y, int value) {
		for(int i=0;i<9;i++) {
			if(board[i][y] == value)
				return false;
		}

		for(int i=0;i<9;i++) {
			if(board[x][i] == value)
				return false;
		}

		int sq_x = (x / 3) * 3;
		int sq_y = (y / 3) * 3;

		for(int i=sq_x;i<sq_x+3;i++) {
			for(int j=sq_y;j<sq_y+3;j++)
				if(board[i][j] == value)
					return false;
		}
		return true;
	}

}
