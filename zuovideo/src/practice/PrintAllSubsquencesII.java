package practice;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsquencesII {
    public static void printAllSubsquence(String str){
        char[] chs=str.toCharArray();
        process(chs,0);
    }

    //当前来到i位置,要和不要，走两条路
    //之前的选择,所形成的结果,是str
    //俩条路是通过char[]空间的复用实现的,比下面那种方法省空间,但时间复杂度是一样的
    /*
    递归函数在进行过程中，所有东西都会保留，在进行子过程中变量一直存在，只是被压到系统桟中保留了，
    当回到父过程中可以还原出来(利用系统栈中临时变量全存下来这种机制，才能最后又复原)
     */
    public static void process(char[] str,int i){
        if (i==str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        process(str,i+1);//要当前字符的路
        char tmp=str[i];
        str[i]=0;
        process(str,i+1);//不要当前字符的路
        str[i]=tmp;
    }

    public static void function(String str){
        char[] chs=str.toCharArray();
        process(chs,0,new ArrayList<Character>());
    }

    //当前来到i位置，要和不要，走两条路
    //res之前的选择，所形成的列表
    public static void process(char[] str, int i, List<Character> res){
        if (i==str.length){
            printList(res);
            return;
        }
        List<Character> resKeep=copyList(res);
        resKeep.add(str[i]);
        process(str, i+1, resKeep);//要当前字符的路
        List<Character> resNoInclude=copyList(res);
        process(str, i+1,resNoInclude);//不要当前字符的路
    }

    public static void printList(List<Character> res){
        //.......;
    }

    public static List<Character> copyList(List<Character> list){
        return null;//之后补充
    }
}
