package week11_2;

import java.io.*;
import java.util.*;

public class B_2504 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// 0, °ýÈ£ / 1, ¼ýÀÚ
		Stack<int[]> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			int c = (int)str.charAt(i);
			if(c == '(' || c == '[')
				stack.push(new int[] {0, c});
			else {
				int sum = 0;
				while(true) {
					if(stack.empty()) error();
					int[] pop = stack.pop();
					if(pop[0] == 0 && pop[1] == '(' && c == ')') {
						if(sum == 0)
							stack.push(new int[] {1, 2});
						else
							stack.push(new int[] {1, sum * 2});
						break;
					}
					if(pop[0] == 0 && pop[1] == '[' && c == ']') {
						if(sum == 0)
							stack.push(new int[] {1, 3});
						else
							stack.push(new int[] {1, sum * 3});
						break;
					}
					if(pop[0] == 1) sum += pop[1];
					else error();
				}
			}
		}
		
		int ans = 0;
		while(!stack.empty()) {
			int[] pop = stack.pop();
			if(pop[0] == 0) error();
			else ans += pop[1];
		}
		System.out.println(ans);
		
	}
	
	static void error() {
		System.out.println(0);
		System.exit(0);
	}
}
