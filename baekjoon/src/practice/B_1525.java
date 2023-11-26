package skt;

import java.util.*;
import java.io.*;

public class B_1525 {
	static int[] move = {-1, 1, -3, 3};
	static String right = "123456780";
	static HashSet<String> visit = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<3;i++) {
			sb.append(br.readLine().replaceAll(" ", ""));
		}

		System.out.println(bfs(sb, sb.indexOf("0")));
	}
	
	static int bfs(StringBuilder n, int loc) {
		Queue<Puzzle> q = new LinkedList<>();
		
		q.offer(new Puzzle(n, loc, 0));
		visit.add(n.toString());
		
		while(!q.isEmpty()) {
			Puzzle now = q.poll();
			
			if (now.n.toString().equals(right)) {
				return now.cnt;
			}
			
			for (int i=0;i<4;i++) {
				if (((now.loc == 3 || now.loc == 6) && i == 0) || 
						((now.loc == 2 || now.loc == 5) && i == 1)) continue;
				int nextLoc = now.loc + move[i];
				if (nextLoc < 0 || nextLoc >= 9) continue;
				
				StringBuilder nextN = new StringBuilder(now.n);
				char temp = now.n.charAt(now.loc);
				nextN.setCharAt(now.loc, now.n.charAt(nextLoc));
				nextN.setCharAt(nextLoc, temp);

				if (visit.add(nextN.toString())) {
					q.offer(new Puzzle(nextN, nextLoc, now.cnt + 1));
				}
			}
		}
		
		return -1;
	}
	
	static class Puzzle {
		StringBuilder n;
		int loc, cnt;
		
		Puzzle(StringBuilder n, int loc, int cnt) {
			this.n = n;
			this.loc = loc;
			this.cnt = cnt;
		}
	}

}
