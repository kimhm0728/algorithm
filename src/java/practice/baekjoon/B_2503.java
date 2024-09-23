package java.practice.baekjoon;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2503 {
	static int N;
	static int[][] base;
	static int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		base = new int[N][5];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			// �Է����� �־��� ���� �� ���ھ� ����
			String input = st.nextToken();
			base[i][0] = input.charAt(0) - '0';
			base[i][1] = input.charAt(1) - '0';
			base[i][2] = input.charAt(2) - '0';
			base[i][3] = Integer.parseInt(st.nextToken()); // ��Ʈ����ũ
			base[i][4] = Integer.parseInt(st.nextToken()); // ��
		}
		perm(num, 0, 9, 3);
		System.out.println(cnt);
	}
	static void perm(int[] arr, int depth, int n, int r) { // n�� �� r���� �̴� ����
		if(depth == r) 
			baseBall(arr);
		for(int i=depth;i<n;i++) {
			swap(arr, depth, i);
			perm(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	static void baseBall(int[] arr) {
		int strike, ball;
		for(int i=0;i<N;i++) { // ������ ���� ���ڿ� �Էµ� ���� N���� ��� ��
			strike = 0; ball = 0;
			for(int j=0;j<3;j++) // ��Ʈ����Ʈ ���� ����
				if(arr[j] == base[i][j])
					strike++;
			for(int k=0;k<3;k++) // �� ���� ����
				for(int l=0;l<3;l++)
					if(k != l && arr[k] == base[i][l])
						ball++;
			if(strike != base[i][3] || ball != base[i][4]) 
				// ��Ʈ����ũ�� �� ������ �ٸ��� cnt�� �������� �ʰ� �ٷ� return 
				return;
		}
		cnt++;
	}
}
