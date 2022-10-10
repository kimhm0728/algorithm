package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.ListIterator;

public class B_1406 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<Character> list = new LinkedList<>();
		StringTokenizer st;
		
		char[] chars = br.readLine().toCharArray();
		
		for(int i=0;i<chars.length;i++)
			list.add(chars[i]);
		
		ListIterator<Character> iter = list.listIterator();
		
		while(iter.hasNext())
			iter.next();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
			case "L":
				if(iter.hasPrevious())
					iter.previous();
				break;
			case "D":
				if(iter.hasNext())
					iter.next();
				break;
			case "B":
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case "P":
				char c = st.nextToken().charAt(0);
				iter.add(c);
				break;
			}
		}
		for(char c : list)
			sb.append(c);
		System.out.println(sb);
	}

}
