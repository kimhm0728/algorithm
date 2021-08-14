package baekjoon;
import java.util.*;
import java.io.*;

public class B_1389 {
	static int[] user; // 유저 별 케빈 베이컨 수를 저장
	static int[][] rel; // 친구 관계를 저장
	static int[][] visited; // 모든 케빈 베이컨 수 저장
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		user = new int[N];
		rel = new int[N][N];
		visited = new int[N][N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); 
			rel[a-1][b-1] = 1; // 유저 번호는 1~N이고 배열의 인덱스는 0~N-1이므로
			rel[b-1][a-1] = 1;
		}
		for(int i=0;i<N;i++)
			for(int j=0;j<N;i++) {
				if(i != j)
					visited[i][j] = kebinBacon(i, j);
			}
		int min = 0;
		for(int i=1;i<N;i++) // 케빈 베이컨이 가장 작은 유저를 찾음
			if(user[min] > user[i])
				min = i;
		for(int i=0;i<N;i++) // 케빈 베이컨 수가 같으면 유저 번호가 작은 유저를 출력
			if(min != i && visited[min] == visited[i] && min > i)
				min = i;
		System.out.println(min);
	}
	static int kebinBacon(int n, int m) {
		int tmp = n;
		for(int i=0;i<N;i++) {
			if(rel[n][i] == 1)
				tmp = i;
		}
		if(rel[n][m] == 1)
			return rel[n][m] = 1;
		else 
			return rel[n][m] = 1 + kebinBacon(tmp, n); //

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		visited[]
		
		if(visited[n][m] != 0)
			return visited[n][m];
		int temp = n;
		while(rel[temp][m] != 1) {
			temp = 
			if(rel[n][m] == 1) {
				visited[n][m] 
				return;
			}
			if(visited[temp, m] == 0)
				visited[temp] = visited[]
		}
	} 
}
