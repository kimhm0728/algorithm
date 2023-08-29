package dynamicProgramming;

import java.io.*;
import java.util.*;

public class B_2661 {
	static int N;
	static String[] arr = {"1", "2", "3"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		System.out.println(BFS());
	}
	
	static String BFS() {
		Queue<Sequence> q = new LinkedList<>();
		
		q.offer(new Sequence(0, new StringBuilder()));
		
		while(!q.isEmpty()) {
			Sequence now = q.poll();
			
			if(now.len == N) {
				return now.sb.toString();
			}
			
			for(int i=0;i<3;i++) {
				StringBuilder nextSb = new StringBuilder(now.sb.append(arr[i]));
				if (check(now.len + 1, nextSb.toString())) {
					q.offer(new Sequence(now.len + 1, nextSb));
				}
				now.sb.setLength(now.len);
			}
		}
		
		return "";
	}
	
	static boolean check(int len, String str) {
		for(int i=1;i<=len/2;i++) {
			if(str.substring(len - i, len).equals(str.substring(len - i - i, len - i))) {
				return false;
			}
		}
		
		return true;
	}
	
	static class Sequence {
		int len;
		StringBuilder sb;
		
		Sequence(int len, StringBuilder sb) {
			this.len = len;
			this.sb = sb;
		}
	}

}
