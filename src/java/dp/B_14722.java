package java.dp;

import java.util.*;
import java.io.*;

public class B_14722 {
	static int[] milk = {1, 2, 0};
	static int[][] city;
	static int[][] dp;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		city = new int[n][n];
		dp = new int[n][n];

		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (city[0][0] == 0) System.out.println(drinkMilk(0, 0, 1) + 1);
		else System.out.println(drinkMilk(0, 0, 0));

	}

	static int drinkMilk(int x, int y, int next) {
		if (x == n - 1 && y == n - 1) return 0;
		if (dp[x][y] != 0) return dp[x][y];

		int temp = 0;
		if (x + 1 < n) {
			if (city[x + 1][y] == next) { // �Ʒ��� �̵�
				temp = Math.max(drinkMilk(x + 1, y, milk[next]) + 1, drinkMilk(x + 1, y, next)); 
			}
			else {
				temp = drinkMilk(x + 1, y, next);
			}
		}

		if (y + 1 < n) {
			if (city[x][y + 1] == next) { // ���������� �̵�
				dp[x][y] = Math.max(drinkMilk(x, y + 1, milk[next]) + 1, drinkMilk(x, y + 1, next)); 
			}
			else {
				dp[x][y] = drinkMilk(x, y + 1, next);
			}
		}

		return dp[x][y] = Math.max(temp, dp[x][y]);
	}
}
