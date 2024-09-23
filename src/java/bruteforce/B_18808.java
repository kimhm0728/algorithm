package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_18808 {
	static int N, M, K;
	static boolean[][] notebook;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		notebook = new boolean[N][M];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			int[][] sticker = new int[r][c];
			for(int j=0;j<r;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<c;k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
					if(sticker[j][k] == 1)
						cnt++;
				}
			}
			
			attach(sticker, r, c, cnt, 3);
		}
		
		System.out.println(answer);
	}
	
	static void attach(int[][] sticker, int r, int c, int cnt, int rotate_cnt) {
		boolean flag = false;
		int startR = 0, startC = 0;
		
		Loop: for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(isAttach(sticker, i, j, r, c)) {
					startR = i; startC = j;
					flag = true;
					break Loop;
				}
			}
		}
		
		if(flag) {
			// ��ƼĿ ���̱�
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					if(sticker[i][j] == 1)
						notebook[startR + i][startC + j] = true;
				}
			}
			answer += cnt;
			return;
		}
		
		// ȸ���� �ִ� 3���̹Ƿ� (90, 180, 270) rotate_cnt�� 3���� ������ �ѹ� ȸ���� ������ 1�� ����
		if(rotate_cnt > 0)
			attach(rotate(sticker, r, c), c, r, cnt, rotate_cnt - 1);
	}
	
	// (r, c) ��ġ�� ��ƼĿ�� ���� �� �ִ��� üũ
	static boolean isAttach(int[][] sticker, int r, int c, int sticker_r, int sticker_c) {
		for(int i=0;i<sticker_r;i++) {
			for(int j=0;j<sticker_c;j++) {
				// ������ ����ų� ���̷��� ��ƼĿ�� ĭ�� �̹� ��ƼĿ�� �پ��ִ� ��� false
				if(r + i >= N || c + j >= M || (sticker[i][j] == 1 && notebook[r + i][c + j]))
					return false;
			}
		}
		
		return true;
	}
	
	// �迭�� �ð� �������� 90�� ȸ��
	static int[][] rotate(int[][] arr, int r, int c) {
		int[][] ret = new int[c][r];
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				ret[j][r - 1 - i] = arr[i][j];
			}
		}
		
		return ret;
	}

}
