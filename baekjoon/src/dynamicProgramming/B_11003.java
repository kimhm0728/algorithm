package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_11003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Deque<Node> deque = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			while (!deque.isEmpty() && deque.getLast().value > now) {
				deque.removeLast();
			}
			
			deque.addLast(new Node(now, i));
			if (deque.getFirst().index <= i-L) {
				deque.removeFirst();
			}
			
			sb.append(deque.getFirst().value + " ");
		}
		
		System.out.println(sb);
	}
	
	static class Node {
		int value;
		int index;
		
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}