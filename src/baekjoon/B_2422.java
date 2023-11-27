package baekjoon;
import java.util.Scanner;

public class B_2422 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt(); // 아이스크림 종류의 수
		int m = stdin.nextInt(); // 섞어먹으면 안되는 조합의 개수
		
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
					a++; // 모두 false이면 a를 증가
				}
		
		System.out.println(a);
		
	}

}
