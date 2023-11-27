package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class B_1158 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1;i<=n;i++)
			que.offer(i);
		
		int cnt = 1;
		
		while(que.size() != 1) {
			while(cnt != k) {
				que.offer(que.poll());
				cnt++;
			}
			cnt = 1;
			sb.append(que.poll()).append(", ");
		}
		
		sb.append(que.poll()).append('>');
		System.out.println(sb);
	}

}
