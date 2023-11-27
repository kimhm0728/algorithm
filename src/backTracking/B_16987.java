package backTracking;

import java.util.*;
import java.io.*;

public class B_16987 {
	static int N;
	static int[][] egg;
	static boolean[] visit;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		egg = new int[N][2]; // 내구도, 무게
		visit = new boolean[N];

		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0);
		System.out.println(answer);
	}

	static void DFS(int start, int cnt) {
		if(start == N) { // 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우
			answer = Math.max(cnt, answer);
			return;
		}

		if(visit[start]) // 손에 들고 있는 계란이 깨져있다면 치지 않고 넘어감
			DFS(start + 1, cnt);
		else {
			boolean flag = false;
			for(int i=0;i<N;i++) {
				if(i == start || visit[i]) // visit true -> 깨진 계란
					continue;
				flag = true;
				int temp = 0;
				
				// start 계란으로 i 계란을 깨기
				egg[start][0] -= egg[i][1];
				egg[i][0] -= egg[start][1];
				if(egg[start][0] <= 0) {
					visit[start] = true;
					cnt++;
					temp++;
				}
				if(egg[i][0] <= 0) {
					visit[i] = true;
					cnt++;
					temp++;
				}

				DFS(start + 1, cnt);
				
				// 되돌리기
				egg[start][0] += egg[i][1]; 
				egg[i][0] += egg[start][1];
				if(egg[start][0] > 0) 
					visit[start] = false;
				if(egg[i][0] > 0) 
					visit[i] = false;
				cnt -= temp;
			}
			if(!flag) // 계란 모두가 깨져있다면 넘어감
				DFS(start + 1, cnt);
		}
	}

}
