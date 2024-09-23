package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_1476 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int e, s, m;
		e = s = m = 1;
		
		int year = 1;
		while(true) {
			if(E == e && S == s && M == m)
				break;
			e++;
			s++;
			m++;
			if(e > 15)
				e = 1;
			if(s > 28)
				s = 1;
			if(m > 19)
				m = 1;
			year++;
		}
		
		System.out.println(year);
		
	}

}
