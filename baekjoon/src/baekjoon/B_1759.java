package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class B_1759 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken()); // ¾ÏÈ£ ±æÀÌ
		int C = Integer.parseInt(st.nextToken()); // ¾ËÆÄºª °¹¼ö
		
		char[] arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++)
			arr[i] = st.nextToken().charAt(0);
	}

}
