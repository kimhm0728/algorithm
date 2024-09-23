package java.practice.baekjoon;
import java.io.*;

public class B_2753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if((n % 100 != 0 && n % 4 == 0) || n % 400 == 0)
			System.out.println("1");
		else
			System.out.println("0");

	}

}
