package find;

import java.util.HashMap;
import java.util.Map;

public class WaterKing {
    //遍历哈希表，则可知道是否有水王数，以及水王数是谁
    //该方法不符合题目的限制，因为使用了哈希表，所以额外空间复杂度O(N)
    //但是该方法功能正确，仅作为对数器使用，用于验证下面的waterKing方法
    public static int verify(int[] arr) {
        if(arr==null||arr.length==0){
            return -1;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num:arr
             ) {
            if (map.containsKey(num))
                map.put(num, map.get(num)+1);
            map.put(num,1);
        }
        int N= arr.length;
        for (Map.Entry<Integer,Integer> record:map.entrySet()
             ) {
            if (record.getValue()>(N>>1))
                return record.getKey();
        }
        return -1;
    }

    //真正想实现的方法
    public static int waterKing(int[] arr){
        if (arr==null||arr.length==0)
            return -1;
        int candidate=0;
        int restHP=0;
        for (int cur:arr
             ) {
            if(restHP==0){//如果没有候选
                candidate=cur;
                restHP=1;
            }else if(cur!=candidate)//如果有候选，并且当前的数字和候选数字不同
                restHP--;
            else //如果有候选，并且当前的数字和候选的一样
            restHP++;
        }
        //如果遍历完成后，没有候选留下来，说明没有水王数
        if(restHP==0)
            return -1;
        //如果有候选留下来，再去遍历一遍，得到候选真正出现的次数
        int count=0;
        for (int num:arr
             ) {
            if (num==candidate)
                count++;
        }
        int N= arr.length;
        //如果候选真正出现的次数大于N/2,返回候选
        //否则返回-1代表没有水王数
        return count>(N>>1)?candidate:-1;
    }

}