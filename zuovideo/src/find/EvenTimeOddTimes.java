package find;

public class EvenTimeOddTimes {
    //最后找出数组中出现奇数次的数
    public void printOddTimesNum1(int[] arr){
        int eor=0;
        for (int cur:arr){
            eor^=cur;
        }
        System.out.println(eor);
    }

    public void printOddTimesNum2(int[] arr){
        int eor=0,onlyOne=0;
        for (int curNum:arr){
            eor^=curNum;
        }
        //eor=a^b
        //eor!=0
        //eor必然有一个位置上是1
        int rightOne=eor&(~eor+1);//提取出最右的1
        for (int cur:arr){
            if ((cur&rightOne)==1){//这里等于1或0都可以
                onlyOne^=cur;
            }
        }
        System.out.println(onlyOne+" "+(eor^onlyOne));
   }
}
