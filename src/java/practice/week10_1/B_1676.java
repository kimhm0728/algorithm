package java.practice.week10_1;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class B_1676 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		while(n>=5) {
			cnt += n/5;
			n/=5;
		}
		
		System.out.println(cnt);
	}

}
