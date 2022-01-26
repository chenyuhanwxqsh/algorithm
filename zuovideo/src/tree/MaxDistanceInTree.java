package tree;

public class MaxDistanceInTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value=data;
        }
    }

    public static int maxDistanceInTree(Node head){
        return process(head).maxDistance;
    }

    public static class Info{
        public int maxDistance;
        public int height;
        public Info(int dis,int h){
            maxDistance=dis;
            height=h;
        }
    }

    //返回以node为头的整棵树的俩个信息
    public static Info process(Node node){
        if (node==null){
            return new Info(0,0);
        }
        Info leftInfo=process(node.left);
        Info rightInfo=process(node.right);

        //info
        int p1= leftInfo.maxDistance;
        int p2=rightInfo.maxDistance;
        int p3= leftInfo.height+ rightInfo.height+1;
        int maxDistance=Math.max(p3,Math.max(p1,p2));
        int height=Math.max(leftInfo.height,rightInfo.height)+1;

        return new Info(maxDistance,height);
    }
}
