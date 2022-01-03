package class1;
import java.io.*;
import java.util.StringTokenizer;

public class B_10818 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int max = -1000001;
		int min = 1000001;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int tk = Integer.parseInt(st.nextToken());
			if(tk > max)
				max = tk;
			if(tk < min)
				min = tk;
		}
		System.out.println(min + " " + max);
	}

}
