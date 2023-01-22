package backTracking;

import java.util.*;
import java.io.*;

public class B_17136 {
	static boolean[][] visit; 
	static int[][] board;
	static int[] paper;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		visit = new boolean[10][10];
		board = new int[10][10];
		paper = new int[5];
		
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0);
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(answer);
	}
	
	static void DFS(int depth, int cnt) {
		if(depth == 100) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		int r = depth / 10;
		int c = depth % 10;
		
		if(board[r][c] == 0 || visit[r][c])
			DFS(depth + 1, cnt);
		else {
			for(int i=1;i<=5;i++) {
				if(check(r, c, i, true)) {
					DFS(depth + 1, cnt + 1);
					check(r, c, i, false);
				}
			}
		}
	}
	
	// flag가 true면 색종이를 붙이는 경우, false면 떼는 경우
	static boolean check(int r, int c, int num, boolean flag) {
		if(flag) {
			if(paper[num - 1] == 5)
				return false;
			
			// 붙일 수 있는지 확인
			for(int i=r;i<r+num;i++) {
				for(int j=c;j<c+num;j++) {
					if(i >= 10 || j >= 10 || visit[i][j] || board[i][j] == 0)
						return false;
				}
			}
			
			paper[num - 1]++;
		} 
		else
			paper[num - 1]--;
		
		// 색종이 붙이거나 떼기
		for(int i=r;i<r+num;i++) 
			for(int j=c;j<c+num;j++) 
				visit[i][j] = flag;
		
		return true;
	}

}
