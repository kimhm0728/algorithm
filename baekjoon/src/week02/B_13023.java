package week02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class B_13023 {
	static List<Integer>[] list;
	static boolean check = false;
	static boolean[] visit;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];
		
		for(int i=0;i<n;i++)
			list[i] = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		for(int i=0;i<n;i++) {
			visit = new boolean[n];
			dfs(i, 1);
			if(check) {
				System.out.println(1);
                return;
            }
		}
		
        System.out.println(0);

	}
	
	static void dfs(int idx, int depth) {
		if(depth == 5) {
			check = true;
			return;
		}
		
		if(!visit[idx]) {
			visit[idx] = true;
			for(int val : list[idx]) {
				if(!visit[val])
					dfs(val, depth + 1);
			}
			visit[idx] = false;
		}
	}

}
