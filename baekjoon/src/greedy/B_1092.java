package greedy;

import java.util.*;
import java.io.*;

public class B_1092 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] crane = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			crane[i] = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> box = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++)
			box.add(Integer.parseInt(st.nextToken()));

		Arrays.sort(crane, Collections.reverseOrder());
		box.sort(Collections.reverseOrder());

		if(box.get(0) > crane[0]) { // 가장 무거운 박스가 가장 큰 크레인의 무게 제한보다 크다면 배로 옮길 수 없음
			System.out.println(-1);
			return;
		}

		ArrayList<Integer> temp = new ArrayList<>();
		int answer = 1;
		int idx = 0; // crane 배열 인덱스

		while(!box.isEmpty() || !temp.isEmpty()) {
			if(idx >= N) {
				answer++;
				idx %= N;
				box.addAll(temp);
				temp.clear();
				box.sort(Collections.reverseOrder());
			}

			int now_box = box.isEmpty() ? -1 : box.get(0);
			if(now_box != -1 && now_box <= crane[idx]) { 
				idx++;
				box.remove(0);
			}
			else {
				if(now_box == -1 || crane[idx] < box.get(box.size() - 1)) {
					answer++;
					idx = 0;
					box.addAll(temp);
					temp.clear();
					box.sort(Collections.reverseOrder());
				}
				else {
					box.remove(0);
					temp.add(now_box); // 현재 크레인으로 움직일 수 없는 경우 리스트 뒤에 넣기
				}
			}		
		}

		System.out.println(answer);
	}

}
