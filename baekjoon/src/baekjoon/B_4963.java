package baekjoon;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class B_4963 {
	static int[][] array;
	static int[][] visited;
	static int w, h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0)
				break;
			array = new int[w][h];
			visited = new int[w][h];
			for(int i=0;i<w;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<h;j++) 
					array[i][j] = Integer.parseInt(st.nextToken());
			}
			sb.append(islandNumber(array));
		}
		System.out.println(sb);
	}
	static int islandNumber(int[][] a) {
		int n = 0;
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(a[i][j] == 1 && visited[i][j] == 0){
					if(i-1 < w && visited[i-1][j] == 0) {
						islandNumber[i-1][j];
					}
				}
			}
		}
		return n;
		// DP 사용해보기
	}
}
