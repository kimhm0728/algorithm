package java.practice.week10_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class B_1261 {
	private static int N, M;
	private static int[][] arr;
	private static int[][] visit;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		visit = new int[M][N];
		
		for(int i=0;i<M;i++)
			Arrays.fill(visit[i], -1);

		for(int i=0;i<M;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) 
				arr[i][j] = str.charAt(j) - '0';
		}

		BFS();
		System.out.println(visit[M-1][N-1]);
	}

	private static void BFS() {
		Deque<int[]> d = new LinkedList<>();
		d.addFirst(new int[] {0, 0});
		visit[0][0] = 0;
		
		while(!d.isEmpty()) {
			int[] now = d.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			if(nowX == M-1 && nowY == N-1)
				return;

			for(int i=0;i<4;i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && visit[nextX][nextY] == -1) {
					if(arr[nextX][nextY] == 0) { 
						d.addFirst(new int[] {nextX, nextY});
						visit[nextX][nextY] = visit[nowX][nowY];
					}
					if(arr[nextX][nextY] == 1) {
						d.addLast(new int[] {nextX, nextY});
						visit[nextX][nextY] = visit[nowX][nowY] + 1;
					}
				}
			}
		}
	}
}
