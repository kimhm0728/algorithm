package greedy;

import java.util.*;
import java.io.*;

public class B_1541 {
	static ArrayList<Integer> num;
	static ArrayList<Character> oper;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer minus = new StringTokenizer(input, "-");
		StringTokenizer plus;
		int answer = Integer.MAX_VALUE;
		
		while(minus.hasMoreTokens()) {
			plus = new StringTokenizer(minus.nextToken(), "+");
			int temp = 0;
			while(plus.hasMoreTokens()) // + 연산 먼저 수행
				temp += Integer.parseInt(plus.nextToken());
			
			// + 연산 수행한 결과를 - 연산 수행
			if(answer == Integer.MAX_VALUE) // 가장 앞에 있는 숫자를 answer로 초기화
				answer = temp;
			else
				answer -= temp; 
		}
		
		System.out.println(answer);
	}

}
