package java.practice.week11_2;

import java.io.*;
import java.util.*;

public class B_1874 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int cnt = 1;

		Stack<Integer> stack = new Stack<>();

		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(cnt <= num) {
				while(cnt - 1 != num) {
					stack.push(cnt++);
					sb.append('+').append('\n');
				}
				stack.pop();
				sb.append('-').append('\n');
			}
			else // cnt > num
				while(true) { 
					if(stack.isEmpty()) {
						System.out.println("NO");
						return;
					}
					int temp = stack.pop();
					sb.append('-').append('\n');
					if(temp == num)
						break;
				}
		}

		System.out.println(sb);
	}

}
