abstract class A{
abstract void Method1();

public void Method2(){
System.out.println("method");
}
}
class Abstration1 extends A{
void Method1(){
System.out.println("method is ready");
}
public static void main(String[] args){
Abstration1 obj=new Abstration1();
obj.Method1();
obj.Method2();

}
}