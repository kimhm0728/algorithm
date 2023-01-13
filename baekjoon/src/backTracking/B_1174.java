package backTracking;

import java.util.*;
import java.io.*;

public class B_1174 {
	static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	static boolean[] visit = new boolean[arr.length];
	static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		DFS(0, 0, new StringBuilder());
		Collections.sort(list);

		long answer = -1;
		if(N <= list.size())
			answer = list.get(N - 1);
		
		System.out.println(answer);
	}

	static void DFS(int depth, int start, StringBuilder sb) {
		if(depth > 0) 
			list.add(Long.parseLong(sb.toString()));
		
		if(depth == arr.length) 
			return;
		
		for(int i=start;i<arr.length;i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			sb.append(arr[i]);
			
			DFS(depth + 1, i + 1, sb);
			visit[i] = false;
			sb.setLength(sb.length() - 1);
		}
	}

}
