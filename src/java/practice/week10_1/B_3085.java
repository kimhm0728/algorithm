package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B_3085 {
	static char arr[];
	static int max = 1;
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new char[n*n];

		for(int i=0;i<n*n;i+=n) {
			String[] str = br.readLine().split("");
			for(int j=0;j<n;j++)
				arr[i+j] = str[j].charAt(0);
		}
		
		for(int i=0;i<n*n-1;i++) {
			if(i < n*n-n)  // ���� �Ʒ��� �ִ� �� �����ϰ� �Ʒ� ���� �ٲ�
				if(arr[i] != arr[i+n]) maxCandy(i, i+n);
			if(i % n != n-1) // ���� �����ʿ� �ִ� �� �����ϰ� ������ ���� �ٲ� 
				if(arr[i] != arr[i+1]) maxCandy(i, i+1); // d
		}
		
		System.out.println(max);
		
	}
	
	static void swap(int a, int b) {
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	static void maxCandy(int a, int b) {
		swap(a, b);
		
		for(int i=0;i<n*n-1;i++) {
			int m = 1;
			if(i < n*n-n) { // ���� �Ʒ��� �ִ� �� ����
				int tmp = i;
				while(tmp+n < n*n && arr[tmp] == arr[tmp+n]) {
					m++;
					tmp += n;
				}
				if(max < m)
					max = m;
			}
			m = 1;
			if(i % n != n-1) { // ���� �����ʿ� �ִ� �� ����
				int tmp = i;
				while(tmp % n != n-1 && arr[tmp] == arr[tmp+1]) {
					m++;
					tmp++;
				}
				if(max < m)
					max = m;
			}
		}
		swap(a, b);
	}

}
