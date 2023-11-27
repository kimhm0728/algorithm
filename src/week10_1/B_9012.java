package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class B_9012 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j=0;j<chars.length;j++) {
				if(chars[j] == '(')
					stack.push(chars[j]);
				else if(chars[j] == ')') {
					if(!stack.empty()) {
						stack.pop();
					}
					else {
						stack.push(chars[j]);
						break;
					}
				}
			}
			if(stack.empty())
				sb.append("YES").append('\n');
			else
				sb.append("NO").append('\n');
			stack.clear();
		}
		System.out.println(sb);
	}

}
