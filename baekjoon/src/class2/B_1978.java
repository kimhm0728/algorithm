package class2;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class B_1978 {
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		count = 0;

		for(int i=0;i<N;i++) 
			is_Prime(Integer.parseInt(st.nextToken()));
		
		System.out.println(count);
	}
	static void is_Prime(int n) {
		if(n == 1)
			return;
		else if(n == 2) {
			count++;
			return;
		}
		else {
			for(int i=2;i<n;i++) 
				if(n % i == 0)
					return;
			count++;
		}
	}
}
