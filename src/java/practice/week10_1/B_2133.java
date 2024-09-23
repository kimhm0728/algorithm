package java.practice.week10_1;
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
		// if n=8�� ��� java.dp(n-8), �ڱ��ڽſ� �ش��ϴ� �� ��쵵 ���������.
		// �� java.dp(n-n)*2=2�� �Ǳ� ���ؼ� java.dp(0)�� ��� 1�� ��ȯ
		// �̸� ����� �Ʒ� �ּ��� ���� if������ ��ü ���� (for�� ���ǹ��� >= �ƴ� >�̾�� ��)
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
