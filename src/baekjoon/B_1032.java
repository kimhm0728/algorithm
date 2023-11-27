package baekjoon;
import java.util.*;

public class B_1032 {
	public static void main(String[] args) {
		Scanner stdin=new Scanner(System.in);
		int n=stdin.nextInt();
		String str[]=new String[n];
		for(int i=0;i<n;i++)
			str[i]=stdin.next();
		
		boolean x;
		for(int i=0;i<str[0].length();i++) { // 문자열 길이 만큼 반복
			x=true;
			for(int j=0;j<n-1;j++) { // n개의 문자열 모두 비교
				if(str[j].charAt(i)!=str[j+1].charAt(i)) {
					x=false;
					break;
				}
			}
			if(x) { // n개의 문자열의 i번째 자리가 모두 같을 때
				System.out.print(str[0].charAt(i));
			}
			else // x==false 일 때. 즉, 문자열의 i번째 자리가 하나라도 다를 때
				System.out.print('?');
		}
		stdin.close();
	}
}
