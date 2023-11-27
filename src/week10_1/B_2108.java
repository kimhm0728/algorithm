package week10_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2108 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[8001];
		int sum = 0;
		int min = 4001;
		int max = -4001;
		
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a < min)
				min = a;
			if(a > max)
				max = a;
			sum += a;
			arr[a+4000]++;
		}
		sb.append((int)Math.round((double)sum/n)).append('\n'); // »ê¼úÆò±Õ
		
		int index = 0;
		int value = 10000;
		boolean flag = false;
		boolean f = false;
		int cnt = 0;
		int center = 10000;
		
		for(int i=min+4000;i<=max+4000;i++) {
			if(arr[i] > 0) {
				// Áß¾Ó°ª 
				cnt += arr[i];
				if(cnt >= n/2+1 && f == false) {
					f = true;
					center = i - 4000;
				}
				// ÃÖºó°ª
				if(arr[i] > index) {
					index = arr[i];
					value = i - 4000;
					flag = true;
				}
				else if(index == arr[i] && flag == true) {
					value = i - 4000;
					flag = false;
				}
			}
		}
		
		sb.append(center).append('\n'); // Áß¾Ó°ª
		sb.append(value).append('\n'); // ÃÖºó°ª
		sb.append(max-min); // ¹üÀ§
		System.out.println(sb);
		
	}

}
