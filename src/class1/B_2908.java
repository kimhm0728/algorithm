package class1;
import java.io.*;

public class B_2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		int[] n = numSwap(input);
		if(n[0] < n[1])
			System.out.println(n[1]);
		else
			System.out.println(n[0]);
		
	}
	static int[] numSwap(String[] num) {
		int[] result = new int[2];
		for(int i=0;i<2;i++) 
			result[i] = Integer.parseInt(num[i].substring(2, 3) + 
					num[i].substring(1,2) + num[i].substring(0, 1));
		return result;
	}
}
