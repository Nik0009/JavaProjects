public class B{
public static void main(String args[]){
for(int i=1;i<=3;i++){
for(int j=1;j<=3;j++){
if(i==2&&j==2){
break;
}
System.out.println("i="+i +"j="+j);
}
}
}
}

/*

o/p=
C:\java programs>java B
i=1j=1
i=1j=2
i=2j=1

 */