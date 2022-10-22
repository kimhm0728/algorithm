package week10_2;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B_1260 {
	static List<Integer> list[];
	static int n, m;
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
	
		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		
		for(int i=1;i<n+1;i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1;i<n+1;i++)
			Collections.sort(list[i]);
		
		dfs(v);
		sb.append('\n');
		visit = new boolean[n+1];
		bfs(v);
		
		System.out.println(sb);
		
	}

	static void dfs(int idx) {
		visit[idx] = true;
		sb.append(idx).append(' ');
		for(int val : list[idx]) 
			if(!visit[val]) 
				dfs(val);
	}

	static void bfs(int idx) {
		queue.offer(idx);
		visit[idx] = true;
		while(!queue.isEmpty()) {
			int num = queue.poll();
			sb.append(num).append(' ');
			
			for(int val : list[num]) 
				if(!visit[val]) {
					queue.offer(val);
					visit[val] = true;
				}
		}
	}

}
