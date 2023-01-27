package bruteForce;

import java.util.*;
import java.io.*;

public class B_16637 {
	static int N;
	static ArrayList<Integer> num;
	static ArrayList<Character> oper;
	static boolean[] visit;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		num = new ArrayList<>();
		oper = new ArrayList<>();
		
		String str = br.readLine();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);

			if(c >= '0' && c <= '9')
				num.add(c - '0');
			else
				oper.add(c);
		}

		visit = new boolean[N / 2 + 1];
		DFS(0, 0);
		System.out.println(answer);
	}

	static void DFS(int depth, int start) {
		answer = Math.max(answer, getResult());

		for(int i=start;i<N/2;i++) {
			if(visit[i] || visit[i + 1])
				continue;

			visit[i] = true;
			visit[i + 1] = true;

			// i와 i + 1번째에 괄호치기 (괄호 안의 값 계산해서 arraylist에 반영)
			int a = num.get(i - depth); // depth가 현재 숫자 앞의 괄호의 개수이므로 이미 계산한 만큼 list의 idx를 맞춰줌
			int b = num.get(i - depth + 1);
			char o = oper.get(i - depth);
			int result = calcute(a, b, o);
			num.set(i - depth, result);
			num.remove(i - depth + 1);
			oper.remove(i - depth);

			DFS(depth + 1, start + 2);

			// arraylist 되돌리기
			visit[i] = false;
			visit[i + 1] = false;
			num.set(i - depth, a);
			num.add(i - depth + 1, b);
			oper.add(i - depth, o);
		}
	}

	static int getResult() {
		int result;
		int size = num.size();
		if(size > 1) {
			result = calcute(num.get(0), num.get(1), oper.get(0));
			for(int i=2;i<size;i++) 
				result = calcute(result, num.get(i), oper.get(i - 1));
		}
		else 
			result = num.get(0);
		
		return result;

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
