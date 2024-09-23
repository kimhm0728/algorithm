package java.practice.baekjoon;
import java.util.Scanner;

public class B_2422 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt(); // ���̽�ũ�� ������ ��
		int m = stdin.nextInt(); // ��������� �ȵǴ� ������ ����
		
		boolean array[][] = new boolean[n+1][n+1]; 
		for(int i=0;i<m;i++) {
			int a = stdin.nextInt();
			int b = stdin.nextInt();
			array[a][b] = true;
			array[b][a] = true;
		}
		stdin.close();
		
		int a = 0;
		for(int i=1;i<=n;i++)
			for(int j=i+1;j<=n;j++) 
				for(int k=j+1;k<=n;k++) {
					if(array[i][j] || array[j][k] || array[k][i])
						continue;
					a++; // ��� false�̸� a�� ����
				}
		
		System.out.println(a);
		
	}

}
