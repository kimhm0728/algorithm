package java.greedy;

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
			while(plus.hasMoreTokens()) // + ���� ���� ����
				temp += Integer.parseInt(plus.nextToken());
			
			// + ���� ������ ����� - ���� ����
			if(answer == Integer.MAX_VALUE) // ���� �տ� �ִ� ���ڸ� answer�� �ʱ�ȭ
				answer = temp;
			else
				answer -= temp; 
		}
		
		System.out.println(answer);
	}

}
