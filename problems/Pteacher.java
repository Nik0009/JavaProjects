class Teacher{
String designation="teacher";
String collegeName="GCOEC";
void does(){
System.out.println("Teaching");
}
void hello(){
System.out.println("hello");
}
}

public class Pteacher extends Teacher {
String subject="physics";
public static void main(String args[]){
Pteacher obj= new Pteacher();
System.out.println(obj.collegeName);
System.out.println(obj.designation);
System.out.println(obj.subject);
obj.does();
obj.hello();
}
}

/*
o/p-

C:\java programs>javac Pteacher.java

C:\java programs>java Pteacher
GCOEC
teacher
physics
Teaching

*/