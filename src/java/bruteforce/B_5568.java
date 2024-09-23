package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_5568 {
	static int N, K;
	static String[] num;
	static boolean[] visit;
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		num = new String[N];
		visit = new boolean[N];
		set = new HashSet<>();
		
		for(int i=0;i<N;i++) 
			num[i] = br.readLine();
		
		DFS(0, new StringBuilder());
		System.out.println(set.size());
	}
	
	static void DFS(int depth, StringBuilder sb) {
		if(depth == K) {
			set.add(sb.toString());
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visit[i])
				continue;
			
			visit[i] = true;
			sb.append(num[i]);
			DFS(depth + 1, sb);
			
			visit[i] = false;
			sb.setLength(sb.length() - num[i].length());
		}
	}
}
