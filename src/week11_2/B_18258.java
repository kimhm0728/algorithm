package week11_2;

import java.util.*;
import java.io.*;

public class B_18258 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> d = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			switch(cmd) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				d.offerLast(num);
				break;
			case "pop":
				if(!d.isEmpty())
					sb.append(d.pollFirst());
				else
					sb.append(-1);
				sb.append('\n');
				break;
			case "size":
				sb.append(d.size()).append('\n');
				break;
			case "empty":
				if(d.isEmpty())
					sb.append(1);
				else
					sb.append(0);
				sb.append('\n');
				break;
			case "front":
				if(!d.isEmpty())
					sb.append(d.peekFirst());
				else
					sb.append(-1);
				sb.append('\n');
				break;
			case "back":
				if(!d.isEmpty())
					sb.append(d.peekLast());
				else
					sb.append(-1);
				sb.append('\n');
				break;
			}
		}
		
		System.out.println(sb);
		
	}

}
