package week10_3;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_14226 {
	private static boolean visit[][] = new boolean[2001][1001];
	private static int S;
	private static int min;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		
		BFS();
		System.out.println(min);
	}
	
	private static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {1, 0, 0});
		visit[1][0] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			int nowEmoti = now[0];
			int nowClip = now[1];
			int nowSec = now[2];
			
			if(nowEmoti == S) {
				min = nowSec;
				return;
			}
			
			// 복사
			if(!visit[nowEmoti][nowEmoti]) {
				visit[nowEmoti][nowEmoti] = true;
				q.offer(new int[] {nowEmoti, nowEmoti, nowSec + 1});
			}
				
			// 붙여넣기
			if(nowEmoti + nowClip < 1001 &&!visit[nowEmoti + nowClip][nowClip]) {
				visit[nowEmoti + nowClip][nowClip] = true;
				q.offer(new int[] {nowEmoti + nowClip, nowClip, nowSec + 1});
			}
			
			// 삭제
			if(nowEmoti - 1 >= 0 && !visit[nowEmoti - 1][nowClip]) {
				visit[nowEmoti - 1][nowClip] = true;
				q.offer(new int[] {nowEmoti - 1, nowClip, nowSec + 1});
			}
			
		}
	}
}
