class Encapsulation{
private int i;

public int geti()
{
return i;
}

public void seti(int s){
i=s;
}
}

class Test{
public static void main(String[] args){
Encapsulation obj=new Encapsulation();
System.out.println();
obj.seti(1);
System.out.println(obj.geti());
}
}