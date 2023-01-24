package bruteForce;

import java.util.*;
import java.io.*;

public class B_2615 {
	static int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}};
	static int[][] board;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st;
		board = new int[19][19];
		for(int i=0;i<19;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<19;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		Loop: for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(board[i][j] != 0 && search(i, j, board[i][j]))
					break Loop;
			}
		}

		if(sb.length() == 0)
			sb.append(0);

		System.out.println(sb);
	}

	static boolean search(int r, int c, int stone) {
		for(int i=0;i<4;i++) {
			int tempR = r, tempC = c;
			int cnt = 1;

			while(true) {
				tempR -= dir[i][0];
				tempC -= dir[i][1];
				
				if(tempR < 0 || tempR >= 19 || tempC < 0 || tempC >= 19 || board[tempR][tempC] != stone)
					break;

				cnt++;
			}
			
			tempR = r; tempC = c;
			while(true) {
				tempR += dir[i][0];
				tempC += dir[i][1];

				if(tempR < 0 || tempR >= 19 || tempC < 0 || tempC >= 19 || board[tempR][tempC] != stone)
					break;

				cnt++;
			}
			if(cnt == 5) {
				sb.append(stone).append('\n');
				if(i == 3) 
					sb.append(tempR).append(' ').append(tempC + 2);
				else 
					sb.append(r + 1).append(' ').append(c + 1);
				return true;
			}
		}

		return false;
	}

}
