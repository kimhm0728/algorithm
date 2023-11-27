package baekjoon;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class B_4963 {
	static StringBuilder sb;
	static int[][] array;
	static int[][] visited;
	static int tmp;
	static int w, h;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while(true) {
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0)
				break;
			array = new int[h][w];
			visited = new int[h][w];
 			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				} // 배열에 값 대입
			}
			for(int i=0;i<h;i++) 
				for(int j=0;j<w;j++) {
					tmp = 1;
					islandNum(i, j);
				}
			for(int i=0;i<h;i++) 
				for(int j=0;j<w;j++)
					if(array[i][j] == 1)
						count++; // 배열의 1의 개수가 섬의 개수와 같음
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
	static void islandNum(int a, int b) {
		if(visited[a][b] == 1)
			return;
		visited[a][b] = 1;
		if(array[a][b] == 0)
			return;
		else {
			for(int i=0;i<dx.length;i++){
					int x = a + dx[i];
					int y = b + dy[i];
					if(0 <= x && x < h && 0 <= y && y < w && array[x][y] == 1 && visited[x][y] == 0) {
						// 다음에 가야할 값이 배열의 범위 안에 있고 array 값이 1이면
						array[x][y] = ++tmp;
						islandNum(x, y); // 다음 값으로 재귀 
					}
				}
		}

	}
}