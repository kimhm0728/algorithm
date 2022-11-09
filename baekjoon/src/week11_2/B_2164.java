package week11_2;

import java.util.*;
import java.io.*;

public class B_2164 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<N;i++)
			q.offer(i + 1);
		
		while(q.size() != 1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.println(q.peek());
	}

}
