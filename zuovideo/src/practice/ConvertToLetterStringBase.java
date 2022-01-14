package practice;

public class ConvertToLetterStringBase {

    // str只含有数字字符0~9
    // 返回多少种转化方案
    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    //i之前的位置，如何转化已经做过决定了
    //i...有多少种转化的结果
    public static int process(char[] str,int i){
        if (i==str.length){
            return 1;
        }
        if (str[i]=='0'){
            return 0;
        }
        if (str[i]=='1'){
            int res=process(str,i+1);//i自己作为单独的部分，后续有多少种方法
            if (i+1<str.length){
                res+=process(str,i+2);//(i和i+1)作为单独的部分,后续有多少种方法
            }
            return res;
        }
        if (str[i]=='2'){
            int res=process(str,i+1);//i自己作为单独的部分，后续有多少种方法
            //(i和i+1)作为单独的部分并且没有超过26,后续有多少种方法
            if (i+1<str.length&&(str[i+1]>='0'&&str[i+1]<='6')){
                res+=process(str,i+2);
            }
            return res;
        }
        return process(str,i+1);
    }

    public static void main(String[] args) {
        System.out.println(number("11111"));
    }
}
