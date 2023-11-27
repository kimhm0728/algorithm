package week11_2;

import java.util.*;
import java.io.*;

public class B_2493 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>(); // ¿Œµ¶Ω∫, ≥Ù¿Ã
		
		for(int i=0;i<N;i++) {
			int arr[] = {i + 1, Integer.parseInt(st.nextToken())};
			while(!stack.empty()) {
				if(arr[1] >= stack.peek()[1]) 
					stack.pop();
				else {
					sb.append(stack.peek()[0]).append(' ');
					break;
				}
			}
			if(stack.empty())
				sb.append("0 ");
			stack.push(arr);
		}
		
		System.out.println(sb);
	}

}
