package java.practice.week10_3;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B_13549 {
	private static int N, K;
	private static int[] cnt = new int[100001];
	private static boolean flag;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Arrays.fill(cnt, -1);
		BFS();
		System.out.println(cnt[K]);
	}
	
	private static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		cnt[N] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int next;
			
			if(now == K)
				return;
			
			for(int i=0;i<3;i++) {
				flag = false;
				if(i == 0) {
					next = now * 2;
					flag = true;
				}
				else if(i == 1)
					next = now - 1;
				else {
					next = now + 1;
				}
				
				if(next >= 0 && next < cnt.length && cnt[next] == -1) {
					q.offer(next);
					if(flag)
						cnt[next] = cnt[now];
					else
						cnt[next] = cnt[now] + 1;	
				}
			}

		}
	}

}
