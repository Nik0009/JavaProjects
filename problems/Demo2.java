import java.util.Scanner;

class Demo2{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("a :");
int a=sc.nextInt();
System.out.println("b :");
int b=sc.nextInt();
System.out.println("c:");
int c=sc.nextInt();
if(a>b&&a>c){
System.out.println("a is greater no"+a);
}
else if(b>a&&b>c){
System.out.println("b is greater no"+b);
}
else if(c>a&&c>b){
System.out.println("c is greater no"+c);
}
} 
}