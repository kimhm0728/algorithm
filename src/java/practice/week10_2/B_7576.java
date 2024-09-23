package java.practice.week10_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B_7576 {
	private static boolean visit[][];
	private static int list[][];
	private static int m, n;
	private static int dx[] = {0, 0, 1, -1};
	private static int dy[] = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		list = new int[n][m];
		visit = new boolean[n][m];

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++)
				list[i][j] = Integer.parseInt(st.nextToken());
		}

		bfs();

		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++) {
				if(list[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				if(list[i][j] > max)
					max = list[i][j];
			}
		System.out.println(max-1);

	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		for(int i=0;i<n;i++) 
			for(int j=0;j<m;j++) 
				if(list[i][j] == 1 && !visit[i][j]) {
					q.offer(new int[] {i, j});
					visit[i][j] = true;
				}

		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];

			for(int i=0;i<4;i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				if(newX < n && newX >= 0 && newY < m && newY >= 0 && list[newX][newY] == 0 && !visit[newX][newY]) {
					visit[newX][newY] = true;
					list[newX][newY] = list[nowX][nowY] + 1;
					q.offer(new int[] {newX, newY});
				}
			}
		}
	}

}
