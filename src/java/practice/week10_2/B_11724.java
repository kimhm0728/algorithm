package java.practice.week10_2;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_11724 {
	static int n, m;
	static boolean visit[];
	static List<Integer> list[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		list = new ArrayList[n+1];
		
		for(int i=1;i<n+1;i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		int cnt = 0;
		for(int i=1;i<n+1;i++) {
			if(!visit[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	private static void dfs(int idx) {
		for(int val : list[idx])
			if(!visit[val]) {
				visit[val] = true;
				dfs(val);
			}
	}
}
