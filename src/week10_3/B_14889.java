package week10_3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_14889 {
	private static int arr[][];
	private static boolean visit[];
	private static int N;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0, 0);
		System.out.println(min);
	}
	
	private static void DFS(int start, int depth) {
		if(depth == N/2) {
			min = Math.min(gapCalculate(), min);
			return;
		}
		for(int i=start;i<N;i++) {
			if(!visit[i]) {
				visit[i] = true;
				DFS(i + 1, depth + 1);
				visit[i] = false;
			}
		}
	}
	
	private static int gapCalculate() {
		int start = 0;
		int link = 0;
		
		for(int i=0;i<N;i++) 
			for(int j=0;j<N;j++) {
				if(visit[i] == true && visit[j] == true) 
					start += arr[i][j];
				if(visit[i] == false && visit[j] == false)
					link += arr[i][j];
			}
		
		return Math.abs(start - link);
	}

}
