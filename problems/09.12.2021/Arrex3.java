/* Anonymous array example*/

class Arrex3{
static int[] get(){
return new int[] {1,2,3,4,5,6};
}
public static void main(String args[]){
int[] num=get[];
for(int i=0;i<num.length;i++){
System.out.println(num[i]);
}
}
}