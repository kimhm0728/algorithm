package unionFind;

import java.util.*;
import java.io.*;

public class B_1976 {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		parent = new int[n];
		for (int i=0;i<n;i++) parent[i] = i;
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				if (st.nextToken().equals("1")) union(i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		for (int i=1;i<m;i++) {
			int end = Integer.parseInt(st.nextToken()) - 1;
			if (!isUnion(start, end)) {
				System.out.println("NO");
				return;
			}
			start = end;
		}
		
		System.out.println("YES");
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return;
		if (x < y) parent[y] = x;
		else parent[x] = y;
	}
	
	static boolean isUnion(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return true;
		return false;
	}

}
