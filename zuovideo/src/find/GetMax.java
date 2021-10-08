package find;

public class GetMax {
    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    /**
     *这个递归行为符合master公式，可以直接通过公式求出时间复杂度
     *    整个递归过程就是一个多叉树，计算所有树的节点的过程就是利用栈玩了一个后序遍历，每个节点都通过自己的
     *  子节点给自己汇总信息之后才能向上返回，栈总空间就是整个树的高度，只用在一个高度上压栈，这就是所谓的递归的过程
     */
    //arr[L..R]范围上求最大值
    public static int process(int[] arr,int L,int R){
        if (L==R){
            //arr[L..R]范围上只有一个数，直接返回，base case
            return arr[L];
        }
        int mid=L+((R-L)>>1);//中点
        int leftMax=process(arr,L,mid);
        int rightMax=process(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }
}
