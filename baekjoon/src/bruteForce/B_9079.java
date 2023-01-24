package bruteForce;

import java.util.*;
import java.io.*;

public class B_9079 {
	static int[][] reverse = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
			{0, 3, 6}, {1, 4, 7}, {2, 5, 8},
			{0, 4, 8}, {2, 4, 6}};
	static int answer;
	static boolean[] coin;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int i=0;i<T;i++) {
			answer = Integer.MAX_VALUE;
			coin = new boolean[9];
			
			for(int j=0;j<3;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<3;k++)
					coin[j * 3 + k] = st.nextToken().equals("H") ? true : false;
			}

			DFS(0, 0, -1);

			if(answer == Integer.MAX_VALUE)
				sb.append(-1);
			else
				sb.append(answer);
			sb.append('\n');
		}
		
		System.out.println(sb);

	}
	
	static void DFS(int depth, int cnt, int pre) {
		if(check()) {
			answer = Math.min(cnt, answer);
			return;
		}
		
		if(depth == 8)
			return;
		
		for(int i=0;i<8;i++) {
			if(pre == i)
				continue;
			
			for(int j=0;j<3;j++)
				coin[reverse[i][j]] = !coin[reverse[i][j]];
			
			DFS(depth + 1, cnt + 1, i);
			for(int j=0;j<3;j++)
				coin[reverse[i][j]] = !coin[reverse[i][j]];
		}
		
	}
	
	static boolean check() {
		boolean b = coin[0];
		for(int i=1;i<9;i++)
			if(b != coin[i])
				return false;
		return true;
	}

}
