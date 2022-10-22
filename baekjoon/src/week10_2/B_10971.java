package week10_2;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_10971 {
	private static int arr[][];
	private static boolean visit[];
	private static int path[];
	private static int n;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n];
		path = new int[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		System.out.println(min);
	}
	
	private static void dfs(int depth) {
		if(depth == n) {
			int cost = costCalcute();
			if(cost != -1) 
				min = Math.min(min, cost);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				path[depth] = i;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
	
	private static int costCalcute() {
		int cost = 0;
		
		for(int i=0;i<n-1;i++) {
			int p = path[i];
			int nextP = path[i+1];
			if(arr[p][nextP] == 0) 
				return -1;

			cost += arr[p][nextP];
		}
		
		int back = arr[path[n-1]][path[0]];
		if(back == 0)
			return -1;
		
		cost += back;
		return cost;
	}

}
