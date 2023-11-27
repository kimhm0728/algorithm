package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class B_1874 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i=0;i<n;i++) {
			int value = Integer.parseInt(br.readLine());
			if(cnt < value) {
				while(cnt != value) {
					stack.push(++cnt);
					sb.append('+').append('\n');
				}
			}
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append('-').append('\n');
		}

		System.out.println(sb);
	}

}
