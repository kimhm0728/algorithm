package java.practice.baekjoon;
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
	static int[] user; // ���� �� �ɺ� ������ ��
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ���� ��
		M = Integer.parseInt(st.nextToken()); // ģ�� ���� ��
		
		rel = new ArrayList[N];
		user = new int[N];
		
		for(int i=0;i<N;i++)
			rel[i] = new ArrayList<Integer>();
		
		for(int i=0;i<M;i++) { // ģ�� ���� �Է�
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			rel[a].add(b);
			rel[b].add(a);
		}
		
		for(int i=0;i<N;i++) 
			// ���� i�� �� �ɺ� ������ �� ���ϱ�
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
		// kebin[i]�� ���� start���� ���� i�� ���� �ܰ��� ��
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
