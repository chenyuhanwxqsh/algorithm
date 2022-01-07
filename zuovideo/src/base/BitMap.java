package base;

/*
位图
 */
public class BitMap {
    //可以用基础类型的东西做出比特类型的东西，无非就是用位运算，可实现各种操作
    public static void main(String[] args) {
        int a=0;

        //a 32 bit

        int[] arr=new int[10];//32bit*10 -> 320bits

        //arr[0] int 0~31
        //arr[1] int 32~63
        //arr[2] int 64~95

        int i=178;//想取得第178个bit的状态

        int numIndex=178/32;//先定位到在哪个arr[?]上找
        int bitIndex=178%32;//在哪位上

        //拿到178位的状态
        int s=((arr[numIndex]>>(bitIndex))&1);
        //arr[mumIndex]>>(bitIndex) 这个数右移bitIndex位，则跑到这个数的最右侧位置
        //然后把它和1&之后，得到第178个bit的状态

        //把178位的状态改成1
        arr[numIndex]=arr[numIndex]|(1<<(bitIndex));

        //把178位的状态改成0
        arr[numIndex]=arr[numIndex]&(~(1<<bitIndex));

        //把178位的状态拿出来
        //bit 0 1
        int bit =(arr[i/32]>>(i%32))&1;
    }
}
