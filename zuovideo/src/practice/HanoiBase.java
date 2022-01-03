package practice;

public class HanoiBase {
    public static void hanoi(int n){
        if (n>0){
            func(n,"左","右","中");
        }
    }

    //i~1圆盘目标是from->to,other是另外一个
    public static void func(int i,String start,String end,String other){
        if (i==1){//base case
            System.out.println("Move 1 from "+start+" to "+end);
        }else {
            func(i-1,start,other,end);
            System.out.println("Move "+i+" from "+start+" to "+end);
            func(i-1,other,end,start);
        }
    }

    public static void main(String[] args) {
        int n=3;
        hanoi(n);
    }
}
