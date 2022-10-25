package week10_4;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class B_1967 {
	private static int max = -1;
	private static List<int []> list[];
	private static boolean visit[];
	private static int node;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		
		for(int i=1;i<=n;i++)
			list[i] = new ArrayList<>();
		
		for(int i=1;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int degree = Integer.parseInt(st.nextToken());
			
			list[parent].add(new int[] {child, degree});
			list[child].add(new int[] {parent, degree});
		}
		
		DFS(1, 0);
		visit = new boolean[n+1];
		DFS(node, 0);
		
		System.out.println(max);
	}
	
	private static void DFS(int idx, int degree) {
		if(max < degree) {
			max = degree;
			node = idx;
		}
		
		visit[idx] = true;
		for(int[] a : list[idx]) {
			if(!visit[a[0]]) {
				visit[a[0]] = true;
				DFS(a[0], degree + a[1]);
			}
		}
	}

}
