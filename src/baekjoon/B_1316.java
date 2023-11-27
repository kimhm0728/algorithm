package baekjoon;
import java.util.Scanner;

public class B_1316 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		
		String array[] = new String[n];
		for(int i=0;i<n;i++)
			array[i] = stdin.next();
		stdin.close();
		
		int count = 0;
		for(int i=0;i<n;i++) 
			if(groupWord(array[i]))
				count++;
		System.out.println(count);
	}
	public static boolean groupWord(String s) {
		int num[] = new int[26]; // 알파벳 개수 세기
		for(int i=0;i<s.length();i++) {
			num[s.charAt(i)-'a']++;
			if(num[s.charAt(i)-'a'] > 1 && s.charAt(i-1) != s.charAt(i))
				return false;
		}
		return true;
		
	}
}
