package backTracking;

import java.util.*;
import java.io.*;

public class B_1799 {
    static int N;
    static int[][] board;
    static boolean[][] visit;
    static int white = 0, black = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        visit = new boolean[N][N];
        
        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) 
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        
        whiteDFS(0, 0, 0);
        blackDFS(0, 1, 0);
        System.out.println(white + black);
    }
    
    static void whiteDFS(int r, int c, int cnt) {
        if(r == N - 1 && c >= N) {
            white = Math.max(white, cnt);
            return;
        }
        
        if(c >= N) {
            r++;
            c = r % 2 == 0 ? 0 : 1;
        }
        
        if(board[r][c] == 0)
            whiteDFS(r, c + 2, cnt);
        else {
            whiteDFS(r, c + 2, cnt);
            if(check(r, c)) {
                visit[r][c] = true;
                whiteDFS(r, c + 2, cnt + 1);
                visit[r][c] = false;
            }
        }
    }
    
    static void blackDFS(int r, int c, int cnt) {
        if(r == N - 1 && c >= N) {
            black = Math.max(black, cnt);
            return;
        }
        
        if(c >= N) {
            r++;
            c = r % 2 == 0 ? 1 : 0;
        }
        
        if(board[r][c] == 0)
            blackDFS(r, c + 2, cnt);
        else {
            blackDFS(r, c + 2, cnt);
            if(check(r, c)) {
                visit[r][c] = true;
                blackDFS(r, c + 2, cnt + 1);
                visit[r][c] = false;
            }
        }
    }
    
    static boolean check(int r, int c) {
        int R = r, C = c;
        
        while(true) {
            R--;
            C--;
            
            if(R < 0 || C < 0)
                break;
            
            if(visit[R][C])
                return false;
        }
        
        while(true) {
            r--;
            c++;
            
            if(r < 0 || c >= N)
                break;
            
            if(visit[r][c])
                return false;
        }
        
        return true;
    }
}
