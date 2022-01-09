package leetcode;

//KMP的时间复杂度为O(N)
public class KMP {
    //str1的长度N >= str2的长度M
    //只是起名写成了getIndexOf方法，实际上并不是，getIndexOf方法比KMP算法更加优化，是KMP的改良版
    public static int getIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int x = 0;
        int y = 0;

        // O(M)
        int[] next = getNextArray(str2);

        // O(N)
        while (x < str1.length && y < str2.length) {
            if (str1[x] == str2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) { //等价于y == 0(即str2中的y已经被推到0位置开始比较,并且0位置已经和x位置进行比较发现不一样,则需要str1的比较往下走换一个开头)
                                        //即str2中比对的位置已经无法往前跳了
                x++;
            } else {
                y = next[y];//str2中的比较还没有推到开头的位置，还有前后缀相同,str1的x还不需要动可以继续比较
            }
        }
        //y越界或者y越界了(y越界说明str1中某一个开头配出了str2)(y没越界说明没有匹配成功)
        //y越界，则x-y代表匹配到的str1中开头的位置
        return y == str2.length ? x - y : -1;
    }

    public static int[] getNextArray(char[] str2) {
        if (str2.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; // 目前在哪个位置上求next数组的值
        int cn = 0; // 当前是哪个位置的值在和i-1位置的字符比较,也代表当前使用的next数组中的信息是多少
        while (i < next.length) {
            if (str2[i - 1] == str2[cn]) { // 配成功的时候
                next[i++] = ++cn;
            } else if (cn > 0) {//当前跳到cn位置的字符，和i-1位置的字符配不上，并且cn还可以往前跳
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        int possibilities = 5;
        int strSize = 20;
        int matchSize = 5;
        int testTimes = 5000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String str = getRandomString(possibilities, strSize);
            String match = getRandomString(possibilities, matchSize);
            if (getIndexOf(str, match) != str.indexOf(match)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }
}
