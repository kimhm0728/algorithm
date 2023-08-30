package backTracking;

import java.util.*;
import java.io.*;

public class B_17265 {
	static int max = -100000;
	static int min = 100000;
	static int n;
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		board = new char[n][n];
		
		StringTokenizer st;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				board[i][j] = st.nextToken().charAt(0);
			}
		}
		
		dfs(0, 0, board[0][0] - '0', ' ');
		System.out.println(max + " " + min);
	}
	
	static void dfs(int x, int y, int ret, char oper) {
		if (x % 2 == y % 2 && (x != 0 || y != 0)) {
			ret = calculate(ret, board[x][y] - '0', oper);
		}
		
		if (x == n - 1 && y == n - 1) {
			max = Math.max(max, ret);
			min = Math.min(min, ret);
			return;
		}
		
		if (x != n - 1) dfs(x + 1, y, ret, board[x][y]);
		if (y != n - 1) dfs(x, y + 1, ret, board[x][y]);
	}
	
	static int calculate(int a, int b, char o) {
		if (o == '*') return a * b;
		if (o == '-') return a - b;
		return a + b;
	}

}
