public class Website{
String webname;
int webage;

//constructor

Website(String name,int age){
this.webname=name;
this.webage=age;
}

Website()
{
this.webname="yahoo";
this.webage=10;
}

public static void main(String args[])
{
Website obj1=new Website ();
Website obj2=new Website("Google",5);
System.out.println(obj1.webname);
System.out.println(obj1.webage);
System.out.println(obj2.webname);
System.out.println(obj2.webage);
}
}

/*
o/p=
C:\java programs>java Website
yahoo
10
Google
5

*/