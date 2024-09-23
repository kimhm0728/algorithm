package java.practice.week11_2;

import java.io.*;
import java.util.*;

public class B_1935 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		Stack<Double> stack = new Stack<>();
		
		double[] num = new double[N];
		for(int i=0;i<N;i++)
			num[i] = Double.parseDouble(br.readLine());
		
		for(char c : str.toCharArray()) {
			if(c >= 'A' && c <= 'Z')
				stack.push(num[c - 65]);
			else {
				double a = stack.pop();
				double b = stack.pop();
				
				switch(c) {
				case '+':
					stack.push(b + a);
					break;
				case '-':
					stack.push(b - a);
					break;
				case '*':
					stack.push(b * a);
					break;
				case '/':
					stack.push(b / a);
					break;
				}
			}
		}
		
		System.out.println(String.format("%.2f", stack.peek()));
	}

}
