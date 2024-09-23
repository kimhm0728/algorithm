package java.bruteforce;

import java.io.*;

public class B_16637 {
	static int N, n; // ������ ����, ������ ����
	static int[] num;
	static char[] oper;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		n = N / 2 + 1;
		
		num = new int[n];
		oper = new char[n - 1];
		
		String str = br.readLine();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);

			if(c >= '0' && c <= '9')
				num[i / 2] = c - '0';
			else
				oper[i / 2] = c;
		}

		DFS(0, num[0]);
		System.out.println(answer);
	}

	static void DFS(int idx, int result) {
		if(idx >= n - 1) {
			answer = Math.max(answer, result);
			return;
		}
		
		DFS(idx + 1, calcute(result, num[idx + 1], oper[idx]));
		
		if(idx + 2 < n) {
			int temp = calcute(num[idx + 1], num[idx + 2], oper[idx + 1]);
			DFS(idx + 2, calcute(result, temp, oper[idx]));
		}
	}

	static int calcute(int a, int b, char o) {
		switch(o) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}

		return 0;
	}

}
