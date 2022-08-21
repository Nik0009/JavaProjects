class Employe{
private String username;
private String nickname;
private int id;

public String getName()
{
return username;
}

public String getNickName()
{
return nickname;
}

public int getid(){
return id;
}

public void setName(String a){
username=a;
}

public void setNickName(String b){
nickname=b;
}

public void setid(int c){
id=c;
}
}
public class ClassTest{
public static void main(String[] args){
Employe obj=new Employe();

obj.setName("nik");
obj.setNickName("m");
obj.setid(7);

System.out.println(obj.getName());
System.out.println(obj.getNickName());
System.out.println(obj.getid());
}
}