package backTracking;

import java.util.*;
import java.io.*;

public class B_6443 {
	static char[] arr, order, mx;
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr = br.readLine().toCharArray();
			Arrays.sort(arr);
			
			int n = arr.length;
			visit = new boolean[n];
			mx = new char[n];
			order = new char[n];
			
			DFS(0, n);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void DFS(int depth, int n) throws IOException {
		if(depth == n) {
			bw.write(order);
			bw.write('\n');
			return;
		}
		
		mx[depth] = 0; // 중복 제거
		for(int i=0;i<n;i++) {
			if(visit[i] || mx[depth] >= arr[i]) // 중복 제거
				continue;
			
			visit[i] = true;
			order[depth] = mx[depth] = arr[i];
			DFS(depth + 1, n);
			visit[i] = false;
		}
	}

}
