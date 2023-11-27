package class1;
import java.io.*;

public class B_3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[42];
		
		for(int i=0;i<10;i++)
			num[Integer.parseInt(br.readLine()) % 42] = 1;
		
		int cnt = 0;
		for(int i=0;i<42;i++)
			if(num[i] == 1)
				cnt++;
		System.out.println(cnt);
	}

}
