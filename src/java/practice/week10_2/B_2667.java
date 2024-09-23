package java.practice.week10_2;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class B_2667 {
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static boolean visit[][];
	static int list[][];
	static int n;
	static int count; // ���� �� ���� ��
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		list = new int[n][n];
		visit = new boolean[n][n];

		List<Integer> cnt = new ArrayList<>();
		int cntNum = 0; // ������ ��

		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<n;j++) 
				list[i][j] = str[j].charAt(0) - '0';
		}

		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(list[i][j] == 1 && visit[i][j] == false) {
					cntNum++;
					count = 0;
					dfs(i, j);
					cnt.add(count);
				}

		Collections.sort(cnt);

		sb.append(cntNum).append('\n');
		for(int i=0;i<cnt.size();i++)
			sb.append(cnt.get(i)).append('\n');

		System.out.println(sb);
	}

	private static void dfs(int row, int col) {
		visit[row][col] = true;
		count++;
		int newRow, newCol;
		
		for(int i=0;i<4;i++) {
			newRow = row + dx[i];
			newCol = col + dy[i];
			
			if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && list[newRow][newCol] == 1 && !visit[newRow][newCol]) 
				dfs(newRow, newCol);
		}
	}

}
