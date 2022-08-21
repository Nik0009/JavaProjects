import java.util.Scanner;

public class Table{
public static void main(String args[]){
Scanner in=new Scanner(System.in);

System.out.println("Enter no");
int num=in.nextInt();

for(int i=1;i<=10;i++){

int t=num*i;

System.out.println(+num + "x" +i + "=" + t);
}
}
}
/*
o/p=
C:\java programs>javac Table.java

C:\java programs>java Table
Enter no
1
1x1=1
1x2=2
1x3=3
1x4=4
1x5=5
1x6=6
1x7=7
1x8=8
1x9=9
1x10=10

*/