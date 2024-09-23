package java.practice.baekjoon;
import java.util.*;

public class B_1032 {
	public static void main(String[] args) {
		Scanner stdin=new Scanner(System.in);
		int n=stdin.nextInt();
		String str[]=new String[n];
		for(int i=0;i<n;i++)
			str[i]=stdin.next();
		
		boolean x;
		for(int i=0;i<str[0].length();i++) { // ���ڿ� ���� ��ŭ �ݺ�
			x=true;
			for(int j=0;j<n-1;j++) { // n���� ���ڿ� ��� ��
				if(str[j].charAt(i)!=str[j+1].charAt(i)) {
					x=false;
					break;
				}
			}
			if(x) { // n���� ���ڿ��� i��° �ڸ��� ��� ���� ��
				System.out.print(str[0].charAt(i));
			}
			else // x==false �� ��. ��, ���ڿ��� i��° �ڸ��� �ϳ��� �ٸ� ��
				System.out.print('?');
		}
		stdin.close();
	}
}
