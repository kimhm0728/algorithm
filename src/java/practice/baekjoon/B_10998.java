package java.practice.baekjoon;
import java.io.*;

public class B_10998 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split("\\s+");
		
		System.out.println(Integer.parseInt(num[0])*Integer.parseInt(num[1]));
	}

}
