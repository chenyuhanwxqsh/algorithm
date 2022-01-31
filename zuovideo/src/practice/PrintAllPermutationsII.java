package practice;

import java.util.ArrayList;

public class PrintAllPermutationsII {
    public static ArrayList<String> Permutation(String str){
        ArrayList<String> res=new ArrayList<>();
        if (str==null||str.length()==0){
            return res;
        }
        char[] chs=str.toCharArray();
        process(chs,0,res);
        return res;
    }

    //str[i..]范围上，所有的字符，都可以在i位置上，后续都去尝试
    //str[0..i-1]范围上,是之前做的选择
    //请把所有的字符串形成的全排列，加入到res里去
    public static void process(char[] str,int i,ArrayList<String> res){
        if (i==str.length){
            res.add(String.valueOf(str));
        }
        boolean[] visit=new boolean[26];//visit[0 1 ..25]用来去重的数组
        //去重是当字符串中有相同的字符时有用
        for (int j=i;j<str.length;j++) {//在每轮循环中将j位置的数和数组中各个数交换
            if (!visit[str[j] - 'a']) {
                visit[str[j]-'a']=true;
                swap(str, i, j);
                process(str, i + 1, res);
                swap(str, i, j);
            }
        }
        //也可在最后的到res结果之后再去重，但是这样更慢，时间复杂度的指标上没有优化，但是常数项上有优化
    }

    public static void swap(char[] str,int i,int j){
        char tmp=str[i];
        str[i]=str[j];
        str[j]=tmp;
    }
}
