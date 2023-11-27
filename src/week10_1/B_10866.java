package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class B_10866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		LinkedList<Integer> list = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
			case "push_front":
				list.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				list.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(list.isEmpty())
					sb.append("-1").append('\n');
				else
					sb.append(list.removeFirst()).append('\n');
				break;
			case "pop_back":
				if(list.isEmpty())
					sb.append("-1").append('\n');
				else
					sb.append(list.removeLast()).append('\n');
				break;
			case "size":
				sb.append(list.size()).append('\n');
				break;
			case "empty":
				if(list.isEmpty())
					sb.append("1").append('\n');
				else
					sb.append("0").append('\n');
				break;
			case "front":
				if(list.isEmpty())
					sb.append("-1").append('\n');
				else
					sb.append(list.peekFirst()).append('\n');
				break;
			case "back":
				if(list.isEmpty())
					sb.append("-1").append('\n');
				else
					sb.append(list.peekLast()).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}

}
