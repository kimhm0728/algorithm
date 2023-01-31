package bfs;

import java.util.*;
import java.io.*;

public class B_1525 {
	static int[] dir = {-3, 3, -1, 1}; // 상하좌우 이동
	static HashSet<String> visit;
	static String n;
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		visit = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<3;i++) 
			sb.append(br.readLine().replaceAll(" ", ""));
		
		n = sb.toString();

		BFS(n.indexOf("0"));
		System.out.println(answer);
	}

	static void BFS(int startIdx) {
		Queue<Puzzle> q = new LinkedList<>();
		
		Puzzle start = new Puzzle(startIdx, 0, -1, n);
		visit.add(n);
		q.offer(start);
		
		while(!q.isEmpty()) {
			Puzzle now = q.poll();
			
			if(now.num.equals("123456780")) {
				answer = now.cnt;
				return;
			}
			
			for(int i=0;i<4;i++) {
				if((now.idx % 3 == 0 && i == 2) || (now.idx % 3 == 2 && i == 3) ||
						(now.path == 0 && i == 1) || (now.path == 1 && i == 0) || 
						(now.path == 2 && i == 3) || (now.path == 3 && i == 2))
					continue;
				
				int nextIdx = now.idx + dir[i];
				
				if(check(nextIdx)) {
					StringBuilder temp = new StringBuilder(now.num);
					temp.replace(now.idx, now.idx + 1, String.valueOf(temp.charAt(nextIdx)));
					temp.replace(nextIdx, nextIdx + 1, "0");
					
					String next = temp.toString();
					if(visit.add(next)) {
						q.offer(new Puzzle(nextIdx, now.cnt + 1, i, next));
					}
				}
			}
		}
	}
	
	static boolean check(int idx) {
		if(idx < 0 || idx >= 9)
			return false;
		
		return true;
	}
	
	static class Puzzle {
		int idx, cnt, path; // idx -> 현재 0의 위치
		String num;

		Puzzle(int idx, int cnt, int path, String num) {
			this.idx = idx;
			this.cnt = cnt;
			this.path = path;
			this.num = num;
		}
	}

}
