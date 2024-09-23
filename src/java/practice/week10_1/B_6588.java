package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class B_6588 {
	static boolean[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		ArrayList<Integer> list = new ArrayList<>();

		int max = 0;

		while(true) {
			int value = Integer.parseInt(br.readLine());
			if(value == 0)
				break;
			if(max < value)
				max = value;
			list.add(value);
		}

		prime(max);
		
		for(int i=0;i<list.size();i++) {
			int value = list.get(i);
			for(int j=value;j>=2;j--) {
				if(arr[j] == false && arr[value-j] == false) {
					flag = true;
					sb.append(value).append(" = ").append(value-j).append(" + ").append(j).append('\n');
					break;
				}
			}
			if(flag == false)
				sb.append("Goldbach's conjecture is wrong.").append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static void prime(int n) {
		arr = new boolean[n+1];
		arr[0] = arr[1] = true;
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(arr[i]) continue;
			for(int j=i*i;j<arr.length;j+=i)
				arr[j] = true;
		}
	}

}
