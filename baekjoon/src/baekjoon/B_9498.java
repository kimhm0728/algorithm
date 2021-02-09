package baekjoon;
import java.util.Scanner;

public class B_9498 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int grade=sc.nextInt();
        String g;
        if(grade>=90&&grade<=100)
            g="A";
        else if(grade>=80&&grade<=89)
            g="B";
        else if(grade>=70&&grade<=79)
            g="C";
        else if(grade>=60&&grade<=69)
            g="D";
        else
            g="F";
        System.out.println(g);
        sc.close();
    }
}