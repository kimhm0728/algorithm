package java.practice.week10_1;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class B_10828 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(!stack.empty())
					sb.append(stack.pop()).append('\n');
				else
					sb.append("-1").append('\n');
				break;
			case "size":
				sb.append(stack.size()).append('\n');
				break;
			case "empty":
				if(stack.empty())
					sb.append('1').append('\n');
				else
					sb.append('0').append('\n');
				break;
			case "top":
				if(!stack.empty())
					sb.append(stack.peek()).append('\n');
				else
					sb.append("-1").append('\n');
				break;
			}
		}
		System.out.println(sb);
	}

}
