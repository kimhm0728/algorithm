package week10_3;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class B_1697 {
	private static int N, K;
	private static int[] cnt = new int[100001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		BFS();
		System.out.println(cnt[K]);
	}

	private static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		while(!q.isEmpty()) {
			int tmp = q.poll();
			int next;
			
			if(tmp == K)
				break;

			for(int i=0;i<3;i++) {
				if(i == 0)
					next = tmp - 1;
				else if(i == 1)
					next = tmp + 1;
				else
					next = tmp * 2;
				
				if(next >= 0 && next < cnt.length && cnt[next] == 0) {
					q.add(next);
					cnt[next] = cnt[tmp] + 1;
				}
			}
		}

	}
}
