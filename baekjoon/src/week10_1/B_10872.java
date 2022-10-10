package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B_10872 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(pacto(n));
	}
	private static int pacto(int a) {
		if(a == 0 || a == 1) return 1;
		else return a * pacto(a-1);
	}
}
