package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_15651 {
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		
		dfs(n, m, 0);
		System.out.println(sb);
	}
	
	private static void dfs(int n, int m, int depth) {
		if(m == depth) {
			for(int val : arr)
				sb.append(val).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i=0;i<n;i++) {
			arr[depth] = i+1;
			dfs(n, m, depth + 1);
		}
	}

}
