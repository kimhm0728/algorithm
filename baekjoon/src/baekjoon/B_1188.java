package baekjoon;
import java.util.*;
import java.io.*;

public class B_1188 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 소시지의 수
		int M = Integer.parseInt(st.nextToken()); // 평론가의 수
		System.out.println(M - gcd(N, M));
	}
	static int gcd(int a, int b) {
		if(b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
}
