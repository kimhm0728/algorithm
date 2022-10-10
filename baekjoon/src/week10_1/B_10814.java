package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10814 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}

		Arrays.sort(arr, (s1, s2) -> {
			return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
		});
		
		for(int i=0;i<n;i++)
			sb.append(arr[i][0]+" "+arr[i][1]+'\n');
		
		System.out.println(sb);
	}

}
