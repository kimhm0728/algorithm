package baekjoon;
import java.util.*;
import java.io.*;

public class B_1924 {
	static int[] month = {31, 28, 31, 30, 31, 30, 31,
			31, 30, 31, 30, 31};
	static String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"}; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		whatDay(x, y);
	}
	static void whatDay(int m, int d) {
		int day = d;
		for(int i=0;i<m-1;i++) 
			day += month[i];
		System.out.println(week[day % 7]);
	}
}
