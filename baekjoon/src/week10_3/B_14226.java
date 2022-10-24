package week10_3;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_14226 {
	private static int time[] = new int[1001];
	private static int S;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		
		BFS();
		System.out.println(time[S]);
	}
	
	private static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == S)
				return;
			
			if(now * 2 > 0 && now * 2 < time.length && time[now * 2] == 0) {
				q.offer(now * 2);
				time[now * 2] = time[now] + 2;
			}
			
			if(now - 1 > 0 && now - 1 < time.length && time[now - 1] == 0) {
				q.offer(now - 1);
				time[now - 1] = time[now] + 1;
			}
			
		}
	}
}
