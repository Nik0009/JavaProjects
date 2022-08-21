import java.util.Scanner;

class Oprations{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);

System.out.println("Enter 1st no=");
int num1=sc.nextInt();

System.out.println("Enter 2nd no=");
int num2=sc.nextInt();

int sum=num1 + num2;
System.out.println(+num1 +"+"+num2 +"="+sum);

int sub=num1-num2;
System.out.println(+num1 + "-" + num2 + "=" +sub);

int mul=num1*num2;
System.out.println(+num1 + "x" + num2 + "=" +mul);

double div=num1/num2;
System.out.println(+num1 + "/" + num2 + "=" +div);

double mod=num1%num2;
System.out.println(+num1 + "%" + num2 + "=" +mod);
}
}

/*
o/p=
C:\java programs>javac Oprations.java

C:\java programs>java Oprations
Enter 1st no=
1
Enter 2nd no=
2
1+2=3
1-2=-1
1x2=2
1/2=0.0
1%2=1.0

*/
