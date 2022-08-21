class ArrEx2{
static void arr(int min[]){
int min=arr[0];
for(int i=1;i<arr.length;i++){
if(min>arr[i]){
min=arr[i];
}
}
System.out.println(min);
}
public static void main(String args[]){
int min[]={1,2,3,4,76,8};
arr(min);

}
}