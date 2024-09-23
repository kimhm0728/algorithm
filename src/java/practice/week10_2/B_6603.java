package java.practice.week10_2;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class B_6603 {
	private static int k;
	private static int[] s;
	private static int[] result = new int[6];
	private static boolean[] visit;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k == 0)
				break;
			
			s = new int[k];
			visit = new boolean[k];
			
			for(int i=0;i<k;i++)
				s[i] = Integer.parseInt(st.nextToken());
			
			dfs(0, 0);
			sb.append('\n');
		}
		
		System.out.println(sb);
	
	}

	private static void dfs(int start, int depth) {
		if(depth == 6) {
			for(int i=0;i<k;i++)
				if(visit[i])
					sb.append(s[i]).append(' ');
				//sb.append(result[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i=start;i<k;i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[depth] = s[i];
				dfs(i + 1, depth + 1);
				visit[i] = false;
			}
		}
	}
}
