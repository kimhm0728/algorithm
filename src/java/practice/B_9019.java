package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_9019 {
	static boolean[] visit;
	static char[] c = {'D', 'S', 'L', 'R'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			sb.append(bfs(a, b)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static String bfs(int start, int end) {
		Queue<DSLR> q = new LinkedList<>();
		visit = new boolean[10000];
		
		q.offer(new DSLR(start, ""));
		visit[start] = true;

		while(!q.isEmpty()) {
			DSLR now = q.poll();
			
			if (now.num == end) {
				return now.s;
			}
			
			for (int i=0;i<4;i++) {
				int nextNum;
				
				if (i == 0) nextNum = (now.num * 2) % 10000;
				else if (i == 1) nextNum = now.num == 0 ? 9999 : now.num - 1;
				else if (i == 2) nextNum = (now.num % 1000) * 10 + now.num / 1000;
				else nextNum = (now.num % 10) * 1000 + now.num / 10;
			
				if (visit[nextNum]) continue;
				q.offer(new DSLR(nextNum, now.s + c[i]));
				visit[nextNum] = true;
			}
		}
		
		return "";
	}
	
	static class DSLR {
		int num;
		String s;
		
		DSLR(int num, String s) {
			this.num = num;
			this.s = s;
		}
	}

}
