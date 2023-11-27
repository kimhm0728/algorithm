package baekjoon;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class B_1389 {
	static int N, M;
	static ArrayList<Integer>[] rel;
	static int[] user; // 유저 별 케빈 베이컨 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 유저 수
		M = Integer.parseInt(st.nextToken()); // 친구 관계 수
		
		rel = new ArrayList[N];
		user = new int[N];
		
		for(int i=0;i<N;i++)
			rel[i] = new ArrayList<Integer>();
		
		for(int i=0;i<M;i++) { // 친구 관계 입력
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			rel[a].add(b);
			rel[b].add(a);
		}
		
		for(int i=0;i<N;i++) 
			// 유저 i의 총 케빈 베이컨 수 구하기
			user[i] = BFS(i); 
		
		int min = 0;
		for(int i=1;i<N;i++) {
			if(user[i] < user[min])
				min = i;
			else if(user[i] == user[min] && min > i)
				min = i;
		}
		System.out.println(min + 1);
	}
	static int BFS(int start) {
		int cnt = 0;
		int[] kebin = new int[N]; 
		// kebin[i]는 유저 start에서 유저 i로 가는 단계의 수
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()) {
			int tmp = q. poll();
			for(int i : rel[tmp])
				if(kebin[i] == 0) {
					q.add(i);
					kebin[i] = kebin[tmp] + 1;
					cnt += kebin[i];
				}
		}
		return cnt;
	}
}
