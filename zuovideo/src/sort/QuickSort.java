package sort;

//quickSort 3.0版本的时间复杂度为O(N*logN),空间复杂度为O(logN)
//空间复杂度最坏为O(N),最好为O(logN),通过概率的计算得到平均为O(logN)的水平(我们不可证)
public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    //arr[l..r]排好序
    public static void quickSort(int[] arr,int L,int R){
        if (L<R){
            swap(arr,L+(int)(Math.random()*(R-L+1)),R);
            int[] p=partition(arr,L,R);
            quickSort(arr,L,p[0]-1); //<区
            quickSort(arr,p[1]+1,R); //>区
        }
    }

    //这是一个处理arr[l..r]的函数
    //默认以arr[r]做划分，arr[r]->p   <p ==p >p
    //返回等于区域(左边界，右边界)，所以返回一个长度为2的数组res, res[0] res[1]
    public static int[] partition(int[] arr,int L,int R){
        int less=L-1; //<区右边界
        int more=R; //>区左边界
        while (L<more){ //L表示当前数的位置 arr[R]->划分值
            if (arr[L]<arr[R]){//当前数<划分值
                swap(arr,++less,L++);
            }else if (arr[L]>arr[R]){//当前数>划分值
                swap(arr,--more,L);
            }else {
                L++;
            }
        }
        swap(arr,more,R);
        return new int[] {less+1,more};
    }

    public static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
