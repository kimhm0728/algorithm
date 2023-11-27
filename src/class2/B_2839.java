package class2;
import java.io.*;

public class B_2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = -1; // 봉지의 최소 개수

		if(N % 5 == 0)
			num = N / 5;
		else if(N % 3 == 0)
			num = N / 3;
		for(int i=N/5;i>0;i--) {
			int a = N - i * 5;
			if(a % 3 == 0) {
				num = i + a / 3;
				break;
			}
		}
		System.out.println(num);
	}
}