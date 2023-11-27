package implementation;

import java.util.*;
import java.io.*;

public class B_1725 {
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n + 2];
		
		for (int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<Integer>();

		int ans = 0;
		stack.push(0);
		
		for (int i=1;i<=n+1;i++) {
			while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				int height = arr[stack.peek()];
		        stack.pop();
		        int width = i - stack.peek() - 1;

				ans = Math.max(ans, width * height);
			}
			stack.push(i);
		}
		
		System.out.println(ans);
	}
	
}