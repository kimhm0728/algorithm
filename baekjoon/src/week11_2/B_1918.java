package week11_2;

import java.io.*;
import java.util.*;

public class B_1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		Stack<Character> stack = new Stack<>();
		for(char c : str.toCharArray()) {
			if(c >= 'A' && c <= 'Z')
				sb.append(c);
			else {
				if(c == '(')
					stack.push(c);
				else if(c == ')') {
					while(true) {
						char temp = stack.pop();
						if(temp == '(')
							break;
						sb.append(temp);
					}
				}
				else { // */+-
					while(!stack.empty() && priority(stack.peek()) >= priority(c))
						sb.append(stack.pop());
					stack.push(c);
				}
			}
		}
		
		while(!stack.empty())
			sb.append(stack.pop());
		
		System.out.println(sb);

	}

	static int priority(char c) {
		if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        else return 0; 
	}

}
