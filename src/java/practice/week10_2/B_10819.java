package java.practice.week10_2;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_10819 {
	private static int arr[];
	private static int result[];
	private static boolean visit[];
	private static int n;
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		result = new int[n];
		visit = new boolean[n];
		
		st = new StringTokenizer(br.readLine());	
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int depth) {
		if(depth == n) {
			max = Math.max(maxCalcute(), max);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[depth] = arr[i];
				dfs(depth + 1);
				visit[i] = false;
			}
		}
		
	}
	
	private static int maxCalcute() {
		int m = 0;
		for(int i=0;i<n-1;i++)
			m += Math.abs(result[i] - result[i+1]);
		return m;
	}
}
