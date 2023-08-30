package unionFind;

import java.util.*;
import java.io.*;

public class B_4195 {
	static int[] parent;
	static int[] size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int i=0;i<t;i++) {
			int f = Integer.parseInt(br.readLine());
			
			HashMap<String, Integer> map = new HashMap<>();
			parent = new int[f * 2];
			size = new int[f * 2];
			for (int j=0;j<f*2;j++) {
				parent[j] = j;
				size[j] = 1;
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
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static int union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent[y] = x;
			size[x] += size[y];
		}
		return size[x];
	}
}

//import java.util.*;
//import java.io.*;
//
//public class Main {
//	static HashMap<String, String> parent;
//	static HashMap<String, Integer> size;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st;
//		
//		int t = Integer.parseInt(br.readLine());
//		for (int i=0;i<t;i++) {
//			int f = Integer.parseInt(br.readLine());
//			parent = new HashMap<>();
//			size = new HashMap<>();
//			
//			for (int j=0;j<f;j++) {
//				st = new StringTokenizer(br.readLine());
//				String a = st.nextToken();
//				String b = st.nextToken();
//				
//				sb.append(union(a, b)).append('\n');
//			}
//		}
//		
//		System.out.println(sb);
//	}
//	
//	static String find(String x) {
//		String p = parent.getOrDefault(x, "");
//		if (p.equals(x) || p.equals("")) return x;
//		
//		String ret = find(p);
//		parent.put(x, ret);
//		return ret;
//	}
//	
//	static int union(String x, String y) {
//		x = find(x);
//		int sizeX = size.getOrDefault(x, 0);
//
//		y = find(y);
//		int sizeY = size.getOrDefault(y, 0);
//
//		if (x.equals(y)) return sizeX;
//		
//		int s;
//		if (sizeX == 0 && sizeY == 0) s = 2;
//		else if (sizeX != 0 && sizeY != 0) s = sizeX + sizeY;
//		else s = Math.max(sizeX, sizeY) + 1;
//		
//		if (x.compareTo(y) < 0) {
//			parent.put(x, x);
//			parent.put(y, x);
//		}
//		else {
//			parent.put(x, y);
//			parent.put(y, y);
//		}
//		size.put(x, s);
//		size.put(y, s);
//		return s;
//	}
//}
