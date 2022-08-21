public class ContinueExample1{
public static void main(String args[]) {
for(int i=1;i<=10;i++)
{
if(i==7 || i==8)
{
continue ;
}
System.out.println("i="+i);
}
}
}

/* 
o/p=
C:\java programs>java ContinueExample1
i=1
i=2
i=3
i=4
i=5
i=6
i=9
i=10
 */