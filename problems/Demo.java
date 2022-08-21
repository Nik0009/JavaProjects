import java.util.Scanner; 

class Demo{
public static void main(String args []){
int num;
Scanner sc= new Scanner(System.in);
System.out.println("Enter no. :");
num=sc.nextInt();
if(num>0){
System.out.println("the number is positive.");
}
else {
System.out.println("the no is negative.");
}
}
}