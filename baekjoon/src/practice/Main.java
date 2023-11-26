package skt;

import java.util.*;
import java.io.*;

public class Main {
	static int t, f;
	static HashMap<String, Integer> map;
	static int[] parent;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		for (int i=0;i<t;i++) {
			f = Integer.parseInt(br.readLine());
			
			map = new HashMap<>();
			parent = new int[f * 2];
			cnt = new int[f * 2];

			for (int j=0;j<f*2;j++) {
				parent[j] = j;
				cnt[j] = 1;
			}
			
			int idx = 0;
			for (int j=0;j<f;j++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				if (!map.containsKey(a)) map.put(a, idx++);
				if (!map.containsKey(b)) map.put(b, idx++);
				
				sb.append(union(map.get(a), map.get(b))).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return cnt[a];
		if (a < b) {
			parent[b] = a;
			return cnt[a] += cnt[b];
		}
		
		parent[a] = b;
		return cnt[b] += cnt[a];
	}
	
}
