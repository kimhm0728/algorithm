package bfs;

import java.util.*;
import java.io.*;

public class B_9019 {
	static int T, A, B;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			visit = new boolean[10000];
			sb.append(BFS()).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static String BFS() {
		Queue<DSLR> q = new LinkedList<>();
		
		visit[A] = true;
		q.offer(new DSLR(A, 0, new StringBuilder()));
		
		while(!q.isEmpty()) {
			DSLR now = q.poll();
			
			if(now.n == B) {
				return now.command.toString();
			}
			
			for(int i=0;i<4;i++) {
				int next;
				char cmd;
				if(i == 0) {
					next = (2 * now.n) % 10000;
					cmd = 'D';
				}
				else if(i == 1) {
					next = now.n == 0 ? 9999 : now.n - 1;
					cmd = 'S';
				}
				else if(i == 2) {
					next = (now.n % 1000) * 10 + now.n / 1000;
					cmd = 'L';
				}
				else {
					next = (now.n % 10) * 1000 + now.n / 10;
					cmd = 'R';
				}
				
				if(!visit[next]) {
					visit[next] = true;
					q.offer(new DSLR(next, now.cnt + 1, new StringBuilder(now.command).append(cmd)));
				}
			}
		}
		
		return "";
	}
	
	static class DSLR {
		int n, cnt;
		StringBuilder command;
		
		DSLR(int n, int cnt, StringBuilder command) {
			this.n = n;
			this.cnt = cnt;
			this.command = command;
		}
	}

}
