package week10_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B_2178 {
	private static int list[][];
	private static boolean visit[][];
	private static int dx[] = {0, 0, -1, 1};
	private static int dy[] = {1, -1, 0, 0};
	private static int n, m;
	private static Queue<int[]> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<m;j++) 
				list[i][j] = str[j].charAt(0) - '0';
		}
		
		bfs();
		System.out.println(list[n-1][m-1]);
		
	}
	
	private static void bfs() {
		que.offer(new int[] {0, 0});
		visit[0][0] = true;
		
		while(!que.isEmpty()) {
			int now[] = que.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			if(nowX == n-1 && nowY == m-1)
				return;
			
			for(int i=0;i<4;i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				if(newX < n && newX >= 0 && newY < m && newY >= 0 && list[newX][newY] == 1 && !visit[newX][newY]) {
					list[newX][newY] = list[nowX][nowY] + 1;
					que.offer(new int[] {newX, newY});
					visit[newX][newY] = true;
				}
			}
		}
	}

}
