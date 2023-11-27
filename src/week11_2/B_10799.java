package week11_2;

import java.util.*;
import java.io.*;

public class B_10799 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		int cnt = 0;
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			
			if(c == '(') {
				if(str.charAt(i + 1) == ')') { // ()면 레이저
					i++;
					cnt += stack.size();
					continue;
				}
				stack.push(c);
			}
			if(c == ')') {
				stack.pop();
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}
