package unionFind;

import java.util.*;
import java.io.*;

public class B_20040 {
	static int[] parent;
	
	static public void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		for (int i=0;i<n;i++) parent[i] = i;
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (union(a, b)) {
				System.out.println(i + 1);
				return;
			}
		}
	
		System.out.println(0);
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return true;
		else if (x < y) parent[y] = x;
		else parent[x] = y;
		return false;
	}
}
