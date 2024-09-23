package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_16937 {
	static int H, W, N;
	static int[][] sticker;
	static boolean[] visit;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		
		sticker = new int[N][2];
		visit = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			sticker[i][0] = Integer.parseInt(st.nextToken());
			sticker[i][1] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0, 0, 0);
		System.out.println(answer);
		
	}
	
	static void DFS(int depth, int area, int r, int c) {
		if(depth == 2) {
			answer = Math.max(area, answer);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visit[i])
				continue;
			
			int x = sticker[i][0];
			int y = sticker[i][1];
			
			if(check(x, y, r, c)) {
				visit[i] = true;
				DFS(depth + 1, area + x * y, x, y);
				visit[i] = false;
			}
			if(x != y && check(y, x, r, c)) {
				visit[i] = true;
				DFS(depth + 1, area + x * y, y, x);
				visit[i] = false;
			}
		}
	}
	
	static boolean check(int x, int y, int startR, int startC) {
		if((0 + x <= H && startC + y <= W) || (startR + x <= H && 0 + y <= W))
			return true;
		
		return false;
	}
}
