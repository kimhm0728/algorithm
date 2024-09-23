package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_25305 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // ������ ��
		int k = Integer.parseInt(st.nextToken()); // �� �޴� ��� ��
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
			list.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(list);
		System.out.println(list.get(n-k));
	}

}
