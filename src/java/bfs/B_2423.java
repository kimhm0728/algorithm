package java.bfs;

import java.util.*;
import java.io.*;

public class B_2423 {
	static int[][] move1 = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // �밢��
	static int[][] move2 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // �����¿�
	static int N, M;
	static char[][] arr;
	static int[][] visit;
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visit = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j] = str.charAt(j);
				visit[i][j] = INF;
			}
		}
		
		int cnt = arr[N - 1][M - 1] == '\\' ? 0 : 1;
		cnt += arr[0][0] == '\\' ? 0 : 1;
		arr[N - 1][M - 1] = '\\';
		
		dijkstra();
		System.out.println(visit[N - 1][M - 1] == INF ? "NO SOLUTION" : (visit[N - 1][M - 1] + cnt));
	}
	
	static void dijkstra() {
		PriorityQueue<Circuit> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
		pq.offer(new Circuit(0, 0, 0, '\\'));
		visit[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Circuit now = pq.poll();
			
			if(now.r == N - 1 && now.c == M - 1) {
				visit[N - 1][M - 1] = now.cnt;
				return;
			}
			
			for(int i=0;i<4;i++) { // �밢������ �̵��ϴ� ���, ���� Ÿ�ϰ� ���ƾ� ���� ����
				if((now.wire == '\\' && (i == 1 || i == 2)) || (now.wire == '/' && (i == 0 || i == 3)))
					continue;
				
				int nextR = now.r + move1[i][0];
				int nextC = now.c + move1[i][1];
				
				if(!check(nextR, nextC))
					continue;
				
				if(now.wire == arr[nextR][nextC] && visit[nextR][nextC] > now.cnt) { // ����Ǿ� ������
					visit[nextR][nextC] = now.cnt;
					pq.offer(new Circuit(nextR, nextC, now.cnt, now.wire));
				}
				else if(now.wire != arr[nextR][nextC] && visit[nextR][nextC] > now.cnt + 1
						&& (nextR != N - 1 || nextC != M - 1)) { // ����Ǿ� ���� ������ Ÿ�� ȸ�� (������ ����� Ÿ���� ȸ���� �� ����)
					visit[nextR][nextC] = now.cnt + 1; 
					pq.offer(new Circuit(nextR, nextC, now.cnt + 1, now.wire)); 
				}
			}
			
			for(int i=0;i<4;i++) { // �����¿�� �̵��ϴ� ���, ���� Ÿ�ϰ� �޶�� ���� ����
				int nextR = now.r + move2[i][0];
				int nextC = now.c + move2[i][1];
				
				if(!check(nextR, nextC))
					continue;
				
				if(now.wire != arr[nextR][nextC] && visit[nextR][nextC] > now.cnt) { // ����Ǿ� ������
					visit[nextR][nextC] = now.cnt;
					pq.offer(new Circuit(nextR, nextC, now.cnt, arr[nextR][nextC]));
				}
				else if(now.wire == arr[nextR][nextC] && visit[nextR][nextC] > now.cnt + 1
						&& (nextR != N - 1 || nextC != M - 1)) { // ����Ǿ� ���� ������ Ÿ�� ȸ�� (������ ����� Ÿ���� ȸ���� �� ����)
					visit[nextR][nextC] = now.cnt + 1; 
					pq.offer(new Circuit(nextR, nextC, now.cnt + 1, now.wire == '/' ? '\\' : '/')); 
				}
			}
		}
		
	}
	
	static boolean check(int r, int c) {
		return (r < 0 || r >= N || c < 0 || c >= M) ? false : true;
	}

	static class Circuit {
		int r, c, cnt;
		char wire;
		
		Circuit(int r, int c, int cnt, char wire) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.wire = wire;
		}
	}
}
