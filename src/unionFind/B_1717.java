package unionFind;

import java.util.*;
import java.io.*;

public class B_1717 {
	static StringBuilder sb = new StringBuilder();
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		for (int i=1;i<=n;i++) parent[i] = i;
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (o == 0) union(a, b); else isUnion(a, b);
		}
		
		System.out.println(sb);
	}
	
	static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return;
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	static void isUnion(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) sb.append("YES"); else sb.append("NO");
		sb.append('\n');
	}
}
