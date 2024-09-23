package java.practice.baekjoon;
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
				} // �迭�� �� ����
			}
			for(int i=0;i<h;i++) 
				for(int j=0;j<w;j++) {
					tmp = 1;
					islandNum(i, j);
				}
			for(int i=0;i<h;i++) 
				for(int j=0;j<w;j++)
					if(array[i][j] == 1)
						count++; // �迭�� 1�� ������ ���� ������ ����
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
						// ������ ������ ���� �迭�� ���� �ȿ� �ְ� array ���� 1�̸�
						array[x][y] = ++tmp;
						islandNum(x, y); // ���� ������ ��� 
					}
				}
		}

	}
}