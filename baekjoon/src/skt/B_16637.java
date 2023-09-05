package skt;

import java.util.*;
import java.io.*;

public class B_16637 {
	static int n;
	static ArrayList<Integer> num;
	static ArrayList<Character> oper;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		num = new ArrayList<>();
		oper = new ArrayList<>();
		
		String s = br.readLine();
		for (int i=0;i<n;i++) {
			if (i % 2 == 0) num.add(s.charAt(i) - '0');
			else oper.add(s.charAt(i));
		}
		
		DFS(1, n / 2 + 1);
		System.out.println(answer);
	}
	
	static void DFS(int idx, int cnt) {
		if (idx + 1 >= cnt) {
			int result = num.get(0);
			for (int i=1;i<num.size();i++) {
				result = calculate(result, num.get(i), oper.get(i - 1));
			}
			answer = Math.max(answer, result);
			return;
		}
		
		for (int i=idx;i<cnt-1;i++) {
			int n1 = num.get(i);
			int n2 = num.get(i + 1);
			char o = oper.get(i);
			num.set(i, calculate(n1, n2, o));
			num.remove(i + 1);
			oper.remove(i);
			DFS(i + 1, cnt - 1);
			
			num.set(i, n1);
			num.add(i + 1, n2);
			oper.add(i, o);
			DFS(i + 1, cnt);
		}
	}

	static int calculate(int n1, int n2, char o) {
		if (o == '+') return n1 + n2;
		if (o == '-') return n1 - n2;
		return n1 * n2;
	}
}
