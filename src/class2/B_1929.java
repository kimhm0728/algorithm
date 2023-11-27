package class2;
import java.io.*;
import java.util.StringTokenizer;

public class B_1929 {
	static int[] prime;
	// 배열 값이 0이면 소수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		get_prime(end);
		for(int i=start;i<=end;i++) {
			if(prime[i] == 0) {
				sb.append(i);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	static void get_prime(int a) { // 에라토스테네스의 체
		prime = new int[a+1];
		
		prime[0] = prime[1] = 1;
		for(int i=2;i<=Math.sqrt(a);i++) {
			if(prime[i] == 1) // 이미 체크된 값이면 넘어감
				continue;
			for(int j=i*i;j<=a;j+=i) // i의 배수를 제외시킴
				prime[j] = 1;
			// j가 i*2이 아닌 i*i로 시작하는 이유. 어차피 i가 2일 때 i*i는 4이고, 
			// 2의 배수를 제외시키는 과정에서 i*2(2의 배수)는 모두 체크되기 때문에. i*i로 하는게 시간복잡도 더 낮음.
		}
	}
}
