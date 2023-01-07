package week_1_1;

import java.io.*;

public class B_14916 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int answer = n / 5;
		n %= 5;
		if(n % 2 == 1) { // 5원을 최대로 준 나머지가 홀수라면 5원 하나를 덜 주기
			if(answer == 0) { // 거슬러 줄 수 없는 경우
				System.out.println(-1);
				return;
			}
			answer--;
			n += 5;
		}
		answer += n / 2;

		System.out.println(answer);
	}

}
