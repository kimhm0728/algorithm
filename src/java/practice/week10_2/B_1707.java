package java.practice.week10_2;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1707 {
	static int visit[];
	static List<Integer> list[];
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<K;i++) {
			check = false;
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[v+1];
			visit = new int[v+1];
			for(int j=1;j<v+1;j++)
				list[j] = new ArrayList<Integer>();
			
			for(int j=0;j<e;j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			for(int j=1;j<v+1;j++) {
				if(visit[j] == 0)
					dfs(j);
			}
			
			if(check)
				sb.append("NO").append('\n');
			else
				sb.append("YES").append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	private static void dfs(int depth) {
		if(visit[depth] == 0)
			visit[depth] = 1;
		for(int val : list[depth]) {
			if(visit[val] != 0) {
				if(visit[val] == visit[depth]) {
					check = true;
					return;
				}
			}
			else {
				visit[val] = visit[depth] == 2 ? 1 : 2;
				dfs(val);
			}
		}
	}

}
