package java.practice.week10_3;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B_13913 {
	private static int N, K;
	private static int[] cnt = new int[100001];
	private static int[] path = new int[100001];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		BFS();
		
		sb.append(cnt[K]).append('\n');
		
		Stack<Integer> s = new Stack<>();
		s.push(K);
		int idx = K;
		
		while(idx != N) {
			s.push(path[idx]);
			idx = path[idx];
		}
		
		while(!s.empty()) 
			sb.append(s.pop()).append(' ');

		System.out.println(sb);
		
	}
	
	private static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		path[N] = N;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			int next;
			
			if(tmp == K)
				return;
			
			for(int i=0;i<3;i++) {
				if(i == 0)
					next = tmp - 1;
				else if(i == 1)
					next = tmp + 1;
				else
					next = tmp * 2;
				
				if(next >= 0 && next < 100001 && cnt[next] == 0) {
					q.offer(next);
					cnt[next] = cnt[tmp] + 1;
					path[next] = tmp;
				}
			}
		}
	}

}
