package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B_9655 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(solution(0, n) == 0 ? "SK" : "CY");
	}
	
	static int solution(int o, int i) {
		if (i == 1 || i == 3) return o;
		
		if (i < 3) return solution((o + 1) % 2, i - 1);
		return solution((o + 1) % 2, i - 3);
	}
}
