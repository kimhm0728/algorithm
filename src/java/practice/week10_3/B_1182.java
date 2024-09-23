package java.practice.week10_3;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1182 {
	private static int[] arr;
	private static int[] result;
	private static boolean[] visit;
	private static int N, S;
	private static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			DFS(0, 0, i);
		}
		
		System.out.println(cnt);
	}
	
	private static void DFS(int start, int depth, int num) {
		if(depth == num) {
			if(sum(num) == S)
				cnt++;
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[depth] = arr[i];
				DFS(i + 1, depth + 1, num);
				visit[i] = false;
			}
		}
		
	}
	
	private static int sum(int num) {
		int sum = 0;
		for(int i=0;i<num;i++) 
			sum += result[i];
		return sum;
	}

}
