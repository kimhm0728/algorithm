package greedy;

import java.io.*;

public class B_21314 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		StringBuilder max = new StringBuilder();
		StringBuilder min = new StringBuilder();
		
		// 가장 큰 수 : K가 나오는 인덱스까지 자르기
		for(int i=0;i<len;) {
			int idx = str.indexOf("K", i);
			if(idx == -1) { // K가 없으면 (M만 존재하면) M 하나씩 자르기
				max.append("1".repeat(len - i));
				break;
			}
			String num = mkToDecimal(str.substring(i, idx + 1));
			i = idx + 1;
			max.append(num);
		}
		
		// 가장 작은 수 : K가 나오는 인덱스 전까지 자르기
		for(int i=0;i<len;) {
			if(str.charAt(i) == 'K') { // 현재 문자가 K면 K 하나만 자르기
				min.append("5");
				i++;
				continue;
			}
			
			int idx = str.indexOf("K", i);
			if(idx == -1) { // K가 없으면 끝까지 자르기
				min.append(mkToDecimal(str.substring(i, len)));
				break;
			}
			String num = mkToDecimal(str.substring(i, idx));
			i = idx;
			min.append(num);
		}
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static String mkToDecimal(String str) {
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		
		if(!str.contains("K")) // M으로만 이루어진 경우
			sb.append("1");
		else // K가 포함된 경우 (K는 무조건 하나)
			sb.append("5");
		
		// 길이 - 1 만큼 0 반복
		sb.append("0".repeat(len - 1)); 
		return sb.toString();
	}

}
