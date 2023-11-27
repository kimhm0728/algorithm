package week10_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_4963 {
	private static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
	private static int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};
	private static int w, h;
	private static int list[][];
	private static boolean visit[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int count;
		
		while(true) {
			count = 0;
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0)
				break;
			
			list = new int[h][w];
			visit = new boolean[h][w];
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) 
					list[i][j] = Integer.parseInt(st.nextToken());
			}

			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) 
					if(!visit[i][j] && list[i][j] == 1) {
						dfs(i, j);
						count++;
					}
			}
			
			sb.append(count).append('\n');

		}
		
		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		int newX, newY;
		
		for(int i=0;i<8;i++) {
			newX = x + dx[i];
			newY = y + dy[i];
			
			if(newX < h && newX >= 0 && newY < w && newY >= 0 && list[newX][newY] == 1 && !visit[newX][newY]) {
				visit[newX][newY] = true;
				dfs(newX, newY);
			}
		}
	}
}
