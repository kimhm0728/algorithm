package java.backtracking;

import java.util.*;
import java.io.*;

public class B_10971 {
	static int N;
	static int[][] cost;
	static boolean[] visit;
	static int[] order; // �湮�� ������ ���� ����
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		cost = new int[N][N];
		visit = new boolean[N];

		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
		}

		order = new int[N];
		DFS(0);

		System.out.println(answer);
	}

	static void DFS(int depth) {
		if(depth == N) {
			answer = Math.min(answer, calcute());
			return;
		}

		for(int i=0;i<N;i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			order[depth] = i;
			DFS(depth + 1);
			visit[i] = false;
		}
	}

	static int calcute() {
		int sum = 0;
		
		for(int i=0;i<N-1;i++) {
			if(cost[order[i]][order[i + 1]] == 0) // ��ΰ� ���� ���
				return Integer.MAX_VALUE;
			sum += cost[order[i]][order[i + 1]]; 
		}
		
		if(cost[order[N - 1]][order[0]] == 0) // �ٽ� ���ƿ��� ��쵵 ��ΰ� ���� �� ����
			return Integer.MAX_VALUE;
		sum += cost[order[N - 1]][order[0]]; // �������� �ٽ� ���ƿ��� ���
		return sum;
	}

}
