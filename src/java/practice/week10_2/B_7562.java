package java.practice.week10_2;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B_7562 {
	private static int[][] list;
	private static int l;
	private static int goalX, goalY;
	private static int dx[] = {1, 1, -1, -1, 2, 2, -2, -2};
	private static int dy[] = {-2, 2, -2, 2, -1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽��� ����
		
		for(int i=0;i<n;i++) {
			l = Integer.parseInt(br.readLine());
			list = new int[l][l];
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			goalX = Integer.parseInt(st.nextToken());
			goalY = Integer.parseInt(st.nextToken());
			bfs(x, y);
			
			sb.append(list[goalX][goalY]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			if(nowX == goalX && nowY == goalY)
				return;
			
			for(int i=0;i<8;i++) {
				int newX = nowX + dx[i];
				int newY = nowY + dy[i];
				if(newX < l && newX >= 0 && newY < l && newY >= 0) {
					if(list[newX][newY] == 0 || list[newX][newY] > list[nowX][nowY] + 1) {
						list[newX][newY] = list[nowX][nowY] + 1;
						q.offer(new int[] {newX, newY});
					}

				}
			}
		}
		
	}
}
