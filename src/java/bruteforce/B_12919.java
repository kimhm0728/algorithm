package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_12919 {
	static String S, T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();

		int answer = BFS(S.length()) ? 1 : 0;
		System.out.println(answer);

	}

	static boolean BFS(int len) {
		Queue<StringBuilder> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder(T);
		q.offer(sb);

		while(!q.isEmpty()) {
			StringBuilder now = q.poll();

			if(now.toString().equals(S))
				return true;

			int now_len = now.length();
			
			if(now_len - 1 < len)
				continue;
			
			if(now.charAt(0) == 'B') {
				StringBuilder next = new StringBuilder(now.substring(1, now_len));
				q.offer(next.reverse());
			}

			if(now.charAt(now_len - 1) == 'A') {
				now.setLength(now_len - 1);
				q.offer(now);
			}
		}

		return false;
	}

}
