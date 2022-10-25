package week10_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_1167 {
	private static int V;
	private static List<int[]> list[];
	private static boolean visit[];
	private static int max = -1;
	private static int node;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		visit = new boolean[V+1];
		
		for(int i=1;i<=V;i++)
			list[i] = new ArrayList<>();
		
		for(int i=1;i<=V;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			while(true) {
				int v = Integer.parseInt(st.nextToken());
				
				if(v == -1)
					break;
				
				int degree = Integer.parseInt(st.nextToken());
				list[n].add(new int[] {v, degree});
				
			}
		}
		
		DFS(1, 0);
		Arrays.fill(visit, false);
		DFS(node, 0);
		
		System.out.println(max);
	}

	private static void DFS(int idx, int distance) {
		if(max < distance) {
			max = distance;
			node = idx;
		}
		
		visit[idx] = true;
		
		for(int[] a : list[idx]) {
			if(!visit[a[0]]) {
				visit[a[0]] = true;
				DFS(a[0], distance + a[1]);
			}
		}
	}
	
}
