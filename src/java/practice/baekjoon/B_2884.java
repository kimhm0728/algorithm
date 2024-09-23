package java.practice.baekjoon;
import java.util.Scanner;

public class B_2884{
    public static void main(String[] args){
        Scanner stdin=new Scanner(System.in);
        int H=stdin.nextInt();
        int M=stdin.nextInt();
        if(M>=45){
            M-=45;
        }
        else {
            if(H==0){
                H=23;
                M=M-45+60;
            }
            else {
                H-=1;
                M=M-45+60;
            }
        }
        System.out.print(H+" "+M);
        stdin.close();
    }
}