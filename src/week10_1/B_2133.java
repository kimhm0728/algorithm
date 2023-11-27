package week10_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2133 {
	static int[] arr = new int[31];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(dp(n));
	}
	static int dp(int n) {
		// if n=8일 경우 dp(n-8), 자기자신에 해당하는 두 경우도 더해줘야함.
		// 즉 dp(n-n)*2=2가 되기 위해서 dp(0)일 경우 1을 반환
		// 이를 대신해 아래 주석과 같은 if문으로 대체 가능 (for문 조건문이 >= 아닌 >이어야 함)
		if(n == 0) return 1; 
		if(n == 1) return 0;
		if(n == 2) return 3;
		if(arr[n] != 0) return arr[n];
		arr[n] = 3 * dp(n-2);
		for(int i=4;n-i>=0;i+=2) {
			arr[n] += 2 * dp(n-i);
		}
		// if(n>2 && n%2==0)
		//		arr[2] += 2;
		return arr[n];
	}
}
