package sort;

public class SmallSum {
    public static int smallSum(int[] arr){
        if (arr==null||arr.length<2){
            return 0;
        }
        return process(arr,0,arr.length-1);
    }

    //arr[L..R]既要排好序，也要求小和
    public static int process(int[] arr,int l,int r){
        if (l==r){
            return 0;
        }
        int mid=l+((r-l)>>1);
        return process(arr,l,mid)  //左侧排序产生小和的数量
                +process(arr,mid+1,r) //加上右侧排序产生小和的数量
                +merge(arr,l,mid,r);    //加上merge时产生小和的数量
    }
    public static int merge(int[] arr,int L,int m,int r){
        int[] help=new int[r-L+1];
        int i=0;
        int p1=L;
        int p2=m+1;
        int res=0;
        while (p1<=m&&p2<=r){
            res+=arr[p1]<arr[p2]?(r-p2+1)*arr[p1]:0; //merge过程中产生小和的行为
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++]; //和原始的merge的唯一区别是必须是左组比右组小的时候才拷贝左组，相等时拷贝右组
        }
        while (p1<=m){
            help[i++]=arr[p1++];
        }
        while (p2<=r){
            help[i++]=arr[p2++];
        }
        for (i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }
        return res;
    }

    //for test

}
