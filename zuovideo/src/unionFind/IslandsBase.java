package unionFind;

public class IslandsBase {
    public static int countIslands(int[][] arr){
        if (arr==null||arr[0]==null){
            return 0;
        }
        int row=arr.length;
        int column=arr[0].length;
        int res=0;
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                if (arr[i][j]==1){
                    res++;
                    infect(arr,i,j,row,column);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] arr,int i,int j,int row,int column){
        if (i<0||i>=row||j<0||j>=column||arr[i][j]!=1){
            return;
        }
        //i,j没越界，并且当前位置值是1
        arr[i][j]=2;
        infect(arr,i-1,j,row,column);
        infect(arr,i+1,j,row,column);
        infect(arr,i,j-1,row,column);
        infect(arr,i,j+1,row,column);
    }


}
