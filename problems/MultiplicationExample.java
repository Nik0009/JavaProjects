import java.util.Scanner;

public class MultiplicationExample
{
public static void main(String args[])
{
int i,j,k=0;
Scanner obj1=new Scanner(System.in);

System.out.println("Enter the first no:");
int firstno=obj1.nextInt();

System.out.println("Enter the second no:");
int secondno=obj1.nextInt();

k=firstno*secondno;
System.out.println(+firstno +"x" +secondno +"=" +k);

}
}

/*
o/p=
C:\java programs>java MultiplicationExample
Enter the first no:
1
Enter the second no:
2
1x2=2

*/