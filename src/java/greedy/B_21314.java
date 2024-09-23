package java.greedy;

import java.io.*;

public class B_21314 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		StringBuilder max = new StringBuilder();
		StringBuilder min = new StringBuilder();
		
		// ���� ū �� : K�� ������ �ε������� �ڸ���
		for(int i=0;i<len;) {
			int idx = str.indexOf("K", i);
			if(idx == -1) { // K�� ������ (M�� �����ϸ�) M �ϳ��� �ڸ���
				max.append("1".repeat(len - i));
				break;
			}
			String num = mkToDecimal(str.substring(i, idx + 1));
			i = idx + 1;
			max.append(num);
		}
		
		// ���� ���� �� : K�� ������ �ε��� ������ �ڸ���
		for(int i=0;i<len;) {
			if(str.charAt(i) == 'K') { // ���� ���ڰ� K�� K �ϳ��� �ڸ���
				min.append("5");
				i++;
				continue;
			}
			
			int idx = str.indexOf("K", i);
			if(idx == -1) { // K�� ������ ������ �ڸ���
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
		
		if(!str.contains("K")) // M���θ� �̷���� ���
			sb.append("1");
		else // K�� ���Ե� ��� (K�� ������ �ϳ�)
			sb.append("5");
		
		// ���� - 1 ��ŭ 0 �ݺ�
		sb.append("0".repeat(len - 1)); 
		return sb.toString();
	}

}
