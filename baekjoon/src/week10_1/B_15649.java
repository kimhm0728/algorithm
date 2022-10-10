package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_15649 {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visit = new boolean[n];
		dfs(n, m, 0);
		System.out.println(sb);
		
	}
	
	static void dfs(int n, int m, int depth) {
		if(depth == m) {
			for(int val : arr)
				sb.append(val).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i=0;i<n;i++)
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(n, m, depth + 1);
				visit[i] = false;
			}
	}

}
