package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_10845 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<>();
		int push = -1;
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
			case "push":
				push = Integer.parseInt(st.nextToken());
				queue.offer(push);
				break;
			case "pop":
				if(!queue.isEmpty())
					sb.append(queue.poll()).append('\n');
				else
					sb.append("-1").append('\n');
				break;
			case "size":
				sb.append(queue.size()).append('\n');
				break;
			case "empty":
				if(queue.isEmpty())
					sb.append("1").append('\n');
				else
					sb.append("0").append('\n');
				break;
			case "front":
				if(!queue.isEmpty())
					sb.append(queue.peek()).append('\n');
				else
					sb.append("-1").append('\n');
				break;
			case "back":
				if(!queue.isEmpty())
					sb.append(push).append('\n');
				else
					sb.append("-1").append('\n');
				break;
			}
		}
		System.out.println(sb);
	}

}
