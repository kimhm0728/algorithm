package java.practice.week10_2;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class B_11725 {
	private static int parent[];
	private static List<Integer> list[];
	private static boolean visit[];
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		parent = new int[n+1];
		visit = new boolean[n+1];
		
		for(int i=1;i<n+1;i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i=1;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			list[a].add(b);
			list[b].add(a);
		}
			
		visit[1] = true;
		dfs(1);
		
		for(int i=2;i<n+1;i++)
			sb.append(parent[i]).append('\n');
		
		System.out.println(sb);
	}
	
	private static void dfs(int idx) {
		for(int val : list[idx]) 
			if(!visit[val]) {
				visit[val] = true;
				parent[val] = idx;
				dfs(val);
			}
	}

}
