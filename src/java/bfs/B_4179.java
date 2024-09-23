package java.bfs;

import java.io.*;
import java.util.*;

public class B_4179 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static StringBuilder sb = new StringBuilder();
	static Queue<int[]> fire;
	static char[][] building;
	static boolean[][] visit;
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		fire = new LinkedList<>();
		building = new char[R][C];
		visit = new boolean[R][C];

		int startR = 0, startC = 0;
		for(int j=0;j<R;j++) {
			String str = br.readLine();
			for(int k=0;k<C;k++) {
				building[j][k] = str.charAt(k);
				if(building[j][k] == 'J') {
					startR = j;
					startC = k;
				}
				else if(building[j][k] == 'F') 
					fire.offer(new int[] {j, k});
			}
		}

		int answer = BFS(startR, startC);
		if(answer == -1)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(answer);

	}

	static int BFS(int startR, int startC) {
		Queue<Escape> q = new LinkedList<>();
		ArrayList<int[]> temp = new ArrayList<>();
		int preTime = 0;

		visit[startR][startC] = true;
		q.offer(new Escape(startR, startC, 0));

		while(!q.isEmpty()) {
			Escape now = q.poll();

			if(now.time != preTime) { // ���� �ð��� ��ġ�� ��� Ž���� ��� ���� ���̱� ���� fire�� �߰�
				fire.addAll(temp);
				temp.clear();
			}

			while(!fire.isEmpty()) { // ���� �������� ĭ���� �̵��� �� �����Ƿ� �̸� �� ���� ���� üũ
				int[] f = fire.poll();
				for(int i=0;i<4;i++) {
					int fR = f[0] + dir[i][0];
					int fC = f[1] + dir[i][1];

					if(check(fR, fC)) {
						building[fR][fC] = 'F';
						temp.add(new int[] {fR, fC}); // ���� �ð��� ���� �ű�� ���� �̸� �����ص�
					}
				}
			}

			if(checkEscape(now.r, now.c)) {
				return now.time + 1;
			}

			for(int i=0;i<4;i++) {
				int nextR = now.r + dir[i][0];
				int nextC = now.c + dir[i][1];

				if(check(nextR, nextC) && !visit[nextR][nextC]) {
					visit[nextR][nextC] = true;
					q.offer(new Escape(nextR, nextC, now.time + 1));
				}
			}

			preTime = now.time;
		}

		return -1;
	}

	static boolean check(int r, int c) {
		if(r < 0 || r >= R || c < 0 || c >= C || building[r][c] != '.')
			return false;

		return true;
	}

	static boolean checkEscape(int r, int c) {
		if(r == 0 || r == R - 1 || c == 0 || c == C - 1)
			return true;

		return false;
	}

	static class Escape {
		int r, c, time;
		Escape(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

}